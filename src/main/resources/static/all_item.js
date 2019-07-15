$(function () {
    let table = $("table");

    let readAll = function () {
        $.ajax({
            url: "http://localhost:8081/api/item/get/all",
            method: "GET"
        }).done(function (resp) {
            resp.forEach(function (item) {
                let newTr = $(`<tr>
                                    <td><a href="http://localhost:8081/api/item/add">${item.name}</a></td> 
                                    <td>${item.type}</td>
                                    <td>${item.description}</td>
                                    <td>${item.quantity}</td> 
                                    <td>${item.locations}</td>
                              </tr>  `);
                table.append(newTr);
            });
        }).fail(function () {
            console.log("zle")
        });
    }
    readAll();
})
