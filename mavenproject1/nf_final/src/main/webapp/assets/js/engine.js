var path = {};
UrlEngine('/','hello');
UrlEngine('/home','index');
UrlEngine('/compras','buy');

function uriManager() {
    var uri = location.hash.slice(1) || '/';
    var ruta = path[uri];
    alert(ruta.element);
    switch(ruta.element){
    case 'index':
	hola(uri);
    case 'buy':
	hola('>>'+uri);
    }
}
function UrlEngine(url,element) {
    path[url] = {element:element};
}

function hola(msg){
    alert(msg);
}
window.addEventListener('hashchange',uriManager);
window.addEventListener('load',uriManager);

$(document).ready(function(){
    if (sessionStorage.login) {
	window.location='#/home';
	$('[id=registro]').hide();
    } else {
	var usuario = $("[id=name]").val();
	if (window.localStorage.length > 0) {
	    var password = $("[id=pass]").val();
	    if (localStorage.getItem(usuario) == password) {
		sessionStorage.setItem('login','1');
	    } else {
		alert('password incorrecto');
	    }
	} else {
	    window.location='#/login';
	}
    }
});
