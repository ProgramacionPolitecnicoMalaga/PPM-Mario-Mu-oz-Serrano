function desActivarRestaurar() {
    !$("#email").val() ?
        $("#password-submit").attr("disabled", "true") :
        $("#password-submit").removeAttr("disabled");
}

$("#password-submit").click(() => {
    $.ajax({
        type: "POST",
        url: "loginsEmailClave.jsp",
        data: {"email": $("#email").val()},
        dataType: "json"
    }).done(function (response) {
        $(alertForm).html(response.mensaje);
        if (response.status == "ok") $("#login-form-link").click();
    });
});
$("#email").on("input", desActivarRestaurar);
desActivarRestaurar();