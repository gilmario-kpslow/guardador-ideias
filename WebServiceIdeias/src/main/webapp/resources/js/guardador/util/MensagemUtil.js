MensagemUtil = (function () {
    $('body').append("<div id='mensagens'></div>");
    var contexto = $('#mensagens');
    this.mostrarMensagem = (function (informacao) {
        var classe = this.processaClasse(informacao.getTipo());
        var m = "<div class='mensagem " + classe + "' >"
                + "<div class='titulo'>" + informacao.getTitulo()
                + "</div>"
                + "<div class='descricao " + classe + " '>" + informacao.getDescricao() + "</div>"
                + "</div>";
        contexto.append(m);
    });

    this.processaClasse = (function (tipo) {
        switch (tipo) {
            case 'ERRO':
                return 'bg-danger';
            case 'SUCESSO':
                return 'bg-success';
            case 'ATENCAO':
                return 'bg-warning';
            default :
                return 'bg-info';
        }
    });



});