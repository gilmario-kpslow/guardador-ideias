PaginadorMagico = (function (tag, colunas, campos) {
    var tagPaginador = tag;

    this.criarPaginador = (function (qtd, paginaAtual) {
        var paginador = $(tag);
        paginador.html('');
        paginador.append("<li onclick='paginador.anterior();'><span>&laquo;</span></li>");
        for (var i in qtd) {
            if (i === paginaAtual) {
                paginador.append("<li class='active' page-index='" + i + "' onclick='paginador.paginar(this," + i + ");'><span>" + i + "</span></li>");
            } else {
                paginador.append("<li page-index='" + i + "' onclick='paginador.paginar(this," + i + ");'><span>" + i + "</span></li>");
            }
        }


    });
    this.montarTabela = (function () {

    });

    this.proximo = (function () {

    });
    this.voltar = (function () {

    });
    this.paginar = (function () {

    });


});

