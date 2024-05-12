
// ## Listing and Presentation ####################################################################


// Table button calls it onClick. Retrieves name filtered content from the Backend
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

// Deletes all the non header rows of table prior to refreshing the filter's contents 
function deleteContents(){
    var myTable = document.getElementById("materials-table");
    var rowCount = myTable.rows.length;
    for (var x=rowCount-1; x>0; x--) {
       myTable.deleteRow(x);
    }
}

// Generate new rows into the table for all the filtered results 
function generateTable(data) {
    for (let element of data) {
        let row = document.querySelector("table").insertRow();

        let count = 1
        for (let i=0; i < element.length + 2; i++) {
            let cell = row.insertCell();
            if (count <= element.length){
                let text = document.createTextNode(element[i]);
                cell.appendChild(text);
                count++;
            } else if (count <= element.length + 1) {
                cell.appendChild(document.createTextNode("#action_btn_edit"));
                count++;
            } else {
                cell.appendChild(document.createTextNode("#action_btn_delete"));
            }
        }
    }
}

// Generates the Table Header
async function generateTableHead() {
    let thead = document.querySelector("table").createTHead();
    let row = thead.insertRow();

    const titleArray = ["ID", "Material", "Conteúdo", "Preço", "Validade", "Fabricação", "E", "D"];
    for (var i in titleArray) {
        let th = document.createElement("th");
        let text = document.createTextNode(titleArray[i]);
        th.appendChild(text);
        row.appendChild(th);
    }
}

// Construct Table header asynchronously so it doesn't depend othe table contents proper
generateTableHead();



// ## Deletion ####################################################################################
async function deleteElementFromtable(){    
    const response = await fetch('http://localhost:8080/api/material/id/124', { method: 'DELETE' })
        .then(() => element.innerHTML = 'Delete successful');

}

