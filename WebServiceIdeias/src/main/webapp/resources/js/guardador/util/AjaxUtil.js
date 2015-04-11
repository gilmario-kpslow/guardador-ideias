AjaxUtil = (function () {
    this.executa = (function (url, metodo, dados, executarApos) {
        $.ajax({
            url: url,
            type: metodo,
            data: dados
        }).success(function (data) {
            executarApos(data);
        });
    });
});