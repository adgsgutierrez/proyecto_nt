function login() {
    var usuario = $("[id=name]").val();
    var password = $("[id=pass]").val();
    auth(usuario, password);
    if (localStorage.login) {
	$('#base').addClass('main');
	loadContent('homePage');
    } else {
//	location.reload();
    }
}

function auth(usuario, password) {
    $.ajax({
	url : '/nf_final/services/usuario/login?usuario='+encodeURIComponent(usuario)+"&clave="+encodeURIComponent(password),
	data : { 'usuario' : usuario, 'clave' : password },
	type : 'POST',
	dataType : 'json',
	success : function(json) {
	    if (json.code == 00){
		var datos = json.data;
		sessionStorage.setItem('login','1');
		sessionStorage.setItem('nombre',datos.nombre);
		sessionStorage.setItem('apellido',datos.apellido);
		sessionStorage.setItem('correo',datos.correo);
		sessionStorage.setItem('ruta_avatar',datos.ruta_avatar);
		sessionStorage.setItem('id',datos.id);
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
