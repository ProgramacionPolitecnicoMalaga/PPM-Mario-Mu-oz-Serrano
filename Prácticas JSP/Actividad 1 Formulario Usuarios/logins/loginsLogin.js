function desActivarInicioSesion() {
    const activar = $("#username").val() && $("#password").val();
    $("#login-submit").attr("disabled", !activar);
}
$("#username,#password").on("input", desActivarInicioSesion);
$("#login-submit").click(function() {
    $.ajax({
        type: "POST",
        url: "loginsCheck.jsp",
        data: {
            "nick": $("#username").val(),
            "clave": $("#password").val()
        },
        dataType: "json"
    }).done(function (response) {
        if (response.status == "ok") {
            window.location = "" //Pensar donde se quiere redirigir
        } else {
            $("#username,#password").addClass("noValido");
            $(alertForm).html(response.mensaje);
        }
    });
});

desActivarInicioSesion();