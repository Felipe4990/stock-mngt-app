
// ## Listing and Presentation ####################################################################

async function getValueForMaterialsTable() { 
    let inputField = document.getElementById("material-search"); 
    
    deleteContents();

    try {
        const response = await fetch('http://localhost:8080/api/material/' + inputField.value);
        const data = await response.json();
        generateTable(data);

    } catch (error) {
        console.error('Error fetching data:', error);
    }

} 

function deleteContents(){
    var myTable = document.getElementById("materials-table");
    var rowCount = myTable.rows.length;
    for (var x=rowCount-1; x>0; x--) {
       myTable.deleteRow(x);
    }
}

function generateTable(data) {
    for (let element of data) {
        let row = document.querySelector("table").insertRow();
        for (key in element) {
            let cell = row.insertCell();
            let text = document.createTextNode(element[key]);
            cell.appendChild(text);
        }
    }
}

async function generateTableHead() {
    let thead = document.querySelector("table").createTHead();
    let row = thead.insertRow();

    const titleArray = ["ID", "Material", "Conteúdo", "Preço", "Validade", "Fabricação"];
    for (var i in titleArray) {
        let th = document.createElement("th");
        let text = document.createTextNode(titleArray[i]);
        th.appendChild(text);
        row.appendChild(th);
    }
}
generateTableHead();



// ## Deletion ####################################################################################
async function deleteElementFromtable(){    
    const response = await fetch('http://localhost:8080/api/material/id/124', { method: 'DELETE' })
        .then(() => element.innerHTML = 'Delete successful');

}

