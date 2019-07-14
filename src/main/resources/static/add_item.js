$(function () {

    let button = $("button");
    button.on("click", function (e) {
        e.preventDefault()

        let data = {name: $("#name").val(), type: $("#type").val(), description:$("#description").val(), quantity:$("#quantity").val()};

        $.ajax({
            url: 'http://localhost:8081/api/item/add',
            data: JSON.stringify(data),
            contentType: "application/json",
            method: "POST",
            dataType: 'json'
        }).done(function () {
            console.log("ok");
        }).fail(function(xhr,status,err){
            console.log("zle")
        });

    })
})