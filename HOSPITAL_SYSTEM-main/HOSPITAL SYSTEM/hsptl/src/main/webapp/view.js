const api_url =
	"http://localhost:8080/hsptl/users";
// Defining async function
async function getapi(url) {
	// Storing response
	const response = await fetch(url);

	// Storing data in form of JSON
	var data = await response.json();
	console.log(data);
	if (response) {
		hideloader();
	}
	show(data);
}
// Calling that async function
getapi(api_url);

// Function to hide the loader
function hideloader() {
	document.getElementById('loading').style.display = 'none';
}
// Function to define innerHTML for HTML table
function show(data) {
	let tab =
		`<tr>
		<th>name</th>
		<th>age</th>
		<th>phno</th>
		<th>select_doctor</th>
<th>date</th>
<th>gender</th>
		</tr>`;

	// Loop to access all rows
	for (let r of data) {
		tab += `<tr>
	<td>${r.name} </td>
	<td>${r.age}</td>
	<td>${r.phno}</td>
	<td>${r.select_doctor}</td>
    	<td>${r.date}</td>
    	<td>${r.gender}</td>

</tr>`;
	}
	// Setting innerHTML as tab variable
	document.getElementById("users").innerHTML = tab;
}
