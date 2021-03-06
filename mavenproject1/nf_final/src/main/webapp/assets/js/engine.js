var path = {};
setUrl('/','homePage');
//setUrl('/home','homePage');
setUrl('/compras','payCard');
setUrl('/signin','login');
setUrl('/registry','registry');
setUrl('/gallery','gallery');

$(document).ready(function () {
    displayMenu();
});

function displayMenu () {
    if (sessionStorage.login) {
	var usuario = sessionStorage.getItem('nombre');
	loadContent('homePage');
	$('[id=p]').show();
	$('[id=s]').show();
	$('[id=r]').hide();
//	$('.nombre').text('hola '+usuario);
    } else {
	if (window.localStorage.length > 0) {
	    $('[id=p]').show();
	    $('[id=s]').show();
	    $('[id=r]').hide();
	    $('.nombre').text(usuario.value);
	} else {
	    $('[id=p]').hide();
	    $('[id=s]').hide();
	    $('[id=r]').show();
	    loadContent('login');
	}
    }
}

function uriManager() {
    var uri = location.hash.slice(1) || '/';
    var ruta = path[uri];
    if (sessionStorage.login) {
	switch(ruta.element){
	case 'homePage':
	    loadContent('homePage');
	case 'buy':
	    loadContent('payCard');
	case 'registry':
	    loadContent('registry');
	case 'gallery':
	    loadContent('gallery');
	default:
	    loadContent('login');
	}
    } else {
	loadContent(ruta.element);
    }
}
function setUrl(url,element) {
    path[url] = {element:element};
}

function index(){
    loadContent('gallery');
}

function registry() {
    loadContent('registry');
}

function loadContent(element) {
    $('div#contenido').load('./../../nf_final/pages/'+element+'.html');
}

function loginout() {
    sessionStorage.clear();
    location.reload();
}

window.addEventListener('hashchange',uriManager);
window.addEventListener('load',uriManager);
