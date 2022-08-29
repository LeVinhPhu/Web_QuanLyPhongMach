<%-- 
    Document   : register
    Created on : Aug 21, 2022, 11:10:26 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 style="text-align: center" class="mt-3">DANG KY TAI KHOAN</h2>

<div style="width: 50%; margin-left: 25%; background-color: #f3f3f3">
    <div style="width: 90%; margin: 5%; padding-top: 5%">
        <c:url value="/register" var="action" />
        <form:form method="post" action="${action}" modelAttribute="customers" enctype="multipart/form-data">
            <%--<form:errors path="*" element="div" cssClass="alert alert-danger" />--%>
            <div class="form-floating mb-2 mt-3">
                <form:input type="text" path="firstName" class="form-control" id="firstName" placeholder="Nhap ho va ten dem" name="name" />
                <label for="name">Họ và tên đệm</label>
                <form:errors path="firstName" element="div" cssClass="invalid-feedback" />
                <form:errors path="firstName" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>
            <div class="form-floating mb-2 mt-3">
                <form:input type="text" path="lastName" class="form-control" id="lastName" placeholder="Nhap ten" name="name" />
                <label for="name">Tên</label>
                <form:errors path="lastName" element="div" cssClass="invalid-feedback" />
                <form:errors path="lastName" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:select path="sex" class="form-select" id="sex" name="sex">
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                    <option value="Khác">Khác</option>
                </form:select>
                <label for="sex" class="form-label">Giới tính</label>
            </div>
            <div class="mb-2 mt-3">
                <label style="margin-left: 1%;" for="birthday">Ngày sinh</label>
                <form:input path="dateOfBirth" class="form-control" type="date" id="birthday" name="birthday" />
            </div>    
            <div class="form-floating mb-2 mt-3">
                <form:input type="text" path="address" class="form-control" id="address" placeholder="Nhap dia chi" name="name" />
                <label for="name">Địa chỉ</label>
            </div>
            <div class="form-floating mb-2 mt-3">
                <form:input type="email" path="email" class="form-control" id="email" placeholder="Nhap email" name="name" />
                <label for="name">Email</label>
            </div>
            <div class="form-floating mb-2 mt-3">
                <form:input type="number" path="phoneNumber" class="form-control" id="phoneNumber" placeholder="Nhap SDT" name="name" />
                <label for="name">Số điện thoại</label>
                <form:errors path="phoneNumber" element="div" cssClass="invalid-feedback" />
                <form:errors path="phoneNumber" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>
            <!--    <div class="mb-2 mt-3">
                    <label style="margin-left: 4.5%;" class="ml-2"for="file">Chọn ảnh</label>
            <%--<form:input type="file" path="file" id="file" class="form-control" />--%>
        </div>-->    
            <div class="form-floating mb-2 mt-3">
                <form:input type="password" path="password" class="form-control" id="password" placeholder="Mat khau" name="p" />
                <label for="p">Mật khẩu</label>
                <form:errors path="password" element="div" cssClass="invalid-feedback" />
                <form:errors path="password" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>
            <div class="form-floating mb-2 mt-3">
                <form:input type="password" path="confirmPassword" class="form-control" id="password" placeholder="Xac nhan mat khau" name="p" />
                <label for="p">Xác nhận mật khẩu</label>
                <form:errors path="confirmPassword" element="div" cssClass="invalid-feedback" />
                <form:errors path="confirmPassword" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
                <c:if test="${errMsg != null}">
                    <div class="alert alert-danger">
                        ${errMsg}
                    </div>
                </c:if>
            </div>
            <div style="text-align: center">
                <input type="submit" value="Đăng ký" class="btn mb-3 mt-3" style="background-color: blue; color: white" />
            </div>

        </form:form>  
    </div>


</div>
