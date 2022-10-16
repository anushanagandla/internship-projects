function addPrescription(){
debugger;
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
console.log("called");
let name = document.getElementById("name").value;
let phno = document.getElementById("phno").value;
let description = document.getElementById("description").value;
let medicines= document.getElementById("medicines").value;
console.log(name+phno+date+description+medicines);
var raw = JSON.stringify({
  "name" :name,
  "phno" :phno ,
  "description" :description ,
  "medicines":medicines
});
console.log(raw);
var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw
};
fetch("http://localhost:8080/hsptl/prescription", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
  }