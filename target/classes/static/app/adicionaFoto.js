const arquivo = document.getElementById("input-imagem");
const imagem = document.getElementById("imagem");
const fotoHeader = document.getElementById("foto-header");

function pesquisarImagem() {
    arquivo.click();
    arquivo.addEventListener('change', () => {
        const file = arquivo.files[0];

        if (file) {
            const leitor = new FileReader();
            leitor.readAsDataURL(file);

            leitor.addEventListener('load', e => {
                const fotoDoPerfil = e.target.result;
                imagem.src = fotoDoPerfil;
                fotoHeader.src = fotoDoPerfil;
                console.log('Foto Perfil',fotoDoPerfil);
            })
        }
    })
}
