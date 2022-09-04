<%-- 
    Document   : adminsProfile
    Created on : Sep 4, 2022, 12:40:08 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h6></h6>
<!-- Modal Header -->
<div class="">
    <h4 class="modal-title">Thêm Nhân Viên</h4>
</div>

<!-- Modal body -->
<div class="row">
    <div class = "col-md-12 col-xs-12">
        <c:url value="/admins/adminsProfile" var="action"></c:url>
        <form:form id="myForm" method="post" action="${action}" modelAttribute="updateProfileAdmin" enctype="multipart/form-data">
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


