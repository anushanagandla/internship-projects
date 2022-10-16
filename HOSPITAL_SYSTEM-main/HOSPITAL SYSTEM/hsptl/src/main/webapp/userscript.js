function bookPatient(){
debugger;
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
console.log("called");
let name = document.getElementById("name").value;
let age=document.getElementById("age").value;
let phno = document.getElementById("phno").value;
let date = document.getElementById("date").value;
let select_doctor = document.getElementById("select_doctor").value;
let gender= document.getElementById("gender").value;
console.log(name+age+phno+date+select_doctor+gender);
var raw = JSON.stringify({
  "name" :name,
  "age" : age,
  "phno" :phno ,
  "date" :date ,
  "select_doctor":select_doctor,
  "gender": gender
});
console.log(raw);
var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw
};
fetch("http://localhost:8080/hsptl/users", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
  }