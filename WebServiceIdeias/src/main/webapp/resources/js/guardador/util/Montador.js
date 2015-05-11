Montador = (function () {

    this.montarTabela = (function (linhas, t, geraLinha) {
        var tabela = $(t);
        tabela.children("tbody").remove();
        var conteudo = "<tbody>";
        for (var i = 0; i < linhas.length; i++) {
            var o = linhas[i];
            conteudo += geraLinha(o);
        }
        conteudo += "</tbody>";
        tabela.append(conteudo);
    });

});


