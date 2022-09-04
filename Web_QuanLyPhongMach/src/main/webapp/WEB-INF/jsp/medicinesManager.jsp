<%-- 
    Document   : medicinesManager
    Created on : Aug 21, 2022, 10:35:40 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!-- THÊM THUỐC -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- HEADER & NÚT TẮT -->
            <div class="modal-header" style="text-align:center">
                <h4 class="modal-title" >Thêm thuốc</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- BODY -->
            <div class="modal-body">
                <div>
                    <c:url value="/admins/medicinesManager" var="action" />
                    <form:form id="myForm" method="post" action="${action}" modelAttribute="medicine" enctype="multipart/form-data">

                        <div class="form-floating input-row">
                            <form:input type="text" path="name" class="form-control" id="name" placeholder="Nhap ten" name="name" />
                            <label for="name">Tên thuốc</label>
                            <%--<form:errors path="name" element="div" cssClass="alert alert-danger" />--%>
                            <small></small>
                        </div>

                        <div class="form-floating input-row">
                            <form:select path="unitId" class="form-select" id="unitId" name="unitId">
                                <c:forEach items="${units}" var="u">
                                    <option value="${u.id}">${u.name}</option>
                                </c:forEach>
                            </form:select>
                            <label for="unitId" class="form-label">Đơn vị</label>
                        </div>

                        <div class="form-floating input-row">
                            <form:input type="number" path="unitPrice" class="form-control" id="unitPrice" placeholder="Nhap gia" name="unitPrice" />
                            <label for="unitPrice">Đơn giá</label>
                            <%--<form:errors path="unitPrice" element="div" cssClass="alert alert-danger" />--%>
                            <small></small>
                        </div>

                        <div class="form-floating input-row">
                            <form:input type="number" path="quantity" class="form-control" id="quantity" placeholder="Nhap so luong" name="quantity" />
                            <label for="quantity">Số lượng</label>
                            <small></small>
                        </div>

                        <div class="form-floating input-row">
                            <form:select path="supplierId" class="form-select" id="supplierId" name="supplierId">
                                <option disabled="disabled" selected="selected" value=""}>Chọn nhà cung cấp</option>
                                <c:forEach items="${suppliers}" var="s">
                                    <option value="${s.id}">${s.companyName}</option>
                                </c:forEach>
                            </form:select>
                            <label for="supplierId" class="form-label">Nhà cung cấp</label>
                        </div>

                        <div class="input-row">
                            <label style="margin-left: 4.5%;" class="ml-2"for="file">Chọn ảnh</label>
                            <form:input type="file" path="file" name="file" id="file" class="form-control" />
                        </div>

                        <div class="form-floating input-row">
                            <form:input type="text" path="note" class="form-control" id="note" placeholder="Ghi chu" name="note" />
                            <label for="note">Ghi chú</label>
                        </div>

                        <div class="form-floating mt-2" style="text-align: right">
                            <input type="submit" id="btnAdd" value="Thêm thuốc" class="btn mb-3 mt-3" style="background-color: #d1e7dd" />
                        </div>

                    </form:form>    
                </div>
            </div>

        </div>
    </div>
</div>   

<div class="row mt-4 mb-4">
    <div class="col-md-10 col-12">
        <div style="text-align: center;" ><h3>QUẢN LÝ THUỐC</h3></div></div>
    <div class="col-md-2 col-12">
        <c:url value="/admins/medicinesManager" var="action" />
        <form action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên thuốc...">
            <button type="submit" class="btn"><i class="fas fa-search"></i></button>
        </form>
    </div>
</div>




<!--DANH SÁCH THUỐC-->
<div class="row mt-3 mb-3">

    <div class="col-md-1 col-12"></div>

    <div class="col-md-8 col-12 shadow" style="overflow: auto; height: 500px; border-radius: 10px">
        <div data-bs-toggle="modal" data-bs-target="#myModal" style="margin: 8px; width: 20%"><i class="fas fa-plus"></i>  Thêm thuốc</div>

        <table class="table table-hover ">
            <tr>
                <th>
                    <i onclick="load()" class="fas fa-redo-alt"></i>
                </th>
                <th>Tên thuốc</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Đơn vị</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <tbody id="myMedicine">
            </tbody>
        </table>
    </div>

    <div class="col-md-1 col-12"></div>

    <div class="col-md-2 col-12">
        <div class="list-group">
            <a class="list-group-item list-group-item-action active">
                Tiện ích
            </a>
            <a href="/Web_QuanLyPhongMach/admins/adminIndex" class="list-group-item list-group-item-action">Trang Chủ</a>
            <a href="/Web_QuanLyPhongMach/admins/adminsManager" class="list-group-item list-group-item-action">Quản lý Admin</a>
            <a href="/Web_QuanLyPhongMach/admins/employeesManager" class="list-group-item list-group-item-action">Quản lý Nhân viên</a>
            <a href="/Web_QuanLyPhongMach/admins/medicinesManager" class="list-group-item list-group-item-action">Quản lý Thuốc</a>
            <a href="/Web_QuanLyPhongMach/admins/customersManager" class="list-group-item list-group-item-action">Quản lý Khách Hàng</a>
            <a href="/Web_QuanLyPhongMach/admins/reportsManager" class="list-group-item list-group-item-action">Quản lý Thống kê</a>
            <a href="/Web_QuanLyPhongMach/admins/onCallManager" class="list-group-item list-group-item-action">Quản lý Lịch trực</a>
        </div>
    </div>
</div>


<!--CHI TIẾT THUỐC-->
<!-- The Modal Detail -->
<div class="modal" id="detailModal">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen-sm-down">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h5 class="modal-title">Chi tiết thuốc</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="detailMedicines">

            </div>
            <!-- Modal footer -->
        </div>
    </div>
</div>





<!--sử dụng api lấy danh sách thuốc-->
<script src="<c:url value="/js/medicine.js" />"></script>
<script>
    <c:url value="/api/medicines" var="m" />
                        window.onload = function () {
                            getMedicines('${m}');
                        };
</script>


<script>
    function load() {
    <c:url value="/api/medicines" var="m" />
        getMedicines('${m}');
    }
</script>