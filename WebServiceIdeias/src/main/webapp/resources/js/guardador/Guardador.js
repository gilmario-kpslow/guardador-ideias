Guardador = (function () {
    var baseUrl = "/guardador/";
    var menuUtil = new MenuUtil("menu");

    this.iniciar = (function () {
        menuUtil.criarMenu("Inicio", "carregar('ultimas_ideias', '#formulario');");
        menuUtil.criarMenu("Cadastrar Projeto", "carregar('cadastro_projeto', '#formulario'); carregarScript('projeto/projeto.js');");
    });
});

var guardador = new Guardador();
guardador.iniciar();


