function getContaEditar(id){
    console.log("funcao chamada")
}

function getInstituicoes(){
    return fetch("http://localhost:8080/api_instituicoes")
        .then(response => response.json())
        .then(data => {
            return data
        })
}

function getCursos(id){
    return fetch("http://localhost:8080/api_cursos?instituicao_id="+id)
        .then(response => response.json())
        .then(data => {
            return data
        })
}


document.getElementById("editar").addEventListener('click', function(e) {
    id = e.target.getAttribute('data-id')
    var dados
    var meusDados
    fetch("http://localhost:8080/api_conta_editar?id="+id)
        .then(response => response.json())
        .then(values => {
            dados = values
            meusDados = dados
            const cpf = document.getElementById("f_cpf")
            const nome = document.getElementById("f_nome")
            const curso = document.getElementById("f_curso")
            const genero = document.getElementById("f_genero")
            const nascimento = document.getElementById("f_nascimento")
            const instituicao = document.getElementById("f_instituicoes")

            instituicao.innerHTML = ''
            curso.innerHTML = ''
            genero.innerHTML = ''

            cpf.value = dados['cpf']
            nome.value = dados['nome']

            const data = new Date(parseInt(dados['nascimento']))
            nascimento.value = (data.toISOString().slice(0,10))

            // carregar genero

            opcoes = [
                {'genero':'MASCULINO', 'id': 1},
                {'genero':'FEMININO', 'id': 2},
            ]

            opcoes.forEach( e => {
                option = document.createElement("option")
                option.id = e['id']
                option.index = e['genero'] == dados['genero'] ? 0 : 1
                option.value = e['id']
                option.textContent = e['genero']
                genero.appendChild(option)
            }
            )

            instituicoes = getInstituicoes().then(dados => {
                dados.forEach(dado => {
                    option = document.createElement("option")
                    option.id = dado['id'];
                    option.value = dado['id'];
                    option.textContent = dado['nome'];
                    instituicao.appendChild(option)

                })
            }).then( () => {
                    let index = instituicao.options[0].value;
                    cursos = getCursos(1).then(dados =>{
                        dados.forEach(dado => {
                            option = document.createElement("option")
                            option.id = dado['id'];
                            option.value = dado['id'];
                            option.textContent = dado['nome'];
                            curso.appendChild(option)
                        })
                    })
                    console.log(cursos)
            })





    })

});


document.getElementById("f_instituicoes").addEventListener('change', e => {
    instituicao_id = e.target.getAttribute('value')
    console.log(instituicao_id)
    console.log('cursos')
})


