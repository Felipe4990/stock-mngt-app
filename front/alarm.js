runDialogPerDay();

// Checks if a day has passed
function hasOneDayPassed() {
    var date = new Date().toLocaleDateString();
    if (localStorage.stockControlDailyRunDate == date){
        return false;
    }
    localStorage.stockControlDailyRunDate = date;
    return true;
}

// Run the Notification Code only once per day
function runDialogPerDay() {
    if (!hasOneDayPassed()) {
        return false;
    }
    getSoonToExpireProducts();
}

// Retrieves the current expiration threshold from the backend 
// Then retrieves those products that are to expire from up to that threshold
function getSoonToExpireProducts() {
    fetch("http://localhost:8080/api/admin/flag/expiration-track-range").then(response => {
        return response.json();
    }).then(dt1 => {
        fetch('http://localhost:8080/api/product/expiration/' + dt1 + '?page=0').then(res =>{
            return res.json();
        }).then(dt2 => {
            var myDialog = document.getElementById("dialog-notification-id");
            var diagTable = document.getElementById('dialog-table');
            
            //console.log("This is some data from Second: " + dt2);
            generateDialogTable(dt2, diagTable);

            myDialog.appendChild(diagTable)
            myDialog.showModal();
        });
    }).catch(err => {
        console.log("Some Error: " + err);
    });
}

async function generateDialogTable(data, diagTable) {
    //console.log("Hopefully the full json: " + data);

    if (diagTable != null) {
        for (let element of data) {
            let row = diagTable.insertRow();
            for (let i = 1; i < element.length; i++) {
                let cell = row.insertCell();
                let text = document.createTextNode(element[i]);
                cell.appendChild(text);
            }
        }
    }
}




