Projeto = (function () {
    var id;
    var nome;
    var status;

    this.setId = (function (id) {
        this.id = id;
    });
    this.setStatus = (function (status) {
        this.status = status;
    });

    this.setNome = (function (nome) {
        this.nome = nome;
    });

    this.getId = (function () {
        return id;
    });
    this.getNome = (function () {
        return nome;
    });
    this.getStatus = (function () {
        return status;
    });
});