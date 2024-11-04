const formulario = document.querySelector("[data-formulario]");
const email = document.getElementById("email");
const senha = document.getElementById("senha");
const mensagemErroLogin = document.getElementById("mensagem-erro-login");
const cadastro = JSON.parse(localStorage.getItem("cadastro") || "[]");

formulario.addEventListener("submit", (e) => {
	e.preventDefault();
    const user = {
        nome: null,
        email: email.value,
        idade: null,
        senha: senha.value,
        telefone: null
    };
    login(user);
});
// Função para fazer login do usuário
async function login(user) {
	try {
		const response = await fetch("http://localhost:8080/auth/login", {
			method: "POST", // Método HTTP para adicionar
			headers: {
				"Content-Type": "application/json", // Tipo de conteúdo
			},
			body: JSON.stringify(user), // Dados convertidos para JSON
		});
        const jsonResponse = await response.json();
		// Verifica se a resposta foi bem-sucedida
		if (response.ok) {
            const credentials = btoa(`${user.email}:${user.senha}`);
            localStorage.setItem("credentials", JSON.stringify(credentials));
            localStorage.setItem("usuario", JSON.stringify(jsonResponse.user));
			window.location.href = "./home.html"
		} else {
			console.error("Erro ao fazer login do usuário:",jsonResponse);
            mensagemErroLogin.textContent = jsonResponse.mensagem;
		}
	} catch (error) {
		console.error("Erro na requisição:", error);
	}
}
