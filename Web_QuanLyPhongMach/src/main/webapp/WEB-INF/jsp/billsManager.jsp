<%-- 
    Document   : billsManager
    Created on : Aug 21, 2022, 11:09:11 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/employees/nursesIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>

<!--DANH SÁCH PHIẾU KHÁM BỆNH-->
<div class="row"> 
    <div class="col-md-2 col-12"></div><!-- comment -->
    <div class="col-md-8 col-12" style="overflow: auto; height: 500px; border-radius: 10px">
        <c:url value="/employees/billsManager" var="action" />
        <form method="post" action="${action}">
            <table class="table table-hover">
                <tr class="table-primary">
                    <th>Mã phiếu khám</th>
                    <th>Tên khách hàng</th>
                    <th>Loại dịch vụ</th>
                    <th>Tổng tiền</th>
                    <th></th>
                </tr>
                <tbody id="myMedicalRecord">
                    <c:forEach items="${medicalRecordForNurse}" var="d">
                        <tr>
                            <td>${d[1]}</td>
                            <td>${d[2]} ${d[3]}</td>
                            <td>${d[4]}</td>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${d[0]}" /> VNĐ</td>
                            <td style="text-align: right"><a class="btn btn-primary" href="/Web_QuanLyPhongMach/employees/billsManager/${d[1]}">Thanh toán</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>

    <div class="col-md-2 col-12"></div>
</div>

        <script src="<c:url value="/js/appointment.js" />"></script>
<script>
    <c:url value="/api/appointment" var="m" />
    window.onload = function () {
        getAppointmentForDoctor('${m}');
    };
</script>