<%-- 
    Document   : prescription
    Created on : Aug 21, 2022, 10:56:47 AM
    Author     : vinhp
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/employees/doctorsIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>
        
        
<!--DANH SÁCH PHIẾU KHÁM BỆNH-->
<div class="row"> 
    <div class="col-md-6 col-12">
        <c:url value="/employees/prescription" var="action" />
        <form method="post" action="${action}">
            <table class="table table-hover ">
                <tr>
                    <th>Mã phiếu khám</th>
                    <th>Tên khách hàng</th>
                    <th></th>
                </tr>
                <tbody id="myMedicalRecord">
                    <c:forEach items="${medicalRecord2}" var="d">
                        <tr>
                            <td>${d[0]}</td>
                            <td>${d[1]} ${d[2]}</td>
                            <td ><a class="btn btn-primary" href="/Web_QuanLyPhongMach/employees/prescription/${d[0]}">Kê toa</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>

    <div class="col-md-6 col-12"></div>
</div>
