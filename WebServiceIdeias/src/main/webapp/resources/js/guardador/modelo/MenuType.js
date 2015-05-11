/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
MenuType = (function (nome, funcoes) {
    var nome = nome;
    var funcoes = funcoes;

    this.adicionaFuncoes = (function (funcao) {
        funcoes[funcoes.length] = funcao;
    });

    this.getFuncoes = (function () {
        return funcoes;
    });

    this.getNome = (function () {
        return nome;
    });


});


