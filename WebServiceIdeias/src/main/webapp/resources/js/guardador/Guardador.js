Guardador = (function () {
    var baseUrl = "/guardador";
    var container = "#formulario";
    var menuUtil = new MenuUtil("#menu");
    var carregaPaginas = new PaginaUtil(baseUrl);
    var index = 'ultimas_ideias';
    var mensagemUtil = new MensagemUtil();

    /**
     * Iniciar a aplicação coma acriação dos menus e caregando a pagina inicial
     * @returns {undefined}
     */
    this.iniciar = (function () {
        var menus = [];
        var menuInicio = new MenuType("inicio", [function () {
                carregaPaginas.carregarPagina('inicio', container);
            }]);
        menus[0] = menuInicio;
        var menuCadastroProjeto = new MenuType("Cadastro de Projetos", [function () {
                var view = new ProjetoView(mensagemUtil);
                carregaPaginas.carregarPagina('cadastro_projeto', container, function () {
                    view.inicializa();
                });
            }]);
        menus[1] = menuCadastroProjeto;
        menus[2] = new MenuType("Cadastro de Ideia", [function () {
                alert('ok');
            }]);
        menuUtil.criarMenus(menus);
        carregaPaginas.carregarPagina(index, "#formulario");
    });

    this.iniciaCadastroIdeia = (function () {
        carregaPaginas.carregarPagina('cadastro_ideia', container);
    });

});