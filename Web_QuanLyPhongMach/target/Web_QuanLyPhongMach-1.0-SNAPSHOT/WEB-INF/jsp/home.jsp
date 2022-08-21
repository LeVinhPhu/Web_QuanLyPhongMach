<%-- 
    Document   : home
    Created on : Aug 10, 2022, 9:42:25 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row" style="padding: 5px">
    <div class = "col-md-4 col-xs-12" style="align-items: center">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Admin</h4>
                <a href="<c:url value="admins/adminIndex"/>" class="btn btn-primary">Đăng Nhập</a>
            </div>
        </div>
    </div>
    
    <div class = "col-md-4 col-xs-12" style="align-items: center">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Bác sĩ</h4>
                <a href="<c:url value="employees/doctorsIndex"/>" class="btn btn-primary">Đăng Nhập</a>
            </div>
        </div>
    </div>
            
    <div class = "col-md-4 col-xs-12" style="align-items: center">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Y tá</h4>
                <a href="<c:url value="employees/nursesIndex"/>" class="btn btn-primary">Đăng Nhập</a>
            </div>
        </div>
    </div>
    
    <div class = "col-md-4 col-xs-12" style="align-items: center">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Khách Hàng</h4>
                <a href="<c:url value="customers/customersIndex"/>" class="btn btn-primary">Đăng Nhập</a>
            </div>
        </div>
    </div>
</div>

