function registrar () {
    var correo = $("#i_email").val();
    var usuario = $("#i_name").val();
    var password = $("#i_pwd_1").val();
    var password2 = $("#i_pwd_2").val();
    if (correo != '' || usuario != '' || password != '' || password2 != '') {
	if (password != password2) {
	    alert('claves no concuerdan, por favor verifique');
	} else {
            console.log();
	    postRegistry (correo, usuario, password);
	}
    } else {
        alert('campos vacios, verifique');
    }
}

function postRegistry (correo, usuario, password) {
    var dat = {"correo": encodeURIComponent(correo), "clave" : encodeURIComponent(password), "nombre" : encodeURIComponent(usuario) };
    console.log(dat);
    $.ajax({
	url : '/nf_final/services/usuario/registrar',
	data : dat,
	type : 'POST',
	dataType : 'json',
	success : function(json) {
	    if (json.code == 00){
                console.log(json);
		loadContent('login');
	    } else {
		console.log(json.message);
	    }
	},
	error : function(xhr, status) {
            console.log(xhr);
            console.log('Disculpe, existi� un problema');
	},
	complete: function(xhr, status) {
	    console.log(status);
	}
    });
}
