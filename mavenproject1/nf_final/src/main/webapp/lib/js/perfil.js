/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var usuario = localStorage.getItem('usuario');
    usuario = JSON.parse(usuario);
    console.log(usuario);
    $('#name').val(usuario.usuarioNombre);
    $('#mail').val(usuario.usuarioCorreo);
    $('#avatar').attr('src', usuario.usuarioAvatar);
});

function guardar () {
    usuario.usuarioNombre = $('#name').val();
    usuario.usuarioCorreo = $('#mail').val();
    verificarPass();
}

function agregar () {
    $('#cards').show();
    $('#Agregar').show();
}

function verificarPass() {
   var pass1 = $('#passN').val();
   var pass2 = $('#passVerify').val();
   if (pass1 === pass2 && pass1 !== '' && pass2 !== '') {
       usuario.usuarioClave = pass1;
   Else
       alert('Contraseña nueva Incorrecta');
   }
}

function registrarTarjeta() {
    var numero = $('#numero').val();
    var fecha = $('#fvencimiento').val();
    var cvc = $('#cvc').val();
    var card = {
        'tarjetaNumero': numero,
        'tarjetaCvc': cvc,
        'tarjetaFecha': fecha
    };
    if(card.tarjetaNumero === '' || card.tarjetaCvc === '' || card.tarjetaFecha === ''){
        $("#error").html("Debes completar todos los campos para poder continuar.");
    }else{
        console.log(card);
        $.ajax({
            url: "services/usuario/Tarjetas",
            data: JSON.stringify(card),
            contentType:'application/json ; charset=utf-8',
            dataType : 'json',
            type: 'POST',
            beforeSend: function () {

            },
            success: function (response) {
                console.log(response);
                if(response.codigo === 101){
                    localStorage.setItem("tarjeta" , JSON.stringify(response.tarjeta));
                    window.location.href = "perfil.html";
                }else{
                    $("#error").html(response.mensaje);
                }
            }, error: function (response) {
                console.log(response);
            }
        });
    }
};