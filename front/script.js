// Function to fetch data from the API
async function fetchData() {
    try {
        //const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        const response = await fetch('http://localhost:8080/api/material/leite');
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

async function generateTableHead(table) {
    const filling = await fetchData();

    let thead = table.createTHead();
    let row = thead.insertRow();

    const titleArray= [ "ID", "Produto", "Conteúdo", "Preço", "Validade", "Fabricação" ];
    for (var i in titleArray){
        let th = document.createElement("th");
        let text = document.createTextNode(titleArray[i]);
        th.appendChild(text);
        row.appendChild(th);
    }
}

async function generateTable(table) {
    const filling = await fetchData();    
    
    for (let element of filling) {
        let row = table.insertRow();
        for (key in element) {
            let cell = row.insertCell();
            let text = document.createTextNode(element[key]);
            cell.appendChild(text);
        }
    }
}

let table = document.querySelector("table");
//let filling = Object.keys(mountains[0]);


generateTableHead(table);
generateTable(table);