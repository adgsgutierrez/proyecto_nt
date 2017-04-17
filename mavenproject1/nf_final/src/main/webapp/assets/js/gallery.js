var rutas = {};

function gallery(usuario) {
    $.ajax({
	url : '/nf_finan/services/imagenes/top_images?usuario='+encodeURIComponent(usuario),
	data : {'usuario':usuario},
	type : 'GET',
	dataType : 'json',
	success: function (json) {
	    if (json.code == 00) {
		let imagenes = json.data;
		var i = 0;
		for (let imagen in imagenes) {
		    rutas[i] = '<img id="img'
			+ i +'" onclick="zoom_in(' +
			imagen.ruta + ')" src="' + imagen.ruta + '"/>';
		}
		loadGallery();
	    }
	}
    });
}

function loadGallery() {
    $.each(rutas, function (i, v){
	$('.contenido > div').append(v);
    });
}
