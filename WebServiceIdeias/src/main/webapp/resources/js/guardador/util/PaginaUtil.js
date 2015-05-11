PaginaUtil = (function (url) {
    var baseUrl = url;
    var carregador = "pagina";
    var ajax = new AjaxUtil();
    this.carregarPagina = (function (pagina, conteiner, pos) {
        ajax.executa(baseUrl + "/" + carregador + "/" + pagina, "POST", "",
                function (retorno) {
                    $(conteiner).html(retorno);
                    if (pos != undefined) {
                        pos();
                    }
                });

    });
});




