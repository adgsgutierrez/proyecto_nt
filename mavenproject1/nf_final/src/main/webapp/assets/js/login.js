function login() {
    var usuario = $("[id=name]").val();
    var password = $("[id=pass]").val();
    auth(usuario, password);
    if (localStorage.getItem(usuario) == password) {
	sessionStorage.setItem('nombre',usuario);
	sessionStorage.setItem('login','1');
	location.reload();
    } else {
	alert('Password incorrecto');
    }
}

function loginout() {
    sessionStorage.clear();
    location.reload();
}

function auth(usuario, password){
    $.ajax({
	url : 'http://localhost:8080/nf_final/services/login/',
	data : { 'usuario' : usuario, 'clave' : password },
	type : 'POST',
	dataType : 'json',
	success : function(json) {
	    alert('success');
	},
	error : function(xhr, status) {
            alert('Disculpe, existió un problema');
	},
	complete : function(xhr, status) {
            alert('Petición realizada');
	}
    });
}
