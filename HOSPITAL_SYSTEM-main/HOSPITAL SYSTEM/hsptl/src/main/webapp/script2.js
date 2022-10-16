const api_url =
	"http://localhost:8080/hsptl/appointment";
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
		<th>aptid</th>
		<th>name</th>
		<th>gender</th>
		<th>phno</th>
		<th>date</th>

		</tr>`;

	// Loop to access all rows
	for (let r of data) {
		tab += `<tr>
	<td>${r.aptid} </td>
	<td>${r.name}</td>
	<td>${r.gender}</td>
	<td>${r.phno}</td>
    	<td>${r.date}</td>

</tr>`;
	}
	// Setting innerHTML as tab variable
	document.getElementById("emp").innerHTML = tab;
}
