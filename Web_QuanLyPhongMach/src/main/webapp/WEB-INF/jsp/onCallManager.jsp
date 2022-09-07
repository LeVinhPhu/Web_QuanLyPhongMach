<%-- 
    Document   : onCallManager
    Created on : Aug 21, 2022, 10:58:34 AM
    Author     : vinhp
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--        c:url value="" var="action" />-->
<!--        <form action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên thuốc...">
            <button type="submit" class="btn"><i class="fas fa-search"></i></button>
        </form>-->
<!--<div data-bs-toggle="modal" data-bs-target="#myModal" style="margin: 8px; width: 20%"><i class="fas fa-plus"></i>  Thêm thuốc</div>-->

<div class="row mt-4 mb-4">
    <div class="col-md-12 col-12">
        <div style="text-align: center;" ><h3>QUẢN LÝ LỊCH TRỰC</h3></div>
    </div>
</div>

<div class="row mt-4 mb-5">
    <div class="col-md-5 col-12 shadow">
        <div style="text-align: center;" ><h4>DANH SÁCH NHÂN VIÊN</h4></div>
        <div class="col-md-12 col-12 mt-2" style="overflow: auto; height: 500px; border-radius: 10px">
            <table class="table table-hover ">
                <tr class="table-primary">
                    <th>
                        <i onclick="load()" class="fas fa-redo-alt"></i>
                    </th>
                    <th>Họ và tên</th>
                    <th>Chức vụ</th>
                    <th>Chuyên khoa</th>
                    <th></th>
                </tr>
                <tbody id="myEmployeeOnCall">
                </tbody>
            </table>
        </div>
    </div>

    <div class="col-md-7 col-12 shadow">
        <div style="text-align: center;" ><h4>LỊCH PHÂN CÔNG</h4></div>
        <div class="col-md-12 col-12 mt-2" style="overflow: auto; height: 500px; border-radius: 10px">   
            <table class="table table-hover">
                <tr class="table-success">
                    <th>
                        <i onclick="load()" class="fas fa-redo-alt"></i>
                    </th>
                    <th>Tên nhân viên</th>
                    <th>Tên Admin</th>
                    <th>Ngày</th>
                    <th>Phòng Trực</th>
                    <th></th>
                </tr>
                <tbody id="myOnCall">
                </tbody>
            </table>
        </div>
    </div>
</div>


<!-- The Modal -->
<div class="modal" id="addOncall">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen-sm-down">
        <div class="modal-content">

            <h6></h6>
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Thêm Lịch Trực</h4>

                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="addOncall">
                <div class = "col-md-12 col-xs-12">
                    <c:url value="/admins/onCallManager" var="action"></c:url>
                    <form:form id="myForm" method="post" action="${action}" modelAttribute="onCall" enctype="multipart/form-data">
                        <div class="input-row form-floating">
                            <form:input type="date" class="form-control" path="date" id="date"/>
                            <label for="date">Ngày Trực:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>      

                        <div class="input-row form-floating">
                            <form:select path="departmentId" class="form-select" id="departmentId" name="departmentId">
                                <c:forEach items="${department}" var="p">
                                    <option value="${p.id}">${p.name}</option>
                                </c:forEach>
                            </form:select>
                            <label for="departmentId" class="form-label">Phòng ban</label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>

                        <div class="input-row form-floating">
                            <form:input type="hidden" class="form-control" path="adminId" id="adminId"/>
                            <label for="adminId"></label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>

                        <div class="input-row form-floating">
                            <form:input type="hidden" class="form-control" path="employeeId" id="employeeId"/>
                            <label for="employeeId"></label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>

                        <div class="form-floating mb-2" style="text-align: right;">
                            <input type="submit" value="Xác nhận" class="btn btn-danger" id="bt-submit"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>        


<script src="<c:url value="/js/oncall.js"/>" ></script>

<script>document.getElementById('adminId').value = "${currentUser.id}";</script>

<script>
    <c:url value="/api/employeesOncall" var="u" />
    <c:url value="/api/onCallManager" var="ocl" />
    window.onload = function () {
        getEmployeeOncal("${u}"),
                getOnCall("${ocl}");
    }
</script>

<script>
    $(function () {
        $('#addOncall').modal('show');
        $('#date').datepicker({minDate: 0, dateFormat: 'mm-dd-yyyy'});
    });
</script>
