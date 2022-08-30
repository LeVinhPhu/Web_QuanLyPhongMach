<%-- 
    Document   : employeesManager
    Created on : Aug 29, 2022, 12:14:15 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 style="text-align: center">QUẢN LÝ NHÂN VIÊN</h1>


<div class="row">
    <div class="col-md-5 col-12 mb-2 btn btn-success">
        <a 
            href="<c:url value="/admins/adminIndex"/>" 
            style="text-decoration: none; color: white">Quay lại</a>
    </div>

    <div class="col-md-5 col-12 mb-2">
        <c:url value="/" var="action" />
        <form action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhap tu khoa...">
            <button type="submit" class="btn btn-primary" type="button">Tim</button>
        </form>
    </div>

</div>

<button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addModal">ADD</button>

<div class="row mt-2">
    <div class="col-md-12 col-xs-12">
        <div class = "col-md-12 col-xs-12">
            <h3 class="text-center">Danh Sách Nhân Viên</h3>
            <table class="table table-hover" style="margin-left: 10px;">
                <tr class="">
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
                    <form:form method="post" action="${action}" modelAttribute="employee" enctype="multipart/form-data">

                        <div class="input-row form-floating mb-3 mt-3" style="margin-left: 5px; margin-right: 5px">
                            <form:input type="text" class="form-control" path="firstName" id="firstName" placeholder="firstName" />
                            <label for="firstName">Họ và tên đệm</label>                     
                            <small></small>
                            
                        </div>

                        <div class="input-row form-floating mb-3 mt-3 " style="margin-left: 5px; margin-right: 5px">
                            <form:input type="text" class="form-control" path="lastName" id="lastName" placeholder="lastName" />
                            <label for="lastName">Tên:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>

                        <div class="input-row form-floating mb-3 mt-3" style="margin-left: 5px; margin-right: 5px">
                            <form:input type="date" class="form-control" path="dateOfBirth" id="dateOfBirth" value="0000-00-00"/>
                            <label for="dateOfBirth">Ngày Sinh:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>      

                        <div class="input-row form-floating mb-3 mt-3" style="margin-left: 5px; margin-right: 5px">
                            <form:select path="positionId" class="form-select" id="positionId" name="positionId">
                                <c:forEach items="${positions}" var="p">
                                    <option value="${p.id}">${p.name}</option>
                                </c:forEach>
                            </form:select>
                            <label for="position" class="form-label">Chức vụ</label>
                            <!--Sinh lổi-->
                            <small></small>
                     
                        </div>

                        <div class="input-row form-floating mb-3 mt-3" style="margin-left: 5px; margin-right: 5px">
                            <form:select path="sex" class="form-select" id="sex" name="sex">
                                <option value="Nam">Nam</option>
                                <option value="Nữ">Nữ</option>
                                <option value="Khác">Khác</option>
                            </form:select>
                            <label for="sex" class="form-label">Giới Tính</label>
                            <!--Sinh lổi-->
                            <p style="font-size: 14px; color:red; margin-left:2px;" id="mySex"></p>
                        
                        </div>

                        <div class="input-row form-floating mb-3 mt-3" style="margin-left: 5px; margin-right: 5px">
                            <form:input type="text" class="form-control" path="address" id="address" placeholder="address" />
                            <label for="address">Địa chỉ:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        
                        </div>


                        <div class="input-row form-floating mb-3 mt-3" style="margin-left: 5px; margin-right: 5px">
                            <form:input type="text" class="form-control" path="email" id="email" placeholder="email" />
                            <label for="email">Email:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        
                        </div>

                        <div class="input-row form-floating mb-3 mt-3"style="margin-left: 5px; margin-right: 5px">
                            <form:input type="text" class="form-control" path="phone" id="phone" placeholder="phone" />
                            <label for="phone">Số điện thoại:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        
                        </div>

                        <div class="input-row form-floating mb-3 mt-3" style="margin-left: 5px; margin-right: 5px">
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

                        <div class="input-row form-floating mb-3 mt-3"style="margin-left: 5px; margin-right: 5px">
                            <form:input type="text" class="form-control" path="username" id="12" placeholder="username" />
                            <label for="username">Username:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        
                        </div>

                        <div class="input-row form-floating mb-3 mt-3"style="margin-left: 5px; margin-right: 5px">
                            <form:input type="text" class="form-control" path="password" id="password" placeholder="password" />
                            <label for="password">Password:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        
                        </div>

                        <div class="input-row form-floating mb-2" style="text-align: right; margin-right: 5px">
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
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="detailEmployee">

            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

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

