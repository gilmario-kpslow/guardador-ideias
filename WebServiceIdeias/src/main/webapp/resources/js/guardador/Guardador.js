Guardador = (function () {
    var baseUrl = "/guardador/";
    container = "#formulario";
    var menuUtil = new MenuUtil("#menu");
    paginador = new PaginaUtil(baseUrl);
    scriptUtil = new ScriptUtil("#extra_script");
    var index = 'ultimas_ideias';

    /**
     * Iniciar a aplicação coma acriação dos menus e caregando a pagina inicial
     * @returns {undefined}
     */
    this.iniciar = (function () {
        var menus = [];
        var menuInicio = new MenuType("inicio", [function () {
                paginador.carregarPagina('ultimas_ideias', container);
            }]);
        menuInicio.adicionaFuncoes();
        menus[0] = menuInicio;
        var menuCadastroProjeto = new MenuType("Cadastro de Projetos", [function () {
                paginador.carregarPagina('cadastro_projeto', container);
            }, function () {
                scriptUtil.carregarScript('guardador/modelo/Projeto');
            }, function () {
                scriptUtil.carregarScript('guardador/controller/ProjetoController');
            }]);
        menus[1] = menuCadastroProjeto;
        menuUtil.criarMenus(menus);
        paginador.carregarPagina(index, "#formulario");
    });

});