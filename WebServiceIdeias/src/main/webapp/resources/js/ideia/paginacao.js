$(document).ready(function () {
    consultar(0);
    $('#btnConsultar').click(function () {
        contadorNotas(0);
        consultar(0);
    });
});

contadorNotas = (function (pagina) {
    $.ajax({
        url: "/nfses/nota/totalnotas",
        type: 'POST',
        data: $("#form").serialize()
    }).success(function (resultado) {
        criarPaginador((resultado < 10 ? 1 : (parseInt(resultado / 10) + 1)), $(".pagination"), "", null, pagina);
    });
});

montarTabela = (function (dados, tabela) {
    try {
        var resultado = JSON.parse(dados);
        var tabela_conteudo = $("#" + tabela).html("");
        $.each(resultado, function (i, consulta) {
            tabela_conteudo.append("<tr " + (consulta.nota.estado == 'C' ? " class='text-danger' " : '') + " > "
                    + "<td>" + consulta.nota.numero + " / " + consulta.modelo.descricao + "</td>"
                    + "<td>" + formataData(consulta.nota.dataEmissao) + "</td>"
                    + "<td>" + formataCNPJCPF(consulta.nota.cpfCnpjTomador) + "</td>"
                    + "<td>" + consulta.nota.nomeTomador + "</td>"
                    + "<td class='text-right'>" + formataDinheiro(consulta.nota.valorTotal) + "</td>"
                    + "<td class='icone-tabela'>"
                    + (consulta.cancelar == 'true' ? "<a href='#' numero='" + consulta.nota.numero + "' modelo='" + consulta.nota.modelo + "' title='Cancelar Nota' class='cancelar glyphicon glyphicon-remove' onclick='cancelarNota(this);'> </a> " : "")
                    + " <a title='Gerar Impressão' href='/nfses/nota/imprimir/" + consulta.link + "' target='_blank' class='glyphicon glyphicon-print'> </a> "
                    + " <a title='Gerar Impressão PDF' href='/nfses/nota/imprimirPDF/" + consulta.link + "' target='_blank' class='glyphicon glyphicon-file'> </a></td>"
                    + "</tr>");
        });
    } catch (e) {
        $("#" + tabela).html("");
        $("#erro").html(dados);
        $("#erro").append(e);
        mensagem("Nehuma nota encontrada", 1);
    }

});

criarPaginador = (function (qtd, sel, actionPrefix, labels, pagina) {
    sel.html("");
    sel.append("<li onclick='anterior" + actionPrefix + "();'><span>&laquo;</span></li>");
    for (var i = 0; i < qtd; i++) {
        var nome = labels == null ? (i + 1) : labels[i];
        if (i === pagina) {
            sel.append("<li class='active' page-index='" + i + "' onclick='paginar" + actionPrefix + "(this," + i + ");' ><span>" + nome + "</span></li>");
        } else {
            sel.append("<li onclick='paginar" + actionPrefix + "(this," + i + ");' page-index='" + i + "'><span>" + nome + "</span></li>");
        }
    }
    sel.append("<li onclick='proximo" + actionPrefix + "();'><span>&raquo;</span></li>");
});

proximo = (function () {
    var paginas = $(".pagination").children();
    var paginaSel = $(".pagination").children(".active")[0];
    var pag = parseInt($(paginaSel).attr("page-index")) + 1;
    var max = paginas.length - 2;
    if (pag < max) {
        var sel = paginas[(pag + 1)];
        paginar(sel, pag);
    }
});

anterior = (function () {
    var paginas = $(".pagination").children();
    var paginaSel = $(".pagination").children(".active")[0];
    var pag = parseInt($(paginaSel).attr("page-index"));
    if (pag > 0) {
        var sel = paginas[(pag)];
        paginar(sel, (pag - 1));
    }
});

paginar = (function (sel, pagina) {
    if ($(sel).attr("class") != 'active') {
        corrigePaginacao($(sel));
        consultar(pagina);
    }
});

consultar = (function (pagina) {
    $.ajax({
        url: "/nfses/nota/consulta",
        type: 'POST',
        data: jQuery("#form").serialize() + "&& tamanho=10 && inicio=" + (pagina * 10) + "&&ajax=true"
    }).success(function (dados) {
        contadorNotas(pagina);
        montarTabela(dados, "tabela");
    });
});

corrigePaginacao = (function (sel) {
    sel.parent().children().removeClass('active');
});