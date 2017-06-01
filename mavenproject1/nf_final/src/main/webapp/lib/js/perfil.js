/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var usuario = localStorage.getItem('usuario');
    $('#name').val(usuario.usuarioNombre);
    $('#mail').val(usuario.usuarioCorreo);
    $('#avatar').attr('src', usuario.usuarioAvatar);
});

function guardar () {
    usuario.usuarioNombre = $('#name').val();
    usuario.usuarioCorreo = $('#mail').val();
}

function agregar () {
    
}
