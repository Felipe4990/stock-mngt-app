const form = document.getElementById("insertion_form");

form.addEventListener("submit", (e) => {
    e.preventDefault();
    const myFormData = new FormData(e.target);
    const formDataObj = Object.fromEntries(myFormData.entries());

    response = ajax({
        method: 'POST',
        url: 'http://localhost:8080/api/materials',
        payload: formDataObj
    })

    //const output = document.querySelector(".output-pre");
    //output.innerText = JSON.stringify(formDataObj, null, 2);
});

const ajax = async (config) => {
    const request = await fetch(config.url, {
        method: config.method,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(config.payload)
    });
    response = await request.json();
    return response
}

