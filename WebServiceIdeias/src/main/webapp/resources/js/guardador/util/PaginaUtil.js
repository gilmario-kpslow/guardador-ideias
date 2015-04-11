PaginaUtil = (function (url) {
    var baseUrl = url;
    var carregador = "pagina";
    var ajax = new AjaxUtil();
    this.carregarPagina = (function (pagina, conteiner) {
        ajax.executa(baseUrl + carregador, "POST", "pagina=" + pagina, function (retorno) {
            $(conteiner).html(new String(retorno));
        });
    });
});




