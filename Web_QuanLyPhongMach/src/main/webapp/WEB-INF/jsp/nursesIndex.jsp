<%-- 
    Document   : nursesIndex
    Created on : Aug 21, 2022, 1:57:11 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row mt-5 mb-5">
    <div class="col-md-6 col-xs-12 mt-2 mb-2">
        <div class="">
            <h2 style="font-family: fantasy;">P&QCOMPANY</h2>
            <h6 style="font-family: courier">The best doctor gives the least medicines</h6>
            <hr>
        </div>
    </div>
    <div class = "col-md-3 col-xs-12 mt-2 mb-2">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662061416/Web_QLPM/Avatar/payment_bkbf0p.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <div class="card-body">
                <h4 class="card-title">Kiểm tra phiếu khám</h4>
                <a href="<c:url value="/employees/medicalRecord"/>" class="btn btn-primary">Xác Nhận</a>
            </div>
        </div>
    </div>
    <div class = "col-md-3 col-xs-12 mt-2 mb-2">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662061415/Web_QLPM/Avatar/hospital_vzru5y.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <div class="card-body">
                <h4 class="card-title">Thanh toán hoá đơn</h4>
                <a href="<c:url value="/employees/medicalRecord"/>" class="btn btn-primary">Xác Nhận</a>
            </div>
        </div>
    </div>
</div>