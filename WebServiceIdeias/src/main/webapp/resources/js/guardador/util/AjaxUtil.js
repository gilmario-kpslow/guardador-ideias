AjaxUtil = (function () {
    this.executa = (function (url, metodo, data, post) {
        $.ajax({
            url: url,
            type: metodo,
            data: data
        }).success(function (data) {
            return data;
        });
    });
});