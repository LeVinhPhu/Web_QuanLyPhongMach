<%-- 
    Document   : customer
    Created on : Aug 19, 2022, 10:48:17 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row mt-5 fs-4">
    <div class="col-md-12 col-12" style="align-items: center">

        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/customers/appointments"/>" 
                style="text-decoration: none; color: white">Đặt lịch khám</a>
        </div>
    </div>
</div>

<h1>Hello Admin - Welcome to works</h1>
