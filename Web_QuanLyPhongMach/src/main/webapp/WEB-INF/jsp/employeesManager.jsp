<%-- 
    Document   : employeesManager
    Created on : Aug 29, 2022, 12:14:15 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="row  mb-4 mt-3" style="">
    <div class="col-md-5 col-12">
        <div class="mt-3">
            <h2 style="font-family: fantasy;">P&Q CLINIC </h2>
            <h6 style="font-family: courier">Only a life lived for others is a life worthwhile</h6>
            <c:if test="${param.accessDenied != null}"> 
                <h6 style="font-family: courier; color: red; font-weight: bold">Bạn cần đăng nhập để tiếp tục !</h6>
            </c:if>
            <hr>
        </div>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/adminIndex" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/home_hxzsfb.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Trang Chủ</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/adminsManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/writing_hkvivo.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">QL Admin</h6>
            </div>
        </a>
    </div>    
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/employeesManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/writing_hkvivo.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">QL Nhân Viên </h6>
            </div>
        </a>
    </div>    
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/medicinesManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/writing_hkvivo.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">QL Thuốc</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/customersManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556169/Web_QLPM/Avatar/rating_jgs7jn.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Khách Hàng</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/reportsManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556013/Web_QLPM/Avatar/growth_z4ewzy.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Thống Kê</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/onCallManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/calendar_2_pbkqiv.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Lịch Trực</h6>
            </div>
        </a>
    </div>
</div>   


<h2 style="text-align: center; margin-top: 10px">QUẢN LÝ NHÂN VIÊN</h2>

<div class="row mt-4 mb-4">
    <div class="col-md-9 col-12">
        <div data-bs-toggle="modal" data-bs-target="#addModal" style="margin: 8px; width: 20%"><i class="fas fa-plus"></i>  Thêm nhân viên</div>
    </div>
    <div class="col-md-3 col-12">
        <c:url value="/admins/medicinesManager" var="action" />
        <form action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên thuốc...">
            <button type="submit" class="btn"><i class="fas fa-search"></i></button>
        </form>
    </div>
</div>

<div class="row mt-2 mb-2 ">
    <div class="col-md-12 sol-12 shadow" style="overflow: auto; height: 500px; border-radius: 10px">
        <div class = "col-md-12 col-12">

            <table class="table table-hover">
                <tr class="table-info">
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Ngày Sinh</th>
                    <th>Giới Tính</th>
                    <th>SĐT</th>
                    <th>Địa Chỉ</th>
                    <th></th>
                    <th><th>
                </tr>
                <tbody id="myEmployee">
                    <tr>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>



<!-- The Modal Add -->
<div class="modal" id="addModal">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen-sm-down">
        <div class="modal-content">

            <h6></h6>
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
                            <form:input type="text" path="firstName" class="form-control" id="firstName" placeholder="Nhap ho va ten dem" name="name" value="" />
                            <label for="firstName">Họ và tên đệm</label>
                            <small>Error</small>
                        </div>
                        <div class="form-floating input-row">
                            <form:input type="text" path="lastName" class="form-control" id="lastName" placeholder="Nhap ten" name="name" />
                            <label for="lastName">Tên</label>
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
                            <label for="positionId" class="form-label">Chức vụ</label>
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
        getEmployees("${u}");
    }
</script>


