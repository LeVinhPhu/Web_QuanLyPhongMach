/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getAdmin(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let h = "";
        for (let i = 0; i < data.length; i++)
            h += `
                <tr id="row${data[i][0]}">
                    <td>${i+1}</td>
                    <td>${data[i][1]}</td>
                    <td>${data[i][2]}</td>
                    <td>${data[i][11]}/${data[i][12]}/${data[i][13]}</td>
                    <td>${data[i][6]}</td>
                    <td>${data[i][5]}</td>
                    <td>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i][0]}"></div>
                        <i onclick="deleteAdmin('${endpoint + "/" + data[i][0]}', ${data[i][0]}, this)" class="fas fa-trash-alt"></i>
                    </td>
                    <td>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i][0]}"></div>
                        <a style="color:black" href="/Web_QuanLyPhongMach/admins/adminsManager/${data[i][0]}"><i class="fas fa-pencil-alt"></i></a>
                    </td>
                    <td>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i][0]}"></div>
                        <i class="fas fa-info-circle" data-bs-toggle="modal" onclick="detailAdmin('${endpoint}', ${data[i][0]})"></i>
                    </td>
                </tr>
        `

        let d = document.getElementById("myAdmin");
        d.innerHTML = h;
    }).catch(function (err) {
        console.error(err);
    });
}

function deleteAdmin(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
//        if (res.status === 204)
//            alert("Đang gặp sự cố !");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        load.style.display = "none";
        btn.style.display = "block";
    })
}


function detailAdmin(endpoint, id) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let h = "";
        for (let i = 0; i < data.length; i++)
            if (data[i][0] == id)
            {
                h += `
                <div style="text-align: center" class="boder rounded bg-light"> 
                    <img
                        src="${data[i][3]}"
                        class="rounded-circle"
                        height="70"
                        width="70"
                        alt="Black and White Portrait of a Man"
                        loading="lazy"
                        />
                    <h6>${data[i][1]} ${data[i][2]}</h6>
                </div>

                <div>
                    <h6>Ngày sinh: ${data[i][11]}/${data[i][12]}/${data[i][13]}</h6>
                    <h6>Giới tính: ${data[i][6]}</h6>
                    <h6>Quyền: ${data[i][8]}</h6> 
                    <h6>Địa chỉ: ${data[i][7]}</h6>
                    <h6>Email: ${data[i][4]}</h6>
                    <h6>Phone: ${data[i][5]}</h6>
                    <h6>Username: ${data[i][10]}</h6>
                </div>
            `
            }
        let d = document.getElementById("detailAdmin");
        d.innerHTML = h;
    }).catch(function (err) {
        console.error(err);
    });
    $('#detailModal').modal('show');
}


////Trường xữ lý lổi của form Add
//
//const firstname = document.getElementById("firstName");
//const lastname = document.getElementById("lastName");
//const address = document.getElementById("address");
//const email = document.getElementById("email");
//const phone = document.getElementById("phone");
//const username = document.getElementById("username");
//const password = document.getElementById("password");
//
//const btSubmit = document.getElementById('bt-submit');
//const inputEls = document.querySelectorAll('.input-row');
//const btAdd = document.getElementById('bt-add');
//
//var temp = 0;
//btSubmit.addEventListener('click', function () {
//    Array.from(inputEls).map((ele) =>
//        ele.classList.remove('error'));
//    let flag = checkValidate();
//    if (!flag) {
//        $('#myForm').on('submit', function (e) {
//            e.preventDefault(); // Now nothing will happen
//        });
//        temp++;
//    }
//
//    if (flag && temp >= 1)
//    {
//        $(document).ready(function () {
//            $('form').submit(function () {
//                $.ajax({
//                    method: $(this).attr('method'),
//                    url: $(this).attr('action'),
//                    data: $(this).serialize()
//                });
//            });
//        });
//        alert('Gửi đăng ký thành công  !');
//        window.location = "/Web_QuanLyPhongMach/admins/employeesManager";
//    }
//
//    console.log(temp);
//    if (flag && temp <= 0)
//    {
//        alert('Gửi đăng ký thành công !');
//        window.location = "/Web_QuanLyPhongMach/admins/employeesManager";
//    }
//});
//
//
//
////Kiểm tra lổi
//function checkValidate() {
//    let fn = firstname.value;
//    let ln = lastname.value;
//    let adrs = address.value;
//    let eml = email.value;
//    let phn = phone.value;
//    let user = username.value;
//    let pass = password.value;
//
//    let isCheck = true;
//
//    if (fn === '') {
//        setError(firstname, 'Họ và tên đệm không được để trống');
//        isCheck = false;
//    }
//    
//    if (fn.length > 24){
//        setError(firstname, 'Họ và tên đệm không lớn hơn 24 ký tự');
//        isCheck = false;
//    }
//
//    if (ln === '') {
//        setError(lastname, 'Tên không được để trống');
//        isCheck = false;
//    }
//    
//    if (ln.length > 24){
//        setError(lastname, 'Tên không lớn hơn 24 ký tự');
//        isCheck = false;
//    }
//
//    if (adrs === '') {
//        setError(address, 'Địa chỉ không được để trống');
//        isCheck = false;
//    }
//
//    if (user === '') {
//        setError(username, 'Username không được để trống');
//        isCheck = false;
//    }
//
//    if (pass === '') {
//        setError(password, 'Password không được để trống');
//        isCheck = false;
//    }
//
//    if (eml === '') {
//        setError(email, 'Email không được để trống');
//        isCheck = false;
//    } else if (!isEmail(eml)) {
//        setError(email, 'Email không đúng định dạng');
//        isCheck = false;
//    }
//
//    if (phn === '') {
//        setError(phone, 'Số điện thoại không được để trống');
//        isCheck = false;
//    } else if (!isPhone(phn)) {
//        setError(phone, 'Số điện thoại không đúng định dạng');
//        isCheck = false;
//    }
//
//    return isCheck;
//}
//
//function setError(e, message) {
//    let parentEle = e.parentNode;
//    parentEle.classList.add('error');
//    parentEle.querySelector('small').innerText = message;
//}
//
////kiểm tra email có hợp lệ
//function isEmail(eml) {
//    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(eml);
//}
////kiểm tra số điẹn thoại có hợp lệ
//function isPhone(nb) {
//    return /(84|0[3|5|7|8|9])+([0-9]{8})\b/.test(nb);
//}
