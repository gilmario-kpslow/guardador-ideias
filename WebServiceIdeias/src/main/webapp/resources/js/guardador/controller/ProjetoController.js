ProjetoController = (function (men) {
    var ajax = new AjaxUtil();
    var campos = {'#nome': 'input', '#id': 'hidden', '#status': 'hidden'};
    var men = men;
    /**
     *
     * @type Arguments
     */
    this.salvar = (function () {
        if (this.validar()) {
            var projeto = this.getProjeto();
            console.log(JSON.stringify(projeto));
            ajax.executa("/guardador/projeto/criar", "POST", "projeto=" + JSON.stringify(projeto), function (dados) {
                men.mostrarMensagem(new Informacao(dados.titulo, dados.descricao, dados.tipo));
            });
        }
    });

    this.limpar = (function () {
        for (var campo in campos) {
            $(campo).val('');
        }
    });

    this.getProjeto = (function () {
        var projeto = new Projeto();
        projeto.setNome($("#nome").val());
        //projeto.setId($("#id").val());
        projeto.setStatus($("#status").val());
        return projeto;
    });

    this.validar = (function () {
        for (var campo in campos) {
            if (campos[campo] == 'input') {
                mensagemUtil.mostrarMensagem(new Informacao('Campo vazio', 'informe o nome do projeto', 'ATENCAO'));
                $(campo).focus();
                return false;
            }
        }
        return true;
    });


});