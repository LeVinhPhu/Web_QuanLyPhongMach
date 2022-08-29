/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getEmployees(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let h = "";
        for (let i = 0; i < data.length; i++)
            h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].firstName}</td>
                    <td>${data[i].lastName}</td>
                    <td>${moment(data[i].dateOfBirth).format('L')}</td>
                    <td>${data[i].sex}</td>
                    <td>${data[i].phone}</td>
                    <td>${data[i].address}</td>
                    <td>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i].id}"></div>
                        <button class='btn btn-warning' onclick="deleteEmployee('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">DELETE</button>
                    </td>
                    <td>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i].id}"></div>
                        <button class='btn btn-primary' onclick="delProduct('${endpoint + "/" + data[i].id}', ${data[i].id})">UPDATE</button>
                    </td>
                    <td>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i].id}"></div>
                        <button class='btn btn-success' onclick="del('${endpoint + "/" + data[i].id}', ${data[i].id})">DETAILS</button>
                    </td>
                </tr>
        `

        let d = document.getElementById("myEmployee");
        d.innerHTML = h;
    }).catch(function (err) {
        console.error(err);
    })
}

function deleteEmployee(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`)
    let load = document.getElementById(`load${id}`)
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
        if (res.status === 204)
            alert("Đang gặp sự cố !");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        load.style.display = "none";
        btn.style.display = "block";
    })
}