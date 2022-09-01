<%-- 
    Document   : medicinesManager
    Created on : Aug 21, 2022, 10:35:40 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/admins/adminIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>

<div class="row">
    <div class="col-md-3 col-xs-12">
        <h3>Thêm Thuốc</h3>
        <c:url value="/admins/medicinesManager" var="action" />
        <%--<c:if>

        </c:if>--%>
        <form:form method="post" action="${action}" modelAttribute="medicine" enctype="multipart/form-data">
            <form:errors path="*" element="div" cssClass="alert alert-danger" />
            <div class="form-floating mb-2 mt-3">
                <form:input type="text" path="name" class="form-control" id="name" placeholder="Nhap ten" name="name" />
                <label for="name">Tên thuốc</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:select path="unitId" class="form-select" id="unit" name="unit">
                    <c:forEach items="${units}" var="u">
                        <option value="${u.id}">${u.name}</option>
                    </c:forEach>
                </form:select>
                <label for="unit" class="form-label">Đơn vị</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:input type="number" path="unitPrice" class="form-control" id="unitPrice" placeholder="Nhap gia" name="name" />
                <label for="name">Đơn giá</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:input type="number" path="quantity" class="form-control" id="unitPrice" placeholder="Nhap so luong" name="name" />
                <label for="name">Số lượng</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:select path="supplierId" class="form-select" id="sup" name="sup">
                    <option disabled="disabled" selected="selected" value=""}>Chọn nhà cung cấp</option>
                    <c:forEach items="${suppliers}" var="s">
                        <option value="${s.id}">${s.companyName}</option>
                    </c:forEach>
                </form:select>
                <label for="sup" class="form-label">Nhà cung cấp</label>
            </div>

            <div class="mb-2 mt-3">
                <label style="margin-left: 4.5%;" class="ml-2"for="file">Chọn ảnh</label>
                <form:input type="file" path="file" id="file" class="form-control" />
            </div>
            <div class="form-floating mb-2 mt-3">
                <form:input type="text" path="note" class="form-control" id="name" placeholder="Ghi chu" name="note" />
                <label for="note">Ghi chú</label>
            </div>
            <input type="submit" value="Thêm thuốc" class="btn mb-3 mt-3" style="background-color: #d1e7dd" />
        </form:form>    
    </div>

    <!--    <div class="col-md-1 col-xs-12"></div>-->


    <div class="col-md-9 col-xs-12">
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
<script src="<c:url value="/js/medicine_1.js" />"></script>
<script>
    <c:url value="/api/medicines" var="m" />
    window.onload = function () {
        getMedicines('${m}');
    };

</script>