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
        $.each(contexto.children('.mensagem'), function (i, o) {
            var obj = $(o);
            obj.animate({"margin-left": "+=10px"}, 400)
                    .animate({"margin-left": "-=10px"}, 1000)
                    .animate({"margin-left": "+=10px", opacity: 1}, 500)
                    .animate({opacity: 0.5}, 2000, function () {
                        obj.slideUp(2000);
                    });
        });
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