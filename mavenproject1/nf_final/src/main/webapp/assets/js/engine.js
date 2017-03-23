var path = {};
setUrl('/','hello');
setUrl('/home','index');
setUrl('/compras','buy');
setUrl('/signin','login');

$(document).ready(function () {
  if (sessionStorage.login) {
    var usuario = sessionStorage.getItem('nombre');
    $('.nombre').text('hola '+usuario);
  } else {
    if (window.localStorage.length > 0) {
       $('.nombre').text(usuario.value);
    } else {
	//window.location='#/signin.html';
	loadContent('singin');
    }
  }
});

function uriManager() {
    var uri = location.hash.slice(1) || '/';
    var ruta = path[uri];
    if (sessionStorage.login) {
	switch(ruta.element){
	case 'index':
	    hola(uri);
	case 'buy':
	    hola('>>'+uri);
	}
    } else {
	loadContent(ruta.element);
	window.location = '#/signin';
    }
}
function setUrl(url,element) {
    path[url] = {element:element};
}

function hola(msg){
//    alert(msg);
}

function loadContent(element) {
    $('div#contenido').load('./../../nf_final/pages/'+element+'.html');
}

window.addEventListener('hashchange',uriManager);
window.addEventListener('load',uriManager);
