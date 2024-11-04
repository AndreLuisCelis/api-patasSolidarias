const btnSenha = document.querySelectorAll('#btnSenha');

btnSenha.forEach(btn => btn.addEventListener('click', mostraSenha));

function mostraSenha() {
  const inputSenha = this.parentNode.querySelector('.input-senha');
  inputSenha.type = (inputSenha.type === 'password') ? 'text' : 'password'
}

const icone = document.querySelectorAll('i');

icone.forEach(icone => icone.addEventListener('click', () => {
  icone.classList.toggle('bi-eye-slash');
  icone.classList.toggle('bi-eye');
}));


