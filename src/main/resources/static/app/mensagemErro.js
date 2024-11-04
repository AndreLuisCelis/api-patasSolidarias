const campoDoFormaulario = document.querySelectorAll("[required]");

campoDoFormaulario.forEach(campo => {
    campo.addEventListener('blur', () => verificaCampo(campo));
    campo.addEventListener('invalid', evento => evento.preventDefault());
})

const tiposDeErro = [
    'valueMissing',
    'patternMismatch',
    'tooShort',
    'typeMismatch',
]

const mensagens = {
    nome: {
        valueMissing: "O campo de nome não pode estar vazio.",
        patternMismatch: "Por favor, preencha um nome válido.",
        tooShort: "Por favor, preencha um nome válido."
    },
    email: {
        valueMissing: "O campo de e-mail não pode estar vazio.",
        typeMismatch: "Por favor, preencha um email válido.",
        tooShort: "Por favor, preencha um e-mail válido."
    },
    senha: {
        valueMissing: "O campo de senha não pode estar vazio.",
        tooShort: "A senha deve ter pelo menos 4 caracteres."
    },
    senhaConfirm: {
        valueMissing: "Por favor, confirme sua senha.",
    },
}

function verificaCampo(campo) {
    let mensagem = "";
    tiposDeErro.forEach(erro => {
        if (campo.validity[erro]) {
            mensagem = mensagens[campo.name][erro];
        }
    })
    
    const mensagemErro = campo.parentNode.querySelector(".mensagem-erro")
    const validadorDeInput = campo.checkValidity();
    const btnOlhoSenha = campo.nextElementSibling;
    const dataSenha = campo.nextElementSibling.dataset.senha;
    
    if (!validadorDeInput) {
        mensagemErro.textContent = mensagem;
        if (dataSenha) {
            btnOlhoSenha.classList.replace('bottom-[19%]', 'bottom-[39%]');
        }
    } else {
        mensagemErro.textContent = "";
        btnOlhoSenha.classList.replace('bottom-[39%]', 'bottom-[19%]');
    }
}