//
function registrarse(){
    var data = {
        "usuarioNombre" : $("#i_usuario").val() ,
        "usuarioCorreo" : $("#i_correo").val() ,
        "usuarioClave" : calcMD5($("#i_clave").val()),
        "usuarioAvatar" : ''
    };
    if(data.usuarioNombre === '' || data.usuarioCorreo === '' || data.usuarioClave === ''){
        $("#error").html("Debes completar todos los campos para poder continuar.");
    }else{
        if(data.usuarioClave !== calcMD5($("#i_clave_r").val())){
            $("#error").html("Las claves que elegiste no coinciden.");
        }else{
            console.log(data);
            $.ajax({
                url: "services/usuario/signin",
                data: JSON.stringify(data),
                contentType:'application/json ; charset=utf-8',
                dataType : 'json',
                type: 'POST',
                beforeSend: function () {

                },
                success: function (response) {
                    console.log(response);
                    if(response.codigo === 200){
                        localStorage.setItem("usuario" , response.data);
                        window.location.href = "in_session.html";
                    }else{
                        $("#error").html(response.mensaje);
                    }
                }, error: function (response) {
                    console.log(response);
                }
            });
        }
    }
};