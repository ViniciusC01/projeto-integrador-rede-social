function getContaEditar(id){
    console.log("funcao chamada")
    fetch("http://localhost:8080/api_conta_editar?id="+id)
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })
}