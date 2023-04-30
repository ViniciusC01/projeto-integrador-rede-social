const form = document.getElementById("form")
const firstName = document.getElementById("firstName")
const lastName = document.getElementById("lastName")
const birth = document.getElementById("birth")
const gender = document.getElementById("gender")
const cpf = document.getElementById("cpf")
const university = document.getElementById("instituicao")
const course = document.getElementById("curso")
const shift = document.getElementById("shift")
const year = document.getElementById("year")
const semester = document.getElementById("semester")
const team = document.getElementById("team")
const email = document.getElementById("email")
const password = document.getElementById("password")
const passwordConfirmation = document.getElementById("passwordConfirmation")

form.addEventListener('submit', (e) => {

    const valida = checkInputs();
    
    if (valida === false){
        e.preventDefault();
    }
});

function checkInputs() {
    const firstNameValue = firstName.value;
    const lastNameValue = lastName.value;
    const birthValue = birth.value;
    const genderContent = gender.value;
    const cpfValue = cpf.value;
    const universityValue = university.value;
    const courseValue = course.value;
    const shiftValue = shift.value;
    const yearValue = year.value;
    const semesterValue = semester.value;
    const teamValue = team.value;
    const emailValue = email.value;
    const passwordValue = password.value;
    const passwordConfirmationValue = passwordConfirmation.value;
    if(firstNameValue === ""){
        setErrorFor(firstName, "O nome é obrigatório.");
    } else {
        setSuccessFor(firstName)
    }
    if(lastNameValue === ""){
        setErrorFor(lastName, "O sobrenome é obrigatório.");
    } else {
        setSuccessFor(lastName)
    }
    if(birthValue === ""){
        setErrorFor(birth, "A data de nscimento é obrigatória.");
    } else {
        setSuccessFor(birth)
    }
    if(genderContent === "0"){
        setErrorFor(gender, "O gênero é obrigatório.");
    } else {
        setSuccessFor(gender)
    }
    if(cpfValue === ""){
        setErrorFor(cpf, "O CPF é obrigatório.");
    } else {
        setSuccessFor(cpf)
    }
    if(universityValue === "0"){
        setErrorFor(university, "A universidade é obrigatória.");
    } else {
        setSuccessFor(university)
    }
    if(courseValue === "0"){
        setErrorFor(course, "O curso é obrigatório.");
    } else {
        setSuccessFor(course)
    }
    if(shiftValue === "0"){
        setErrorFor(shift, "O turno é obrigatório.");
    } else {
        setSuccessFor(shift)
    }
    if(yearValue === ""){
        setErrorFor(year, "O ano de início é obrigatório.");
    } else {
        setSuccessFor(year)
    }
    if(semesterValue === "0"){
        setErrorFor(semester, "O semestre é obrigatório.");
    } else {
        setSuccessFor(semester)
    }
    if(teamValue === "0"){
        setErrorFor(team, "A turma é obrigatória.");
    } else {
        setSuccessFor(team)
    }
    if (emailValue === "") {
        setErrorFor(email, "O email é obrigatório.");
    } else if (!checkEmail(emailValue)) {
        setErrorFor(email, "Por favor, insira um email válido.");
    } else {
        setSuccessFor(email);
    }
    if (passwordValue === "") {
        setErrorFor(password, "A senha é obrigatória.");
    } else if (passwordValue.length < 8) {
        setErrorFor(password, "A senha precisa ter no mínimo 8 caracteres.");
    } else {
        setSuccessFor(password);
    }    
    if (passwordConfirmationValue === "") {
        setErrorFor(passwordConfirmation, "A confirmação de senha é obrigatória.");
    } else if (passwordConfirmationValue !== passwordValue) {
        setErrorFor(passwordConfirmation, "As senhas não conferem.");
    } else {
        setSuccessFor(passwordConfirmation);
    }

    const formControls = form.querySelectorAll(".fields")
    const formIsValid = [...formControls].every(fields => {
        return (fields.classList.contains("success"));
    });

    // Validação do submit

    console.log(formIsValid)
    if (formIsValid) {
        return true;
    } else {
        return false;
    }
}

function setErrorFor(input) {
    const formControl = input.parentElement;

    // Adicionar a classe de erro
    formControl.classList.add("error");
    formControl.classList.remove("success");
}

function setSuccessFor(input) {
    const formControl = input.parentElement;

    // Adicionar a classe de sucesso
    formControl.classList.add("success");
    formControl.classList.remove("error");
}

// Mascaras input
function mask(){
    $( "#cpf" ).keypress(function() {
       $(this).mask('000.000.000-00');
    }); 
    $( "#year" ).keypress(function() {
       $(this).mask('0000');
    }); 
}

// Aceitar somente números
function onlynumber(evt) {
    var theEvent = evt || window.event;
    var key = theEvent.keyCode || theEvent.which;
    key = String.fromCharCode( key );
    var regex = /^[0-9]+$/;
    if( !regex.test(key) ) {
       theEvent.returnValue = false;
       if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

// Checar validação do e-mail
function checkEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function getInstituicoes(){
    console.log("funcao chamada")
    fetch("http://localhost:8080/api_instituicoes")
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })
}

function getCursosByInstituicaoId(id){
    fetch("http://localhost:8080/api_cursos_by_email?instituicao_id="+id)
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })
}

function getTurmaByCursoId(id){
    fetch("http://localhost:8080/api_turma_specific?data_inicio=2022&semestre=SEGUNDO&id_curso=1&turno=noturno")
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })
}

document.querySelector('#instituicao').addEventListener('change', (e) => {
    id = document.querySelector('#instituicao').value
    getCursosByInstituicaoId(id)
})