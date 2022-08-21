<%-- 
    Document   : admin
    Created on : Aug 19, 2022, 10:00:31 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row mt-2">

    <div class = "col-md-12 col-xs-12">
        <div id="demo" class="carousel slide" data-bs-ride="carousel">

            <div class="carousel-indicators">
                <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
            </div>

            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img
                        src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1660922740/Web_QLPM/content4_grhsjb.png" alt="Los Angeles" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img
                        src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1660922735/Web_QLPM/content3_sikeqe.png" alt="Chicago" class="d-block w-100">
                </div>
            </div>

            <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                <span class="carousel-control-next-icon"></span>
            </button>
        </div>
    </div>
</div>

<div class="row mt-5 fs-4">
    <div class="col-md-12 col-12" style="align-items: center">

        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/admins/adminsManager"/>" 
                style="text-decoration: none; color: white">Quản lý Admin</a>
        </div>

        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/admins/employeesManager"/>" 
                style="text-decoration: none; color: white">Quản lý nhân viên</a>
        </div>

        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/admins/customersManager"/>" 
                style="text-decoration: none; color: white">Quản lý khách hàng</a>
        </div>

        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/admins/reportsManager"/>" 
                style="text-decoration: none; color: white">Thống kê báo cáo</a>
        </div>
                
        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/admins/medicinesManager"/>" 
                style="text-decoration: none; color: white">Quản lý Thuốc</a>
        </div>

        <div class="col-md-2 col-12 mb-2 btn btn-success">
            <a 
                href="<c:url value="/admins/onCallManager"/>" 
                style="text-decoration: none; color: white">Xếp lịch trực</a>
        </div>
    </div>
</div>

<h1>Hello Admin - Welcome to works</h1>






<!--
<div class="row" style="padding: 5px">
<c:forEach items="${employees}" var="empl">
    <div class = "col-md-3 col-xs-12">
        <div class="card">
            <img class="card-img-top" src="${empl.image}" alt="Card image">
            <div class="card-body">
                <h4 class="card-title">${empl.firstName} ${empl.lastName}</h4>
                <p class="card-text">Some example text.</p>
                <a href="#" class="btn btn-primary">See Profile</a>
            </div>
        </div>
    </div>
</c:forEach> 
</div>-->