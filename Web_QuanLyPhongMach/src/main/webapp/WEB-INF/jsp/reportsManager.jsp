<%-- 
    Document   : reports
    Created on : Aug 21, 2022, 10:41:49 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row mb-2 mt-2">
    <div class="col-md-9 col-12">
        <div style="text-align: center"class="">
            <div class="bg-light">
                <div class="pt-2 pb-1">
                    <h4 class="text-center">QUẢN LÝ THỐNG KÊ - DOANH THU</h4>
                </div>
            </div>

            <!--Tổng doanh thu-->
            <div class="mt-3 mb-2 pt-2 pb-1">
                <button style="width: 25%;" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal0">TỔNG DOANH THU</button>
            </div>

            <!--Doanh thu theo năm-->
            <div class="mt-3 mb-2 pt-2 pb-1">
                <button style="width: 25%;" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">DOANH THU THEO NĂM</button>
            </div>

            <!--doanh thu theo quý-->
            <div class="mt-3 mb-2 pt-2 pb-1">
                <button style="width: 25%;" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal2">DOANH THU THEO QUÝ</button>
                <c:if test="${err1 != null}">
                    <div class="mt-2">
                        <span style="color: red">
                            ${err1}
                        </span>
                    </div>
                </c:if>
            </div>

            <!--doanh thu theo tháng-->
            <div class="pt-2 pb-1">
                <button style="width: 25%;" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal3">DOANH THU THEO THÁNG</button>
                <c:if test="${err2 != null}">
                    <div class="mt-2">
                        <span style="color: red">
                            ${err2}
                        </span>
                    </div>
                </c:if>
            </div>

            <!-- The Modal --> <!--TỔNG DOANH THU-->
            <div class="modal" id="myModal0">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">TỔNG DOANH THU</h4> 
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <fmt:formatNumber type="number" value="${total[0]}" maxFractionDigits="3" /> VNĐ
                        </div>
                    </div>
                </div>
            </div>

            <!-- The Modal --> <!--Doanh thu theo năm-->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">DOANH THU THEO NĂM</h4> 
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="row mt-2">  
                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Năm</th>
                                            <th>Doanh thu</th>
                                        </tr>

                                        <c:forEach items="${revenueStats}" var="r">
                                            <tr>
                                                <td>${r[0]}</td>
                                                <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                            </tr>
                                        </c:forEach>
                                        </td></tr>
                                    </table>
                                </div>
                                <div class="">
                                    <canvas id="myChart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- The Modal --> <!--doanh thu theo quý-->
            <div class="modal" id="myModal2">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">DOANH THU THEO QUÝ (NĂM <c:out value="${year}" />)</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="mt-2">

                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Quý</th>
                                            <th>Doanh thu</th>
                                        </tr>
                                        <c:if test="${not empty revenueStatsByQuarter[0][0]}"> 
                                            <c:forEach items="${revenueStatsByQuarter}" var="r">
                                                <tr>
                                                    <td>${r[0]}</td>
                                                    <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${revenueStatsByQuarter[0][0] == null}">
                                            <td></td>
                                            <td>Chưa có doanh thu</td>
                                        </c:if>
                                    </table>
                                </div>
                                <div class="" >
                                    <c:url value="/admins/reportsManager" var="action" />
                                    <form action="${action}">
                                        <div class="mb-2 mt-2">
                                            <input type="number" class="form-control" placeholder="Nhập năm" name="year">
                                        </div>
                                        <button type="submit" class="btn btn-primary" style="margin-bottom: 5px; margin-right: 0" >Thống kê</button>
                                    </form>
                                    <div style="width: 60%; margin-left: 20%"  >
                                        <canvas id="myChart2"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- The Modal --> <!--doanh thu theo tháng-->
            <div class="modal" id="myModal3">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">DOANH THU THEO THÁNG (NĂM <c:out value="${year2}" />)</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="mt-2">
                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Tháng</th>
                                            <th>Doanh thu</th>
                                        </tr>

                                        <c:if test="${not empty revenueStatsByMonth[0][0]}"> 
                                            <c:forEach items="${revenueStatsByMonth}" var="r">
                                                <tr>
                                                    <td>${r[0]}</td>
                                                    <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${revenueStatsByMonth[0][0] == null}">
                                            <td></td>
                                            <td>Chưa có doanh thu</td>
                                        </c:if>

                                    </table>
                                </div>

                                <div class="">
                                    <c:url value="/admins/reportsManager" var="action" />
                                    <form action="${action}" method="POST">
                                        <div class="mb-2 mt-2">
                                            <input type="number" id="year2" class="form-control" placeholder="Nhập năm" name="year2">
                                        </div>
                                        <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>

                                    </form>
                                    <canvas id="myChart3"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>                            
        </div>    
    </div>

    <div class="col-md-3 col-12">
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

        <div class="list-group mt-2">
            <a class="list-group-item list-group-item-action active">
                Thống Kê
            </a>
            <a href="/Web_QuanLyPhongMach/admins/reportsManager" class="list-group-item list-group-item-action">Thống kê Doanh thu</a>
            <a href="/Web_QuanLyPhongMach/admins/reports2Manager" class="list-group-item list-group-item-action">Thống kê Số lượng Bệnh nhân</a>
            <a href="/Web_QuanLyPhongMach/admins/reports3Manager" class="list-group-item list-group-item-action">Thống kê Tần suất sử dụng Thuốc</a>
        </div>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/statistic.js" />"></script>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];
        let data2 = [];
        let labels2 = [];
        let data3 = [];
        let labels3 = [];

    <c:forEach items="${revenueStats}" var="c">
        data.push(${c[1]});
        labels.push('${c[0]}');
    </c:forEach>

    <c:forEach items="${revenueStatsByQuarter}" var="r">
        data2.push(${r[1]});
        labels2.push('${r[0]}');
    </c:forEach>
    <c:forEach items="${revenueStatsByMonth}" var="r">
        data3.push(${r[1]});
        labels3.push('${r[0]}');
    </c:forEach>

        revenueStats(labels, data);
        revenueStatsByQuarter(labels2, data2);
        revenueStatsByMonth(labels3, data3);
    }
</script>


