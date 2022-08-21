<%-- 
    Document   : employee
    Created on : Aug 19, 2022, 10:48:08 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row mt-5 fs-4">
    
    <div class="col-md-12 col-12" style="align-items: center">
        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/employees/medicalRecord"/>" 
                style="text-decoration: none; color: white">Khám Bệnh</a>
        </div>
                
        <div class="col-md-2 col-12 mb-2 btn btn-primary">
            <a 
                href="<c:url value="/employees/prescription"/>" 
                style="text-decoration: none; color: white">Kê Toa</a>
        </div>
    </div>
                
</div>