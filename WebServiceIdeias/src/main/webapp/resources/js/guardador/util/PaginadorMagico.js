PaginadorMagico = (function (tagPaginador, colunas, idTabela, consultar, numeroPaginas) {
    var tagPaginador = tagPaginador;
    var colunas = colunas;
    var tabela = $(idTabela);
    var consultar = consultar;
    var paginaAtual = 1;
    var numeroPaginas = numeroPaginas;

    this.iniciar = (function () {
        this.criarPaginador();
        this.adicionaCabecalho(tabela);
        this.paginar(paginaAtual);
    });

    this.criarPaginador = (function () {
        var paginador = $(tagPaginador);
        paginador.html('');
        paginador.append("<li onclick='paginador.anterior();'><span>&laquo;</span></li>");
        for (var i = 1; i <= numeroPaginas; i++) {
            if (i === paginaAtual) {
                paginador.append("<li class='active' onclick='paginador.paginar(" + i + ");'><span>" + i + "</span></li>");
            } else {
                paginador.append("<li onclick='paginador.paginar(" + i + ");'><span>" + i + "</span></li>");
            }
        }
        paginador.append("<li onclick='paginador.proximo();'><span>&raquo;</span></li>");
    });

    this.montarTabela = (function (linhas) {
        tabela.children("tbody").remove();
        var conteudo = "<tbody>";
        for (var i = 0; i < linhas.length; i++) {
            conteudo += "<tr>";
            for (var j = 0; j < linhas[i].length; j++) {
                conteudo += "<td>" + linhas[i][j] + "</td>";
            }
            conteudo += "</tr>";
        }
        conteudo += "</tbody>";
        tabela.append(conteudo);
    });

    this.adicionaCabecalho = (function (tabela) {
        tabela.html("");
        var colunasUnidas = "<thead><tr>";
        for (var i = 0; i < colunas.length; i++) {
            colunasUnidas += "<th>" + colunas[i] + "</th>";
        }
        colunasUnidas += "</tr></thead>";
        tabela.append(colunasUnidas);
    });

    this.proximo = (function () {
        if (paginaAtual < numeroPaginas) {
            this.paginar(paginaAtual + 1);
        }
    });

    this.anterior = (function () {
        if (paginaAtual > 1) {
            this.paginar(paginaAtual - 1);
        }
    });
    this.paginar = (function (pagina) {
        paginaAtual = pagina;
        this.criarPaginador();
        this.montarTabela(consultar(pagina - 1));
    });


});

