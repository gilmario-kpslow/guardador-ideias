AjaxUtil = (function () {
    this.executa = (function (url, metodo, dados, executarApos) {
        $.ajax({
            url: url,
            type: metodo,
            data: dados,
            async: true
        }).success(function (data) {
            executarApos(data);
        });
    });
});