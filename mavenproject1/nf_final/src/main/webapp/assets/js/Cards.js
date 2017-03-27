var tarjetas = {};

$(document).ready(function () {
    var user = sessionStorage.getItem('id');
    load(user);
    for (let tarjeta in tarjetas) {
	loadContent('cards');
    }
});

function load(usuario) {
    $.ajax({
	url : '/nf_final/services/usuario/adicionar/tarjeta_credito?usuario='+encodeURIComponent(usuario),
	data : { 'usuario' : usuario},
	type : 'POST',
	dataType : 'json',
	success : function(json) {
	    if (json.code == 00){
		let datos = json.data;
		for (let dato in datos) {
		    tarjetas[dato.numero] = {fecha:dato.fecha,
					      tipo:dato.tipo,
					     auto:dato.pago_automatico};
		}
	    } else {
		alert(json.message);
	    }
	},
	error : function(xhr, status) {
	    alert('Disculpe, existi� un problema');
	},
	complete: function(xhr, status) {
	    console.log(status);
	}
    });
}
