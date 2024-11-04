const animal = JSON.parse(localStorage.getItem("animal"));

const nomeDoUsuario = document.getElementById("nome");
nomeDoUsuario.value = usuario[0].nome;

const telefoneDoUsuario = document.getElementById("telefone");
telefoneDoUsuario.value = usuario[0].telefone;

const animalEscolhido = document.getElementById("animal");
animalEscolhido.value = animal;
