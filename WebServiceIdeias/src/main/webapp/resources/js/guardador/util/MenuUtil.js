MenuUtil = (function (raiz) {
    var raiz = raiz;
    this.criarMenu = (function (menu) {
        $(raiz).append("<li><a href='#' onclick=\"" + menu.funcoesToString() + "\" >" + menu.getNome() + "</a></li>");
    });
    this.criarMenus = (function (array) {
        for (var i in array) {
            this.criarMenu(array[i]);
        }
    });

});