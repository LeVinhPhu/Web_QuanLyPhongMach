<%-- 
    Document   : login
    Created on : Aug 25, 2022, 3:25:33 PM
    Author     : phamt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row m-5">

    <div class="col-md-7 col-12 ">
        <div class="">
            <h2 style="font-family: fantasy;">P&QCOMPANY</h2>
            <h6 style="font-family: courier">Welcome ..........</h6>
            <hr>
        </div>
    </div>

    <div class="col-md-1 col-12"></div>

    <div class="col-md-4 col-12 bg-light shadow rounded-3">

        <div class="mt-2 mb-2" style="">
            <h2 style="font-family: Helvetica">Login</h2>
        </div>
        <div class="mb-3">
            <c:url value="/login" var="action"></c:url>
            <form:form method="post" action="${action}" modelAttribute="Account">
                <div class="input-row form-floating">

                    <form:input type="text" class="form-control" path="username" id="phoneNumber" placeholder="phoneNumber" />
                    <label for="address">Tài khoản</label>
                </div>
                <div class="input-row form-floating">
                    <form:input type="password" class="form-control" path="password" id="password" placeholder="password" />
                    <label for="address">Mật khẩu</label>
                </div>
                <hr>

                <div class="form-floating"  style="text-align: center">
                    <input type="submit" value="Đăng nhập" class="btn btn-primary" id="bt-submit"/>
                </div>

                <div class="form-floating" style="text-align: center">
                    <span style="font-size: 12px">Bạn chưa có tài khoản? <a href="/Web_QuanLyPhongMach/register" style="text-decoration: none">Đăng ký</a></span>
                </div>
            </form:form>
        </div>
    </div>
</div>
</div>


