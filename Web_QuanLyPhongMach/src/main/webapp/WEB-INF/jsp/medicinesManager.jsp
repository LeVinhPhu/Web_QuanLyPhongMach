<%-- 
    Document   : medicinesManager
    Created on : Aug 21, 2022, 10:35:40 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--NÚT THÊM-->
<div class="container mt-3">
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
        Thêm thuốc
    </button>
</div>


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


<!--DANH SÁCH THUỐC-->
<div class="row">
    <div>
        <table class="table table-hover ">
            <tr class="table-success">
                <th></th>
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
</div>


<!--sử dụng api lấy danh sách thuốc-->
<script src="<c:url value="/js/medicine.js" />"></script>
<script>
    <c:url value="/api/medicines" var="m" />
    window.onload = function () {
        getMedicines('${m}');
    };

</script>