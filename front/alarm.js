
//setInterval(tick, 1000 * 20);
//function tick() {
//    runAtSpecificTimeOfDay(19, 2, () => { firstFunction });
//}

var ranToday = false;


firstFunction();


//1. Create a new function that returns a promise
function firstFunction() {
    fetch("http://localhost:8080/api/admin/flag/expiration-track-range").then(response => {
        return response.json();
    }).then(dt1 => {
        console.log("This is some data from First: " + dt1);
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


//2. Create an async function
//function secondFunction() {
//    console.log('Before first call.');
//
//    const result = await firstFunction();
//    console.log("first function returned: " + result);
//
//    //var res = fetch('http://localhost:8080/api/product/expiration/' + result.json() + '?page=0');
//    var res = fetch('http://localhost:8080/api/product/expiration/32?page=0');
//    console.log("second function returned: " + res);
//
//    return res;
//
//};



function runAtSpecificTimeOfDay(hour, minutes, func) {
    const twentyFourHours = 86400000;
    const now = new Date();
    let eta_ms = new Date(now.getFullYear(), now.getMonth(), now.getDate(), hour, minutes, 0, 0).getTime() - now;
    if (eta_ms < 0) {
        eta_ms += twentyFourHours;
    }
    setTimeout(function () {
        //run once
        func();
        // run every 24 hours from now on
        setInterval(func, twentyFourHours);
    }, eta_ms);
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




