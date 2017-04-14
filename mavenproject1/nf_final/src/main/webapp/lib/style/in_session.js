$(document).ready(function(){
  $(".menu").hide();
  $(".zooming").hide();
  $(".ingresar").hover(function(){
      $(".menu").show();
  }, function(){
      $(".menu").hide();
  });

  $(".menu").hover(function(){
      $(".menu").show();
  }, function(){
      $(".menu").hide();
  });
});

zoom_in = function(ruta){
  document.getElementById("img_zoom").src = ruta;
  $(".zooming").show();
}
zoom_out = function(){
  $(".zooming").hide();
}
