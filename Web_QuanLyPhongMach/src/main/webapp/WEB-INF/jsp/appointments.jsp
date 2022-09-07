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

<%--<c:if test = "${check > 0}">--%>


    <div data-bs-toggle="modal" data-bs-target="#myModal" style="margin: 8px; width: 20%"><i class="fas fa-plus"></i>  Đặt lịch</div>
    <!--đặt lịch khám-->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- HEADER & NÚT TẮT -->
                <div class="modal-header" style="text-align:center">
                    <h4 class="modal-title" >Đặt lịch khám</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- BODY -->
                <div class="modal-body">
                    <div>
                        <c:url value="/customers/appointments" var="action" />
                        <form:form method="post" action="${action}" modelAttribute="setAppointments">
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
                            <div class="mt-2" style="text-align: center">
                                <input id="btnSubmit" type="submit" value="Đặt lịch khám" class="btn btn-primary" />
                            </div>
                        </form:form>
                    </div>
                </div>

            </div>
        </div>
    </div>   

<%--</c:if>--%>



<!--DANH SÁCH PHIẾU ĐẶT CỦA 1 KHÁCH HÀNG-->
<div>
    <h1>${currentUser.firstName} ${currentUser.lastName}</h1>

    <table class="table table-hover ">
        <tr>
            <th>
                <i onclick="load()" class="fas fa-redo-alt"></i>
            </th>
            <th>Mã phiếu đặt</th>
            <th>Ngày</th>
            <th>Giờ</th>
            <th>Ghi chú</th>
            <th>Trạng thái</th>
            <th></th>
        </tr>
        <tbody id="myAppointment">
        </tbody>
    </table>
</div>



<script src="<c:url value="/js/appointment.js" />"></script>
<script>
    <c:url value="/api/appointment" var="m" />
                    window.onload = function () {
                        getAppointment('${m}');
                    };
</script>
