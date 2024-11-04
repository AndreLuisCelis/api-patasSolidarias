const formulario = document.querySelector("[data-formulario]");
const mensagemErroLogin = document.getElementById("senha-erro");

formulario.addEventListener("submit", (e) => {
	e.preventDefault();
	const listaRespostas = [
		{
			nome: e.target.elements.nome.value,
			email: e.target.elements.email.value,
			senha: e.target.elements.senha.value,
			senhaConfirm: e.target.elements.senhaConfirm.value,
		},
	];
	const newUser = {
		nome: listaRespostas[0].nome,
		email: listaRespostas[0].email,
		senha: listaRespostas[0].senha,
	};
	if (senha.value === senhaConfirm.value) {
		adicionarUsuario(newUser).then((response) => {
			if (response.success) {
                alert(response.mensagem);
                localStorage.setItem("usuario", JSON.stringify(response.user));
				window.location.href = "./login.html";
				return;
			}
			if (!response.success) {
				alert(response.mensagem);
				return;
			}
		});
	} else {
		mensagemErroLogin.textContent = "As senhas não se conferem!";
	}
});

async function adicionarUsuario(user) {
	try {
		const response = await fetch("http://localhost:8080/auth/create", {
			method: "POST", // Método HTTP para adicionar
			headers: {
				"Content-Type": "application/json", // Tipo de conteúdo
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
