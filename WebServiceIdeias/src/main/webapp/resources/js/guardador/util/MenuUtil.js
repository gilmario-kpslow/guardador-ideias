MenuUtil = (function (raiz) {
    var raiz = raiz;
    this.criarMenu = (function (menu) {
        var m = $("<li><a href='#'>" + menu.getNome() + " </a></li>");
        var array = menu.getFuncoes();
        for (var i = 0; i < array.length; i++) {
            var f = array[i];
            m.on("click", function () {
                f();
            });
        }
        $(raiz).append(m);
    });
    this.criarMenus = (function (array) {
        for (var i in array) {
            this.criarMenu(array[i]);
        }
    });

});