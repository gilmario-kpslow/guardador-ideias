ScriptUtil = (function (raiz) {
    var base = raiz;
    this.carregarScripts = (function (scripts) {
        for (var i in scripts) {
            carregarScript(scripts[i]);
        }
    });
    this.carregarScript = (function (script) {
        $(base).append("<script type='text/javascript' src='resources/js/" + script + ".js'></script>");
    });
});