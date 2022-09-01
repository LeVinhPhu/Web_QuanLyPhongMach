<%-- 
    Document   : details
    Created on : Sep 1, 2022, 9:55:44 AM
    Author     : phamt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 style="text-align: center">${medicine.name}</h1>
<c:url value="/admins/medicinesManager/${medicine.id}" var="action" />
<form:form method="post" action="${action}" modelAttribute="medicine" enctype="multipart/form-data">
    <div style="width: 50%; margin-left: 25%">
        <div class="form-floating mb-2 mt-3">
            <form:input type="text" path="name" class="form-control" id="name" placeholder="Nhap ten" name="name" />
            <label for="name">Tên thuốc</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select path="unitId" class="form-select" id="unit" name="unit">
                <option selected="selected" value="${medicine.unitId.id}"}>Chọn đơn vị</option>
                <c:forEach items="${units}" var="u">
                    <option value="${u.id}">${u.name}</option>
                </c:forEach>
            </form:select>
            <label for="unit" class="form-label">Đơn vị</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" path="unitPrice" class="form-control" id="unitPrice" placeholder="Nhap gia" name="name" />
            <label for="name">Đơn giá</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="number" path="quantity" class="form-control" id="unitPrice" placeholder="Nhap so luong" name="name" />
            <label for="name">Số lượng</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:select path="supplierId" class="form-select" id="sup" name="sup">
                <option selected="selected" value="${medicine.supplierId.id}"}>Chọn nhà cung cấp</option>
                <c:forEach items="${suppliers}" var="s">
                    <option value="${s.id}">${s.companyName}</option>
                </c:forEach>
            </form:select>
            <label for="sup" class="form-label">Nhà cung cấp</label>
        </div>


        <input type="submit" value="Sửa thuốc" class="btn btn-warning mb-3 mt-3" />
    </div>


</form:form>
