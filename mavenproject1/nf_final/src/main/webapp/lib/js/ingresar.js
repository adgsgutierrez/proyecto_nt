function ingresar() {
    var objectSend = {
        "usuario" : $("#i_correo").val(),
        "clave": calcMD5($("#i_clave").val()),
    };
    if(objectSend.usuario !== '' && objectSend.clave !== ''){
        $.ajax({
            url: "services/usuario/login",
            data: JSON.stringify(objectSend),
            contentType:'application/json ; charset=utf-8',
            dataType : 'json',
            type: 'POST',
            beforeSend: function () {

            },
            success: function (response) {
                console.log(response);
                if(response.codigo === 101){
                    localStorage.setItem("usuario" , JSON.stringify(response.data));
                    window.location.href = "in_session.html";
                }else{
                    $("#error").html(response.mensaje);
                }
            }, error: function (response) {
                console.log(response);
            }
        });
    }else{
        $("#error").html("Debes completar todos los campos para poder continuar.");
    }
}