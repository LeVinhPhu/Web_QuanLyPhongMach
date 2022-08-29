<%-- 
    Document   : employeesManager
    Created on : Aug 23, 2022, 5:14:47 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Quản lý nhân viên</h1>
<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/admins/adminIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>


<div class="row mt-2">

    <div class = "col-md-3 col-xs-12 border rounded">
        <h3 class="text-center">Thêm Nhân Viên</h3>
        <c:url value="/admins/employeesManager" var="action"></c:url>
        <form:form method="post" action="${action}" modelAttribute="employee">

            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="firstName" id="firstName" placeholder="firstName" />
                <label for="firstName">Họ và tên đệm:</label>
                <form:errors path="firstName" element="div" cssClass="invalid-feedback" />

                <form:errors path="firstName" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="lastName" id="lastName" placeholder="lastName" />
                <label for="firstName">Tên:</label>
                <form:errors path="lastName" element="div" cssClass="invalid-feedback" />

                <form:errors path="lastName" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:input type="date" class="form-control" path="dateOfBirth" id="dateOfBirth" value="0000-00-00"/>
                <label for="firstName">Ngày Sinh:</label>

                <form:errors path="dateOfBirth" element="div" cssClass="invalid-feedback" />

                <form:errors path="dateOfBirth" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>      

            <div class=" form-floating mb-3 mt-3">
                <form:select path="positionId" class="form-select" id="positionId" name="positionId">
                    <c:forEach items="${positions}" var="p">
                        <option value="${p.id}">${p.name}</option>
                    </c:forEach>
                </form:select>
                <label for="position" class="form-label">Chức vụ</label>
                <form:errors path="positionId" element="div" cssClass="invalid-feedback" />

                <form:errors path="positionId" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>

            <div class=" form-floating mb-3 mt-3">
                <form:select path="sex" class="form-select" id="sex" name="sex">
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                    <option value="Khác">Khác</option>

                </form:select>
                <label for="position" class="form-label">Giới Tính</label>
                <form:errors path="sex" element="div" cssClass="invalid-feedback" />

                <form:errors path="sex" cssStyle="font-size: 14px; color:red; margin-left:2px;"/>
            </div>


            <div class="form-floating">
                <br>
                <input type="submit" value="Them san pham" class="btn btn-danger" />
            </div>
        </form:form>
    </div>


    <div class = "col-md-1 col-xs-12"></div>
    <div class = "col-md-8 col-xs-12">
        <h3 class="text-center">Danh Sách Nhân Viên</h3>
        <table class="table" style="margin-left: 10px">
            <thead>
                <tr>
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Ngày Sinh</th>
                    <th>Giới Tính</th>
                    <th>SĐT</th>
                    <th>Địa Chỉ</th>
                    <th></th>
                    <th><th>
                </tr>
            </thead>
            <tbody id="myEmployee">
                <tr>
                </tr>
            </tbody>
        </table>
    </div>

</div>


</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>        

<script src="<c:url value="/js/employee.js" />"></script>
<script>
    <c:url value="/api/employeesManager" var="u" />
    window.onload = function () {
        getEmployees("${u}")
    }
</script>

