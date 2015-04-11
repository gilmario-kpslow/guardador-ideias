Guardador = (function (url, menus, index, paginador, menuUtil) {
    var baseUrl = url;
    var menus = menus;
    var index = index;
    var menuUtil = menuUtil;
    var paginaUtil = paginador;


    /**
     * Iniciar a aplicação coma acriação dos menus e caregando a pagina inicial
     * @returns {undefined}
     */
    this.iniciar = (function () {
        menuUtil.criarMenus(menus);
        paginaUtil.carregarPagina(index, "#formulario");
    });
});