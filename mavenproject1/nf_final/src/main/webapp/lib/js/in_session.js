//
function cerrar_session(){
    localStorage.clear();
    window.location.href = "ingresar.html";
}
$(document).ready(function(){
    var user = JSON.parse(localStorage.getItem("usuario")) || '';
    if(user === ''){
        window.location.href = "ingresar.html";
    }
});