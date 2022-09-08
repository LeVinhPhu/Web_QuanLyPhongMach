<%-- 
    Document   : billsManagerForPayment
    Created on : Sep 8, 2022, 10:59:25 AM
    Author     : phamt
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>Mã phiếu khám ${medicalPayment[0][0]} </div> 
<div>Tên khách hàng: ${medicalPayment[0][1]} ${medicalPayment[0][2]}</div>
<div>Dịch vụ: ${medicalPayment[0][3]} </div>
<div>Giá dịch vụ: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${medicalPayment[0][4]}" /> VNĐ</div>

Toa thuốc

<c:url value="/employees/billsManager/${medicalRecordID}" var="action"></c:url>
<form method="post" action="${action}">
    <div class="form-floating"  style="text-align: center">
        <input type="submit" value="Thanh toán" class="btn btn-primary"/>
    </div>
</form>

