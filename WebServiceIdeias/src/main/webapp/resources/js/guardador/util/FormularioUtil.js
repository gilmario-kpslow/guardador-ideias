FormularioUtil = (function () {

    this.limparFormulario = (function (campos) {
        for (var campo in campos) {
            if (campos[campo] == 'input') {
                $(campo).val('');
            }
        }
    });
});


