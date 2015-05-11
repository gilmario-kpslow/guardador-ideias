ProjetoView = (function (men) {
    var controller = new ProjetoController(men);
    var ajax = new AjaxUtil();
    this.inicializa = (function () {
        $("#btn").on("click", function () {
            controller.salvar();
        });
        $("#consultar").on("click", function () {
            controller.consultar();
        });

        var paginador = new PaginadorMagico("#tabela_projetos", ['Id', 'Nome', 'Status']);
        paginador.criar();
        //controller.executarConsulta(paginador);
    });



});