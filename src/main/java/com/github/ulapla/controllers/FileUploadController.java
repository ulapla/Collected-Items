package com.github.ulapla.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import com.github.ulapla.model.Item;
import com.github.ulapla.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.ulapla.storage.StorageFileNotFoundException;
import com.github.ulapla.storage.StorageService;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    private final StorageService storageService;
    private ItemService itemService;

    @Autowired
    public FileUploadController(StorageService storageService, ItemService itemService) {
        this.storageService = storageService;
        this.itemService = itemService;
    }

    @GetMapping("add/{id}")
    public String listUploadedFiles(Model model,@PathVariable Long id) throws IOException {

        model.addAttribute("item",itemService.findById(id));
        return "upload";
    }

    @GetMapping("get/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("add")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, Item it) {
        Item item = itemService.findById(it.getId());
        String fileName = storageService.store(file);
        item.setFileName(fileName);
        itemService.saveItem(item);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/api/item/show/"+ item.getId();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
