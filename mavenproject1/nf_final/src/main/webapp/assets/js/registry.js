function registrar () {
    var correo = $('[id=correo]').val();
    var usuario = $("[id=name]").val();
    var password = $("[id=pass]").val();
    var password2 = $("[id=pass2]").val();
    if (correo != '' || usuario != '' || password != '' || password2 != '') {
	if (password != password2) {
	    alert('claves no concuerdan, por favor verifique');
	} else {
	    alert('campos vacios, verifique');
	}
    } else {
	postRegistry (correo, usuario, password);
    }
}

function postRegistry (correo, usuario, password) {
    $.ajax({
	url : '/nf_final/services/usuario/registrar?correo='+encodeURIComponent(correo)+"&clave="+encodeURIComponent(password)+'&nombre='+encodeURIComponent(usuario),
	data : {'correo': correo, 'clave' : password, 'usuario' : usuario },
	type : 'POST',
	dataType : 'json',
	success : function(json) {
	    if (json.code == 00){
		loadContent('login');
	    } else {
		console.log(json.message);
	    }
	},
	error : function(xhr, status) {
            console.log('Disculpe, existi� un problema');
	},
	complete: function(xhr, status) {
	    console.log(status);
	}
    });
}
