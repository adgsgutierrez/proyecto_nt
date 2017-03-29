$(document).ready(function(){
    $("#l_usuario").hide();
    $("#l_clave").hide();
    $("#i_usuario").focus(function(){
        $("#l_usuario").show();
    }).focusout(function(){
        if($("#i_usuario").val() == ""){
            $("#l_usuario").hide();
        }
    });
    $("#i_clave").focus(function(){
        $("#l_clave").show();
    }).focusout(function(){
        if($("#i_clave").val() == ""){
            $("#l_clave").hide();
        }
    });
});