function login() {
    var usuario = $("[id=name]").val();
    var password = $("[id=pass]").val();
    auth(usuario, password);
    if (localStorage.getItem(usuario) == password) {
	sessionStorage.setItem('nombre',usuario);
	sessionStorage.setItem('login','1');
	location.reload();
    } else {
	//alert('Password incorrecto');
    }
}

function loginout() {
    sessionStorage.clear();
    location.reload();
}

function auth(usuario, password){
    $.ajax({
	url : '/nf_final/services/usuario/login?usuario='+encodeURIComponent(usuario)+"&clave="+encodeURIComponent(password),
	data : { 'usuario' : usuario, 'clave' : password },
	type : 'POST',
	dataType : 'json',
	success : function(json) {
            console.log(json);
	    alert('success');
	},
	error : function(xhr, status) {
            alert('Disculpe, existi� un problema');
	},
	complete : function(xhr, status) {
            alert('Petici�n realizada');
	}
    });
}
