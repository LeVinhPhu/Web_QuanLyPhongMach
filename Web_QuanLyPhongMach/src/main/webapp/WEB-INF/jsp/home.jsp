<%-- 
    Document   : home
    Created on : Aug 10, 2022, 9:42:25 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="mt-3">
    <h2 style="font-family: fantasy;">WELCOME TO P&Q CLINIC </h2>
    <h6 style="font-family: courier">Only a life lived for others is a life worthwhile</h6>
    <c:if test="${param.accessDenied != null}"> 
        <h6 style="font-family: courier; color: red; font-weight: bold">Bạn cần đăng nhập để tiếp tục !</h6>
    </c:if>
    <hr>
</div>
<div class="row  mb-5 mt-5" style="padding: 5px;">
    <c:url value="/" var="action" />
    <div class = "col-md-3 col-xs-12 mt-2 mb-2">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662035604/Web_QLPM/Avatar/login_f058f2.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <h4 class="card-title">Admin</h4>
            <div class="card-body">
                <form method="post" action="${action}" class="d-flex">
                    <input title="text" name="role" style="display: none" value="roleAdmin"/>
                    <button type="submit" id="bt-Admin" class="btn btn-primary">Đăng Nhập</button>
                </form>
            </div>
        </div>
    </div>

    <div class = "col-md-3 col-xs-12 mt-2 mb-2" style="align-items: center">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662035605/Web_QLPM/Avatar/surgeon_zqi34g.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <h4 class="card-title">Bác sĩ</h4>
            <div class="card-body">

                <form method="post" action="${action}" class="d-flex">
                    <input title="text" name="role" style="display: none" value="roleDoctor"/>
                    <button type="submit" id="bt-Doctor" class="btn btn-primary">Đăng Nhập</button>
                </form>
            </div>
        </div>
    </div>

    <div class = "col-md-3 col-xs-12 mt-2 mb-2" style="align-items: center">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662035839/Web_QLPM/Avatar/doctor_1_k9jdhx.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <h4 class="card-title">Y tá</h4>
            <div class="card-body">
                <form method="post" action="${action}" class="d-flex">
                    <input title="text" name="role" style="display: none" value="roleNurse"/>
                    <button type="submit" id="bt-Nurse" class="btn btn-primary">Đăng Nhập</button>
                </form>
            </div>
        </div>
    </div>


    <div class = "col-md-3 col-xs-12 mt-2 mb-2" style="align-items: center">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662035930/Web_QLPM/Avatar/girl_rr8mkf.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <h4 class="card-title">Khách Hàng</h4>
            <div class="card-body">
                <form method="post" action="${action}" class="d-flex">
                    <input title="text" name="role" style="display: none" value="roleCustomer"/>
                    <button type="submit" id="bt-Customer" class="btn btn-primary">Đăng Nhập</button>
                </form>
            </div>
        </div>
    </div>
</div>
