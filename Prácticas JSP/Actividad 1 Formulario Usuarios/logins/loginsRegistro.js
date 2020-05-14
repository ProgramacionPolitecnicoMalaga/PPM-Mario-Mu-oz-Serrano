let idInsertado = 0;
let imgEnBase64 = "";


$("#txtNick,#txtEmail").blur(function() {
    if (idInsertado == 0) $.ajax({
        type: "POST",
        url: "loginsInsertarFantasma.jsp",
        data: {"nick": $("#txtNick").val(), "email": $("#txtEmail").val()},
        dataType: "json"
    }).done(response => {
        const campos = $("#txtNick,#txtEmail");
    response.status == "ok" ?
        $(campos).removeClass("noValido").addClass("valido") :
        $(campos).removeClass("valido").addClass("noValido");
    idInsertado = response.idInsertado;
});
});

$("#txtFile").change(function() {
    const lector = new FileReader();
    const archivo = $("#txtFile")[0].files[0];
    lector.onload = function (evento) {
        imgEnBase64 = btoa(evento.target.result);
        $("#imgSeleccionada").attr("src", `data:${archivo.type};base64,${imgEnBase64}`);
        $("#txtFile").addClass("valido");
    };
    lector.readAsBinaryString(archivo);
});

$("#txtNombre,#txtApellidos").on("input", e => {
    const campo = e.target;
if ($(campo).val()) {
    $(campo).removeClass("noValido").addClass("valido");
} else {
    $(campo).removeClass("valido").addClass("noValido");
}
});

const clave = $("#txtPassword,#txtConfirm-password");

$(clave).on("input", () => {
    const primera = $("#txtPassword").val();
const segunda = $("#txtConfirm-password").val();
if (primera == segunda) {
    $(clave).removeClass("noValido").addClass("valido");
} else {
    $(clave).removeClass("valido").addClass("noValido");
}
});

$("#register-submit").click(evento => {
    evento.preventDefault();

const [a, _, ...inputs] = Object.values($("#register-form").children().children("input")).reverse();
inputs.reverse();
const todosValidos = inputs.every(function (campo) {
    return $(campo).val() && $(campo).hasClass("valido");
});
const veredicto = todosValidos && imgEnBase64;

if (veredicto) {
    $.ajax({
        type: "POST",
        url: "loginsCompletarInsercion.jsp",
        data: {
            "nomape": $("#txtNombre").val() + " " + $("#txtApellidos").val(),
            "clave": $("#txtPassword").val(),
            "photo": $("#imgSeleccionada").attr("src"),
            "idUsuario": idInsertado
        },
        dataType: "json"
    }).done(function (response) {
        if (response.status == "ok") {
            $("#login-form-link").click();
            $(".valido").val("");
        } else {
            alert(response.mensaje);
        }
    });
}
});