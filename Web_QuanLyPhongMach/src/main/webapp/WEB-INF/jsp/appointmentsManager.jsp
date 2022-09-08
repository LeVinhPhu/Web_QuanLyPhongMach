<%-- 
    Document   : appointmentsManager
    Created on : Aug 21, 2022, 11:12:38 AM
    Author     : vinhp
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/employees/nursesIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>
<!--DANH SÁCH PHIẾU ĐẶT CỦA KHÁCH HÀNG-->
<div class=""> 
    <div style="height: 450px; overflow: auto"class="">
        <c:url value="/employees/appointmentsManager" var="action" />
        <form method="post" action="${action}">
            <table class="table table-hover ">
                <tr>
                    <th>Mã phiếu đặt</th>
                    <th>Tên khách hàng</th>
                    <th>Ngày</th>
                    <th>Giờ</th>
                    <th>Ghi chú</th>
                    <th></th>
                </tr>
                <tbody id="myAppointmentForNurse">
                    <%--<c:forEach items="${appointments}" var="a">--%>
<!--                        <tr>
                            <td>${a[0]}</td>
                            <td>${a[5]} ${a[6]}</td>
                            <td>${a[1]}</td>
                            <td>${a[2]}</td>
                            <td>${a[3]}</td>
                            <td><input style="display: none" type="number" class="form-control" value="${a[0]}" name="idAppointment">
                                <button type="submit" class="btn btn-primary" >Xác nhận</button></td>
                        </tr>-->
                    <%--</c:forEach>--%>
                </tbody>
            </table>
        </form>

    </div>
</div>
            
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>        

<script src="<c:url value="/js/appointment.js" />"></script>
<script>
    <c:url value="/api/appointment" var="m" />
    window.onload = function () {
        getAppointmentForNurse('${m}');
    };
</script>
