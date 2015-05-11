PaginadorController = (function () {
    var ajax = new AjaxUtil();
    var paginaAtual = 0;

    this.contar = (function () {
        this.paginar(0);
    });

    this.consultar = (function () {
        console.log("consulta");
    });

    this.proximo = (function (npag) {
        if (paginaAtual < npag) {
            this.paginar(paginaAtual + 1);
        }
    });

    this.anterior = (function () {
        if (paginaAtual > 1) {
            this.paginar(paginaAtual - 1);
        }
    });

    this.paginar = (function (pagina) {
        console.log(pagina);
        this.consultar();
    });

});