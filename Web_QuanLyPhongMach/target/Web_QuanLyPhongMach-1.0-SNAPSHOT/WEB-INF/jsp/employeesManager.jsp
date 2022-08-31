<%-- 
    Document   : employeesManager
    Created on : Aug 29, 2022, 12:14:15 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h2 style="text-align: center; margin-top: 10px">QUẢN LÝ NHÂN VIÊN</h2>

<!--    <div class="col-md-5 col-12 mb-2 btn btn-success">
        <a 
            href="<c:url value="/admins/adminIndex"/>" 
            style="text-decoration: none; color: white">Quay lại</a>
    </div>-->
<div class="row mt-2 bg-light">
    <div class="col-md-8 col-12 mt-2 mb-2">
        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addModal" id="btn-add">ADD EMPLOYEE</button>
    </div>

    <div class="col-md-4 col-12 mt-2 mb-2">
        <c:url value="/" var="action" />
        <form action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhap tu khoa...">
            <button typeubmit" class="btn btn-primary" type="button">SEARCH</button>
        </form>
    </div>
</div>

<div class="row mt-2 mb-2">
    <div class="col-md-10 sol-12 border rounded bg-light">
        <div class = "col-md-12 col-12">

            <h3 class="text-center" style="margin-top: 10px; margin-bottom: 10px">Danh Sách Nhân Viên</h3>

            <table class="table table-hover" style="margin-left: 5px; margin-right: 5px">
                <tr class="table-success">
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Ngày Sinh</th>
                    <th>Giới Tính</th>
                    <th>SĐT</th>
                    <th>Địa Chỉ</th>
                    <th></th>
                    <th><th>
                </tr>
                <tbody id="myEmployee" style="width: 10px; height: 50em">
                    <tr>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="col-md-2 col-12">
        <div class="list-group">
            <a class="list-group-item list-group-item-action active">
                Tiện ích
            </a>
            <a href="/Web_QuanLyPhongMach/admins/adminIndex" class="list-group-item list-group-item-action">Trang Chủ</a>
            <a href="/Web_QuanLyPhongMach/admins/adminsManager" class="list-group-item list-group-item-action">Quản lý Admin</a>
            <a href="/Web_QuanLyPhongMach/admins/employeesManager" class="list-group-item list-group-item-action">Quản lý Nhân viên</a>
            <a href="/Web_QuanLyPhongMach/admins/medicinesManager" class="list-group-item list-group-item-action">Quản lý Thuốc</a>
            <a href="/Web_QuanLyPhongMach/admins/customersManager" class="list-group-item list-group-item-action">Quản lý Khách Hàng</a>
            <a href="/Web_QuanLyPhongMach/admins/reportsManager" class="list-group-item list-group-item-action">Quản lý Thống kê</a>
            <a href="/Web_QuanLyPhongMach/admins/onCallManager" class="list-group-item list-group-item-action">Quản lý Lịch trực</a>
        </div>
    </div>
</div>



<!-- The Modal Add -->
<div class="modal" id="addModal">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen-sm-down">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Thêm Nhân Viên</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="AddEmployee">
                <div class = "col-md-12 col-xs-12">
                    <c:url value="/admins/employeesManager" var="action"></c:url>
                    <form:form id="myForm" method="post" action="${action}" modelAttribute="employee" enctype="multipart/form-data">

                        <div class="form-floating input-row">
                            <form:input type="text" path="firstName" class="form-control" id="firstName" placeholder="Nhap ho va ten dem" name="name" />
                            <label for="name">Họ và tên đệm</label>
                            <small>Error</small>
                        </div>
                        <div class="form-floating input-row">
                            <form:input type="text" path="lastName" class="form-control" id="lastName" placeholder="Nhap ten" name="name" />
                            <label for="name">Tên</label>
                            <small>Error</small>
                        </div>
                        <div class="input-row form-floating">
                            <form:input type="date" class="form-control" path="dateOfBirth" id="dateOfBirth" value="0000-00-00"/>
                            <label for="dateOfBirth">Ngày Sinh:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>      

                        <div class="input-row form-floating">
                            <form:select path="positionId" class="form-select" id="positionId" name="positionId">
                                <c:forEach items="${positions}" var="p">
                                    <option value="${p.id}">${p.name}</option>
                                </c:forEach>
                            </form:select>
                            <label for="position" class="form-label">Chức vụ</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>

                        <div class="input-row form-floating">
                            <form:select path="sex" class="form-select" id="sex" name="sex">
                                <option value="Nam">Nam</option>
                                <option value="Nữ">Nữ</option>
                                <option value="Khác">Khác</option>
                            </form:select>
                            <label for="sex" class="form-label">Giới Tính</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>

                        <div class="input-row form-floating">
                            <form:input type="text" class="form-control" path="address" id="address" placeholder="address" />
                            <label for="address">Địa chỉ:</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>


                        <div class="input-row form-floating">
                            <form:input type="text" class="form-control" path="email" id="email" placeholder="email" />
                            <label for="email">Email:</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>

                        <div class="input-row form-floating">
                            <form:input type="text" class="form-control" path="phone" id="phone" placeholder="phone" />
                            <label for="phone">Số điện thoại:</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>

                        <div class="input-row form-floating">
                            <form:select  type="text" path="specialize" class="form-select" id="specialize" name="specialize">
                                <option value="Khoa Nội">Khoa Nội</option>
                                <option value="Khoa Ngoại">Khoa Ngoại</option>
                                <option value="Khoa Xét Nghiệm">Khoa Xét Nghiệm</option>
                                <option value="Khoa Chuẩn đoán hình ảnh">Khoa Chuẩn đoán hình ảnh</option>
                            </form:select>
                            <label for="specialize" class="form-label">Chuyên Khoa</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>

                        <div class="input-row form-floating">
                            <form:input type="text" class="form-control" path="username" id="username" placeholder="username" />
                            <label for="username">Username:</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>

                        <div class="input-row form-floating">
                            <form:input type="text" class="form-control" path="password" id="password" placeholder="password" />
                            <label for="password">Password:</label>
                            <!--Sinh lổi-->
                            <small></small>

                        </div>

                        <div class="form-floating mb-2" style="text-align: right;">
                            <input type="submit" value="Xác nhận" class="btn btn-danger" id="bt-submit"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>






<!-- The Modal Detail -->
<div class="modal" id="detailModal">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen-sm-down">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h5 class="modal-title">Chi tiết nhân viên</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="detailEmployee">
                
            </div>
            <!-- Modal footer -->
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>        

<script src="<c:url value="/js/employee.js" />"></script>
<script>
    <c:url value="/api/employeesManager" var="u" />
    window.onload = function () {
        getEmployees("${u}")
    }
</script>

