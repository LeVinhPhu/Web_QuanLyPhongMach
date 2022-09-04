<%-- 
    Document   : medicalRecord
    Created on : Aug 21, 2022, 10:55:14 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/employees/doctorsIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>


<c:url value="/medicalRecord/{cusID}" var="action" />
<form:form id="myForm" method="post" action="${action}" modelAttribute="medicalRecord" enctype="multipart/form-data">

    <div class="form-floating input-row">
        <form:select path="serviceId" class="form-select" id="serviceId" name="serviceId">
            <c:forEach items="${services}" var="s">
                <option value="${s.id}">${s.name}</option>
            </c:forEach>
        </form:select>
        <label for="serviceId" class="form-label">Loại dịch vụ</label>
    </div>
    
    <div class="form-floating input-row">
        <form:input type="text" path="name" class="form-control" id="name" placeholder="Nhap ten" name="name" />
        <label for="name">Triệu chứng</label>
        <%--<form:errors path="name" element="div" cssClass="alert alert-danger" />--%>
        <small></small>
    </div>

    

    <div class="form-floating input-row">
        <form:input type="number" path="unitPrice" class="form-control" id="unitPrice" placeholder="Nhap gia" name="unitPrice" />
        <label for="unitPrice">Đơn giá</label>
        <%--<form:errors path="unitPrice" element="div" cssClass="alert alert-danger" />--%>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="number" path="quantity" class="form-control" id="quantity" placeholder="Nhap so luong" name="quantity" />
        <label for="quantity">Số lượng</label>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="note" class="form-control" id="note" placeholder="Ghi chu" name="note" />
        <label for="note">Ghi chú</label>
    </div>

    <div class="form-floating mt-2" style="text-align: right">
        <input type="submit" id="btnAdd" value="Thêm thuốc" class="btn mb-3 mt-3" style="background-color: #d1e7dd" />
    </div>

</form:form>  