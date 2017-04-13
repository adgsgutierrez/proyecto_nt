$(document).ready(function(){
  /** Funcionamiento de los placeholder **/
    $("#l_usuario").hide();
    $("#l_clave").hide();
    $("#l_correo").hide();
    $("#l_clave_r").hide();

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

    $("#i_correo").focus(function(){
        $("#l_correo").show();
    }).focusout(function(){
        if($("#i_correo").val() == ""){
            $("#l_correo").hide();
        }
    });

    $("#i_clave_r").focus(function(){
        $("#l_clave_r").show();
    }).focusout(function(){
        if($("#i_clave_r").val() == ""){
            $("#l_clave_r").hide();
        }
    });
});
