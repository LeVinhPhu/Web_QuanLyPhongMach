<%-- 
    Document   : medicalRecord
    Created on : Aug 21, 2022, 10:55:14 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/employees/doctorsIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>


<c:url value="/employees/medicalRecord/${cusID}" var="action" />
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
        <form:input type="text" path="symptom" class="form-control" id="symptom" placeholder="Nhap trieu chung" name="name" />
        <label for="name">Triệu chứng</label>
        <%--<form:errors path="name" element="div" cssClass="alert alert-danger" />--%>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="conclusion" class="form-control" id="conclusion" placeholder="Nhap ket luan benh" name="conclusion" />
        <label for="conclusion">Kết luận</label>
        <%--<form:errors path="unitPrice" element="div" cssClass="alert alert-danger" />--%>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="note" class="form-control" id="note" placeholder="Ghi chu" name="note" />
        <label for="note">Ghi chú</label>
    </div>

    <div class="form-floating mt-2">
        <input type="submit" id="btnAdd" value="Lập phiếu" class="btn mb-3 mt-3 btn btn-primary"/>
    </div>

</form:form>  