/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
MenuType = (function (nome) {
    var nome = nome;
    var funcoes = [];

    this.adicionaFuncoes = (function (funcao) {

        funcoes[funcoes.length] = funcao;
    });

    this.funcoesToString = (function () {
        var nFuncoes = "";
        for (var f in funcoes) {
            var ffs = new String(funcoes[f]);
            nFuncoes += ffs.replace("function () {", "").replace("}", "");
        }
        return nFuncoes;
    });

    this.getNome = (function () {
        return nome;
    });


});


