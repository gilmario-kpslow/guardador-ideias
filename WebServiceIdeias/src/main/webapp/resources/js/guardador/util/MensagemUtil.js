MensagemUtil = (function () {
    $('body').append("<div id='mensagens'></div>");
    var contexto = $('#mensagens');
    this.mostrarMensagem = (function (informacao) {
        var m = "<div class='mensagem'>" + informacao.getTitulo() + "</div>";
        contexto.append(m);
    });



});