PaginadorMagico = (function (tabela, cols) {
    var controle = new PaginadorController();
    var colunas = cols;
    var tabela = tabela;
    var view = new PaginadorView();

    this.criar = (function () {
        view.adicionaCabecalho(tabela, colunas);
    });

    this.consultar = (function () {
        view.adicionaTagPaginacao(2, "#paginador", function () {
            controle.anterior();
        }, function () {
            controle.proximo(10);
        }, function () {
            controle.paginar();
        });
        //controle.consultar();

    });

    this.contar = (function (i) {
        this.criarPaginador(i);
        this.paginar(0);
    });
});
