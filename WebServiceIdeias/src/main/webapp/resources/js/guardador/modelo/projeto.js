projeto = (function () {
    var id;
    var nome;

    this.setId = (function (id) {
        this.id = id;
    });

    this.setNome = (function (nome) {
        this.nome = nome;
    });

    this.getId = (function () {
        return this.id;
    });
    this.getNome = (function () {
        return this.nome;
    });
});