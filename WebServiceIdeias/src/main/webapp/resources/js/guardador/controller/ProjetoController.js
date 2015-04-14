ProjetoController = (function () {
    var ajax = new AjaxUtil();
    /**
     *
     * @type Arguments
     */
    this.salvar = (function () {
        var projeto = this.getProjeto();
        ajax.executa("/guardador/projeto/criar", "POST", "projeto=" + JSON.stringify(projeto), function (dados) {
            alert(dados);
        });
    });

    this.getProjeto = (function () {
        var projeto = new Projeto();
        projeto.setNome($("#nome").val());
        projeto.setId($("#id").val());
        projeto.setStatus("Aguardando");
        return projeto;
    });
});
controller = new ProjetoController();
