Guardador = (function () {
    var baseUrl = "/guardador/";
    container = "#formulario";
    var menuUtil = new MenuUtil("#menu");
    paginador = new PaginaUtil(baseUrl);
    scriptUtil = new ScriptUtil("#extra_script");
    var index = 'ultimas_ideias';
    controller = "";
    mensagemUtil = new MensagemUtil();

    /**
     * Iniciar a aplicação coma acriação dos menus e caregando a pagina inicial
     * @returns {undefined}
     */
    this.iniciar = (function () {
        var menus = [];
        var menuInicio = new MenuType("inicio", [function () {
                paginador.carregarPagina('ultimas_ideias', container);
            }]);
//        menuInicio.adicionaFuncoes();
        menus[0] = menuInicio;
        var menuCadastroProjeto = new MenuType("Cadastro de Projetos", [function () {
                guardador.iniciaCadastroProjeto();
            }]);
        menus[1] = menuCadastroProjeto;
        menus[2] = new MenuType("testeMensagem", [function () {
                mensagemUtil.mostrarMensagem(new Informacao('teste', 'sdfksdhjf', 'sdfsdf'));
            }]);
        menuUtil.criarMenus(menus);
        paginador.carregarPagina(index, "#formulario");
    });

    this.iniciaCadastroProjeto = (function () {
        controller = new ProjetoController(mensagemUtil);
        paginador.carregarPagina('cadastro_projeto', container);
    });

});