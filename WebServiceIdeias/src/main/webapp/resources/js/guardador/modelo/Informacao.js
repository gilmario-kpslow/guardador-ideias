Informacao = (function (titulo, descricao, tipo) {
    var titulo = titulo;
    var descricao = descricao;
    var tipo = tipo;

    this.getTitulo = (function () {
        return titulo;
    });
    this.getDescricao = (function () {
        return descricao;
    });

    this.getTipo = (function () {
        return tipo;
    });

    this.setTitulo = (function (titulo) {
        this.titulo = titulo;
    });

    this.setDescricao = (function (descricao) {
        this.descricao = descricao;
    });

    this.setTipo = (function (tipo) {
        this.tipo = tipo;
    });

});