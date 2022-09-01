/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function deleteMedicine(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}


function getMedicines(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myMedicine");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td>${i + 1}</td>
                        <td>${data[i][1]}</td>
                        <td>${data[i][2]}</td>
                        <td>${data[i][3]}</td>
                        <td>${data[i][4]}</td>
                        <td><button class="btn">DETAILS</button></td>
                        <td><a href="/admins/medicinesManager/${data[i][0]}>Sửa</a></td>
                        <td>
                            <div class="spinner-border text-warning" style="display:none" id="load${data[i][0]}"></div>
                            <button class="btn" style="background-color: #FFCDCD" onclick="deleteMedicine('${endpoint + "/" + data[i][0]}', ${data[i][0]}, this)">DELETE</button>
                        </td>
                    </tr>
                    `;



            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    })
}






//                        <button class="btn btn-danger" onlick="deleteMedicine('${endpoint + "/" + data[i].id}', ${data[i].id})">Xoa</button>







