function getContaEditar(id){
    console.log("funcao chamada")

}

document.getElementById("editar").addEventListener('click', function(e) {
    id = e.target.getAttribute('data-id')
    let dados = []
    fetch("http://localhost:8080/api_conta_editar?id="+id)
        .then(response => response.json())
        .then(values => {
            dados = values
            console.log(dados)
            console.log("deu certo")
            const cpf = document.getElementById("f_cpf")
            const nome = document.getElementById("f_nome")
            const turma = document.getElementById("f_turma")
            const curso = document.getElementById("f_curso")
            const nascimento = document.getElementById("f_nascimento")
            const instituicao = document.getElementById("f_instituicoes")
            console.log('coco')
            cpf.value = dados['cpf']
            nome.value = dados['nome']
            const data = new Date(parseInt(dados['nascimento']))
            nascimento.value = (data.toISOString().slice(0,10))
    })





})