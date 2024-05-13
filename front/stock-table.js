
// ## #############################################################################################
// ## LISTING & PRESENTATION ######################################################################
// ## #############################################################################################

// Table button calls it onClick. Retrieves name filtered content from the Backend
async function getValueForMaterialsTable() { 
    let inputField = document.getElementById("material-search"); 
    
    deleteContents();

    try {
        const response = await fetch('http://localhost:8080/api/product/' + inputField.value);
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
        for (let i=0; i < element.length + 3; i++) {
            let cell = row.insertCell();
            if (count <= element.length){
                let text = document.createTextNode(element[i]);
                cell.appendChild(text);
            } else if (count <= element.length + 1) {
                //cell.appendChild(document.createTextNode("#action_btn_save"));
                var saveButton = document.createElement('button');
                
                saveButton.innerText="S";         
                saveButton.id = 'save-button'
                saveButton.addEventListener('click', () => {
                    handleElementsForSending(element, row);
                })
                cell.appendChild(saveButton);
            } else if (count <= element.length + 2) {
                //cell.appendChild(document.createTextNode("#action_btn_edit"));
                var editButton = document.createElement('button');

                editButton.innerText="E";         
                editButton.id = 'edit-button'
                editButton.addEventListener('click', () => {
                    editElementFromTable(element, row);        
                })
                cell.appendChild(editButton);
            } else {
                //cell.appendChild(document.createTextNode("#action_btn_delete"));
                var deleteButton = document.createElement('button');

                deleteButton.innerText="D";         
                deleteButton.id = 'delete-button'
                deleteButton.addEventListener('click', () => {
                    deleteElementFromTable(element[0]);
                })
                cell.appendChild(deleteButton);
            }
            count++;
        }
    }
}

// Generates the Table Header
async function generateTableHead() {
    let thead = document.querySelector("table").createTHead();
    let row = thead.insertRow();

    const titleArray = ["ID", "Produto", "Fabricante", "Conteúdo", "Preço", "Validade", "Fabricação", "S", "E", "D"];
    for (var i in titleArray) {
        let th = document.createElement("th");
        let text = document.createTextNode(titleArray[i]);
        th.appendChild(text);
        row.appendChild(th);
    }
}

// Construct Table header asynchronously so it doesn't depend othe table contents proper
generateTableHead();


// ## #############################################################################################
// ## DELETION & EDITING ##########################################################################
// ## #############################################################################################

// ## Deletes element from table and then refreshes said table
async function deleteElementFromTable(materialId){    
    const response = await fetch('http://localhost:8080/api/product/id/' + materialId, { method: 'DELETE' })
        .then(() => getValueForMaterialsTable());
}

// ## Transforms all elements from a given row to TextInput
async function editElementFromTable(element, row){
    for (let i=1; i < element.length; i++){
        const input = document.createElement("input");
        input.setAttribute("value", element[i]);
        input.setAttribute("id", "mutant-input-" + i);
        row.cells[i].replaceChildren(input);
        if(i==1){
            input.focus();
        }
    }
}

// ## Handles and treats the changed TextInputs so it sits correctly in a Materials Object
async function handleElementsForSending(element, row){
    var materialsArray = [];
    materialsArray[0] = element[0];
    for (let i = 1; i < element.length; i++){
        let input = document.getElementById("mutant-input-" + i).value;
        materialsArray[i] = input;
    }
    var materials = new Material();
    materials.id = materialsArray[0];
    materials.productName = materialsArray[1];
    materials.manufacturer = materialsArray[2];
    materials.content = materialsArray[3];
    materials.price = materialsArray[4];
    materials.expirationDate = materialsArray[5];
    materials.purchaseDate = materialsArray[6];

    await sendingElementsToBackend(materials);
}

// ## Sends the treated Materials Object to the Backend so it updates a row of the same given id
async function sendingElementsToBackend(data) {
    deleteContents();
    try {
        const response = await fetch("http://localhost:8080/api/products", {
            method: "POST", // or 'PUT'
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        }).then(() => getValueForMaterialsTable());;

        const result = await response.json();
        console.log("Success:", result);
    } catch (error) {
        console.error("Error:", error);
    }

}

function Material(id, productName, content, description, price, expirationDate, purchaseDate){
    this.id = id;
    this.productName = productName;
    this.content = content;
    this.description = description;
    this.price = price;
    this.expirationDate = expirationDate;
    this.purchaseDate = purchaseDate;
}

