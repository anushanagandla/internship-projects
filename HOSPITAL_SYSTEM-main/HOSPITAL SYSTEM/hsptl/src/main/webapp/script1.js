//const thisForm = document.getElementById('form');
//thisForm.addEventListener('submit', async function (e) {
//    e.preventDefault();
//    console.log(new FormData(event.target))
//    let response = await fetch("http://localhost:8080/hospitalsystem/users", {
//        method: 'POST',
//        body: new FormData(event.target),
//    });
//   debugger;
//    let result = response.json();
//    alert(result.message)
//    console.log(result)
//});

const bookPatient= async (e)=>{

console.log("patientData");

let name = document.getElementById("name")
let age=document.getElementById("age")
let phno = document.getElementById("phno")
let date = document.getElementById("date")
let selectdoctor = document.getElementById("selectdoctor")
let gender= document.getElementById("gender")
let patientData = {
name :name,
age : age,
phno :phno ,
date :date ,
selectdoctor:selectdoctor ,
gender: gender,
};

console.log(patientData);
 let response = await fetch("http://localhost:8080/hospitalsystem/users", {
        method: 'POST',
        body: JSON.stringify(patientData)
    });

let result = response.json();
    alert(result.message)
 console.log(result)
}