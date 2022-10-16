const thisForm = document.getElementById('form');
thisForm.addEventListener('submit', async function (e) {
    e.preventDefault();
    let response = await fetch("http://localhost:8080/hospitalsystem/users", {
        method: 'POST',
        body: new FormData(event.target),
    });
   debugger;
    let result = response.json();
    alert(result.message)
    console.log(result)
});