ProjetoController = (function (men) {
    var ajax = new AjaxUtil();
    var campos = {'#nome': 'input', '#id': 'hidden', '#status': 'hidden'};
    var men = men;
    var formUtil = new FormularioUtil();

    this.consultar = (function () {

    });


    this.salvar = (function () {
        if (this.validar()) {
            var projeto = this.getProjeto();
            ajax.executa("/guardador/projeto/criar", "POST", "projeto=" + JSON.stringify(projeto), function (dados) {
                men.mostrarMensagem(new Informacao(dados.titulo, dados.descricao, dados.tipo));
                formUtil.limparFormulario(campos);
            });
        }
    });

    this.getProjeto = (function () {
        var projeto = new Projeto();
        projeto.setNome($("#nome").val());
        if ($("#id").val() != '') {
            projeto.setId($("#id").val());
        }
        projeto.setStatus($("#status").val());
        return projeto;
    });

    this.validar = (function () {
        for (var campo in campos) {
            if (campos[campo] === 'input') {
                if ($(campo).val() == '') {
                    men.mostrarMensagem(new Informacao('Campo vazio', 'informe o nome do projeto', 'ATENCAO'));
                    $(campo).focus();
                    return false;
                }
            }
        }
        return true;
    });

    this.geraLinha = (function (projeto) {
        return "<tr><td>" + projeto.id + "</td><td>" + projeto.nome + "</td></tr>";
    });

    this.executarConsulta = (function (paginador) {
        ajax.executa("/guardador/projeto/contar", 'POST', "parametrosContador", function (i) {
            paginador.iniciar(i.resultado);
        });
    });
});