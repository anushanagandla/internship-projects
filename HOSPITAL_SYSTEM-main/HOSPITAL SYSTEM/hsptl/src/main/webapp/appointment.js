function addAppointment(){
debugger;
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
console.log("called");
let name = document.getElementById("name").value;
let gender= document.getElementById("gender").value;
let phno = document.getElementById("phno").value;
let date = document.getElementById("date").value;
console.log(name+gender+phno+date);
var raw = JSON.stringify({
  "name" :name,
 "gender": gender,
  "phno" :phno ,
  "date" :date ,

});
console.log(raw);
var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw
};
fetch("http://localhost:8080/hsptl/appointment", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
  }