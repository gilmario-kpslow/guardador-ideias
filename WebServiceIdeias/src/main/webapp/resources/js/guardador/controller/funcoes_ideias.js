/**
 * Mostrar as Ideias cadastradas
 * @returns {undefined}
 */
mostraIdeias = (function (ideias, tabela) {
    try {
        var resultado = JSON.parse(ideias);
        var tabela_conteudo = $("#" + tabela).html("");
        $.each(resultado, function (i, ideia) {
            tabela_conteudo.append("<tr> "
                    + "<td>" + ideia.titulo + "</td>"
                    + "<td>" + ideia.projeto.nome + "</td>"
                    + "<td>" + ideia.data + "</td>"
                    + "</tr>");
        });
    } catch (e) {
        $("#" + tabela).html("");
        $("#erro").html(ideias);
        $("#erro").append(e);
        mensagem("Nehuma nota encontrada", 1);
    }
});

/**
 *
 * @param {type} pagina
 * @returns {undefined}
 */
consultarIdeias = (function () {
    $.ajax({
        url: baseUrl,
        type: 'POST'
    }).success(function (dados) {
        mostraIdeias(dados, "tabela_ideias");
    });
});
