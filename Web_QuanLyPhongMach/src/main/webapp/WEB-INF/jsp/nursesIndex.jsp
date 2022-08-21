<%-- 
    Document   : nursesIndex
    Created on : Aug 21, 2022, 1:57:11 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row mt-5 fs-4">
    
    <div class="col-md-12 col-12" style="align-items: center">
        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/employees/appointmentsManager"/>" 
                style="text-decoration: none; color: white">Quản lý lịch khám</a>
        </div>
                
        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/employees/billsManager"/>" 
                style="text-decoration: none; color: white">Thanh Toán</a>
        </div>
    </div>
                
</div>