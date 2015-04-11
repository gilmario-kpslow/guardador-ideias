/**
 * Iniciar a aplicação
 * @type Guardador
 */
var baseUrl = "/guardador/";
var baseMenu = "#menu";
var baseScript = "#scripts";
var container = "#formulario";
var menuUtil = new MenuUtil(baseMenu);
var paginador = new PaginaUtil(baseUrl);
var sriptUtil = new ScriptUtil(baseScript);
var menus = [];
menuInicio = new MenuType("inicio");
menuInicio.adicionaFuncoes(function () {
    paginador.carregarPagina('ultimas_ideias', container);
});
menus[0] = menuInicio;
menuCadastroProjeto = new MenuType("Cadastro de Projetos");
menuCadastroProjeto.adicionaFuncoes(function () {
    paginador.carregarPagina('cadastro_projeto', container);
});
menuCadastroProjeto.adicionaFuncoes(function () {
    alert('ok');
});
menus[1] = menuCadastroProjeto;
guardador = new Guardador("/guardador/", menus, "ultimas_ideias", paginador, menuUtil);
guardador.iniciar();
