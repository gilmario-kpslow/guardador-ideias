/**
 * Montar o html
 * @returns {undefined
 */
PaginadorView = (function () {

    this.adicionaTagPaginacao = (function (numeroPaginas, tag, voltar, avancar, paginar) {
        var p = $(tag);
        p.html('');
        var anterior = $("<li><span>&laquo;</span></li>");
        anterior.on('click', function () {
            voltar();
        });
        p.append(anterior);
        for (var i = 1; i <= numeroPaginas; i++) {
            var n;
            n.on('click', function (i) {
                paginar(i);
            });
            p.append(n);
        }
        var proximo = $("<li><span>&raquo;</span></li>");
        anterior.on('click', function () {
            avancar();
        });
        p.append(proximo);
    });



    this.adicionaCabecalho = (function (tabela, colunas) {
        var t = $(tabela);
        t.html("");
        var colunasUnidas = "<thead><tr>";
        for (var i = 0; i < colunas.length; i++) {
            colunasUnidas += "<th>" + colunas[i] + "</th>";
        }
        colunasUnidas += "</tr></thead>";
        t.append(colunasUnidas);
    });

});