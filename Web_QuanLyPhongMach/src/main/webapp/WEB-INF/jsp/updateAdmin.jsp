<%-- 
    Document   : updateAdmin
    Created on : Sep 4, 2022, 3:59:32 AM
    Author     : phamt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 class="mt-2 mb-2" style="text-align: center">${adminUpdate.firstName} ${adminUpdate.lastName}</h3>
<div style="text-align: center">
    <img src="${adminUpdate.image}" width='150' />
</div>
    
<form:errors path="**" element="div" style="color: red; font-size: 13px; margin-top: 2px" />
<c:url value="/admins/adminsManager/${adminUpdate.id}" var="action" />
<form:form id="formUpdate" method="post" action="${action}" modelAttribute="adminUpdate" enctype="multipart/form-data">
    <div style="width: 50%; margin-left: 25%">
        <div class="form-floating input-row">
            <form:input type="text" path="firstName" class="form-control" id="firstName" placeholder="Nhap ten" name="firstName" />
            <label for="firstName">Họ và tên đệm <span style="color: red">*</span></label>
            <%--<form:errors path="name" element="div" style="color: red; font-size: 13px; margin-top: 2px" />--%>
            <small></small>
        </div>

<!--        <div class="form-floating input-row">
            <%--<form:input type="text" path="lastName" class="form-control" id="lastName" placeholder="Nhap ten" name="lastName" />--%>
            <label for="lastName">Tên <span style="color: red">*</span></label>
            <small></small>
        </div>

        <div class="form-floating input-row">
            <%--<form:select path="sex" class="form-select" id="sex" name="sex">--%>
                <option value="Nam">Nam</option>
                <option value="Nữ">Nữ</option>
                <option value="Khác">Khác</option>
            <%--</form:select>--%>
            <label for="sex" class="form-label">Giới tính</label>
        </div>

        <div class="input-row form-floating">
            <%--<form:input path="dateOfBirth" class="form-control" type="date" id="dateOfBirth" name="dateOfBirth" />--%>
            <label for="dateOfBirth">Ngày sinh</label>
            <small>Error</small>
        </div>    

        <div class="form-floating input-row">
            <%--<form:input type="text" path="address" class="form-control" id="address" placeholder="Nhap dia chi" name="name" />--%>
            <label for="name">Địa chỉ</label>
        </div>

        <div class="form-floating mt-3 input-row">
            <%--<form:input type="email" path="email" class="form-control" id="email" placeholder="Nhap email" name="name" />--%>
            <label for="name">Email</label>
            <small>Error</small>
        </div>
            
        <div class="form-floating input-row">
            <%--<form:input type="number" path="phone" class="form-control" id="phone" placeholder="Nhap SDT" name="phone" />--%>
            <label for="phone">Số điện thoại <span style="color: red">*</span></label>
            <small>Error</small>
        </div>-->
<!--        <div class="input-row">
            <label style="margin-left: 4.5%;" class="ml-2"for="file">Chọn ảnh</label>
            <%--<form:input type="file" path="file" name="file" id="file" class="form-control" />--%>
        </div>-->
<!--        <div class="form-floating input-row">
            <form:input type="text" path="note" class="form-control" id="name" placeholder="Nhap ten" name="name" />
            <label for="name">Ghi chú</label>
        </div>-->
        <div>
            <input id="btnUpdate" type="submit" value="Cập nhật" class="btn btn-warning mb-3 mt-3" />
        </div>    
    </div>


</form:form>
<script src="<c:url value="/js/updateAdmin.js" />"></script>