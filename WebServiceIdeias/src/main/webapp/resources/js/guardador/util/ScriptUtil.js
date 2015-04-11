ScriptUtil = (function (raiz) {
    var base = $("#" + raiz);
    this.carregarScripts = (function (scripts) {
        var i;
        $.each(i, function () {
            base.append("<script type='text/javascript' src='resources/js/" + scripts[i] + ".js'></script>");
        });
    });
    this.carregarScript = (function (script) {
        base.html("<script type='text/javascript' src='resources/js/" + script + ".js'></script>");
    });

});