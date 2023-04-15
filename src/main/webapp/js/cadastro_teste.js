function getInstituicoes(){
    console.log("funcao chamada")
    fetch("http://localhost:8080/api_instituicoes")
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })
}