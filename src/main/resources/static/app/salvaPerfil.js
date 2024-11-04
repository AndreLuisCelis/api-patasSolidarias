const formulario = document.querySelector("[data-formulario]");

formulario.addEventListener('submit', async (e) => {
    e.preventDefault();

    const usuario = JSON.parse(localStorage.getItem("usuario"));
    const perfil = {
        "id": usuario.id,
        "nome": e.target.elements.nome.value,
        "telefone": e.target.elements.telefone.value,
        "cidade": e.target.elements.cidade.value,
        "sobre": e.target.elements.sobre.value,
        "foto": e.target[0].elements[0].previousElementSibling.firstElementChild.src
    }
    const ResponseEditedPerfil = await salvarPerfilUsuario(perfil);
    localStorage.setItem("usuario", JSON.stringify(ResponseEditedPerfil.user));
    window.location.href = './home.html'
})

const usuario = JSON.parse(localStorage.getItem("usuario"));

// const srcFoto = localStorage.getItem("foto");

const inputNome = document.getElementById("nome")
inputNome.value = usuario.nome;

const inputTelefone = document.getElementById("telefone"); 
inputTelefone.value = usuario.telefone;

const inputCidade = document.getElementById("cidade");
inputCidade.value = usuario.cidade;

const inputSobre = document.getElementById("sobre");  
inputSobre.value = usuario.sobre;

const inputImagem = document.getElementById("imagem");
inputImagem.src = usuario.foto ? usuario.foto : "./img/Usuario.svg";

const imagemHeader = document.getElementById("foto-header");  
imagemHeader.src = usuario.foto ? usuario.foto : "./img/Usuario.svg";


async function salvarPerfilUsuario(user) {
    const credentials = localStorage.getItem('credentials').replace(/"/g, "");
    console.log("Token de autenticação:", `Basic ${credentials}`);
	try {
		const response = await fetch("http://localhost:8080/api/user", {
			method: "PUT", // Método HTTP para adicionar
			headers: {
				"Content-Type": "application/json", // Tipo de conteúdo
                'Authorization': `Basic ${credentials}`,
			},
			body: JSON.stringify(user), // Dados convertidos para JSON
		});
		const jsonResponse = await response.json();
		return jsonResponse;
	} catch (error) {
		console.error("Erro na requisição:", error);
		return error;
	}
}




