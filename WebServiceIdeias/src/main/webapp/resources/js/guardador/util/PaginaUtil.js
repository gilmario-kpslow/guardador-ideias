PaginaUtil = (function () {
    this.carregarPagina = (function (pagina, conteiner, url) {
        $.ajax({
            url: url,
            type: "POST",
            data: "pagina=" + pagina
        }).success(function (data) {
            $(conteiner).html(new String(data));
        });
    });
});



