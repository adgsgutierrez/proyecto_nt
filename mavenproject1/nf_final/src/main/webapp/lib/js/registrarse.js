//
function registrarse(){
    var data = {
        "nombre" : $("#i_usuario").val() ,
        "usuario" : $("#i_correo").val() ,
        "clave" : calcMD5($("#i_clave").val()),
        "avatar" : ''
    };
    if(data.nombre === '' || data.correo === '' || data.clave === ''){
        $("#error").html("Debes completar todos los campos para poder continuar.");
    }else{
        if(data.clave !== calcMD5($("#i_clave_r").val())){
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
        }
    }
};