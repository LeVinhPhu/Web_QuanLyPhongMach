<%-- 
    Document   : appointments
    Created on : Aug 21, 2022, 11:13:05 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/customers/customersIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>

<h1>ĐẶT LỊCH KHÁM</h1>
<c:url value="/customers/appointments" var="action" />
<form:form method="post" action="${action}" modelAttribute="appointments">
    <div class="input-row form-floating">
        <form:input path="date" class="form-control" type="date" id="date" name="date" />
        <label for="date">Chọn ngày</label>
        <small>Error</small>
    </div> 
    <div class="form-floating input-row">
        <form:input type="text" path="time" class="form-control" id="time" placeholder="Nhap ngay" name="name" />
        <label for="name">Nhập giờ</label>
        <small>Error</small>
    </div>
    <div class="form-floating input-row">
        <form:input type="text" path="note" class="form-control" id="note" placeholder="note" name="name" />
        <label for="name">Ghi chú</label>
        <small>Error</small>
    </div>
    <c:if test="${currentUser != null}">
        <input style="display: none" type="number" name="idCus" value="${currentUser.id}"/>
    </c:if>

    <div class="mt-2" style="text-align: center">
        <input id="btnSubmit" type="submit" value="Đặt lịch khám" class="btn btn-primary" />
    </div>
</form:form>