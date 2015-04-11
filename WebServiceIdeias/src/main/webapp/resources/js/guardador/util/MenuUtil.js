MenuUtil = (function (raiz) {
    var raiz = raiz;
    this.criarMenu = (function (nome, acao) {
        $("#" + raiz).append("<li><a href='#' onclick=\"" + acao + "\" >" + nome + "</a></li>");
    });
});