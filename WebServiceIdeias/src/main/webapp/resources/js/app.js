/**
 * Iniciar a aplicação
 * @type Guardador
 */

$(function () {
    guardador = new Guardador();
    guardador.iniciar();
});

teste2 = (function () {

    var m = new MensagemUtil();
    this.destroi = (function () {
        alert('ok');
    });

    var x = function () {
        m.mostrarMensagem(new Informacao("Teste", "TESTE", "SUCESSO"));
    };

    var c = $("<a href='#'></a>");
    c.html("teste");
    c.on("click", function () {
        x();
    });
    $("#teste").append(c);

});


teste = (function () {
    var tag = "#tagPag";
    var colunas = ['Nome', 'Telefone', 'Email'];
    var dados1 = [['Gilmario', '88200034', 'meial@email.com'], ['teste', '987938745', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados2 = [['Tiago', 'sdfsdfsdf', 'meial@email.com'], ['teste', 'sdfsdfsdf', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados3 = [['gilvan', '88200034', 'sdfsdfsdfsdf'], ['teste', '987938745', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados4 = [['gilvan', '88200034', 'sdfsdfsdfsdf'], ['teste', '987938745', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados5 = [['gilvan', '88200034', 'sdfsdfsdfsdf'], ['teste', '987938745', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados6 = [['gilvan', '88200034', 'sdfsdfsdfsdf'], ['teste', '987938745', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados7 = [['gilvan', '88200034', 'sdfsdfsdfsdf'], ['teste', '987938745', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados8 = [['gilvan', '88200034', 'sdfsdfsdfsdf'], ['teste', '987938745', 'meils@email.com'], ['Mails', '93489845', 'email@email.com']];
    var dados = [dados1, dados2, dados3, dados4, dados5, dados6, dados7, dados8];
    //paginador = new PaginadorMagico(tag, colunas, "#tabelaa", function (p) {
//        return dados[p];
//    }, dados.length);
//    paginador.iniciar();


});