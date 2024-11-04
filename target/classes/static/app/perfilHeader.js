const usuario = JSON.parse(localStorage.getItem("usuario"));
const fotoHeader = document.getElementById("foto-header");


fotoHeader.src = usuario.foto ? usuario.foto : "./img/Usuario.svg";

