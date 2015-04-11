salvarProjeto = (function () {
    $.ajax({
        url: baseUrl + "projeto/salvar",
        type: "POST",
        data: $('#frm_usuario').serialize()
    }).success(function (data) {

    });
});

consultarProjeto = (function () {
    $.ajax({
        url: baseUrl + "projeto/consultar",
        type: "POST"
    }).success(function (data) {
        montarTabelaProjeto(data, "tabela_projeto");
    });
});

montarTabelaProjeto = (function (data, tabela) {

});