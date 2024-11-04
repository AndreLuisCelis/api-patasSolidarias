const animal = document.querySelectorAll("[data-animal]");

animal.forEach(e => e.addEventListener('click', function() {
    const nomeDoAnimal = this.querySelector('h2').textContent;
    
    localStorage.setItem('animal', JSON.stringify(nomeDoAnimal));

    window.location.href= 'mensagem.html';
}))
