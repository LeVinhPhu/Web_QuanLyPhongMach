<%-- 
    Document   : reports
    Created on : Aug 21, 2022, 10:41:49 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!--tổng doanh thu-->
<p id="rightContent0"></p>
<div class="bg-light">
    <div class="pt-2 pb-1">
        <h4 class="text-center">QUẢN LÝ THỐNG KÊ</h4>
    </div>
</div>

<div class="row mb-2 mt-2">
    <div class="col-md-2">
        <div class="list-group mt-2" style="position: fixed">

            <a class="list-group-item list-group-item-action active">
                Các loại Thống kê
            </a>
            <a href="#rightContent1" class="list-group-item list-group-item-action">Theo Năm</a>
            <a href="#rightContent2" class="list-group-item list-group-item-action">Theo Quý</a>
            <a href="#rightContent3" class="list-group-item list-group-item-action">Theo Tháng</a>
        </div>
    </div>
    <div class="col-md-8 col-12">
        <!--bên phải-->
        <div class="">
            <p id="rightContent0"></p>
            <div class="">
                <div>
                    <h5>TỔNG DOANH THU</h5>
                </div>
            </div>
            <!--doanh thu theo năm-->
            <p id="rightContent1"> </p>
            <div class="mt-2">
                <div class="pt-2 pb-1">
                    <h5 class="text-center">DOANH THU THEO NĂM</h5>
                </div>

                <div class="row mt-2">  
                    <div class="col-md-4 col-xs-12" style="background-color: lightcyan">
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
                    <div class="col-md-8 col-xs-12">
                        <canvas id="myChart"></canvas>
                    </div>
                </div>
            </div>

            <!--doanh thu theo quý-->
            <p id="rightContent2"></p>
            <div class="mt-2">
                <div class="pt-2 pb-1">
                    <h5 class="text-center">DOANH THU THEO QUÝ</h5>
                </div>
                <div class="row mt-2">

                    <div class="col-md-6 col-xs-12" style="background-color: #fcecfd">
                        <table class="table">
                            <tr>
                                <th>Quý</th>
                                <th>Doanh thu</th>
                            </tr>

                            <c:forEach items="${revenueStatsByQuarter}" var="r">
                                <tr>
                                    <td>${r[0]}</td>
                                    <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="col-md-6 col-xs-12">
                        <c:url value="/admins/reportsManager" var="action" />
                        <form action="${action}">
                            <div class="mb-2 mt-2">
                                <input type="number" class="form-control" placeholder="Nhập năm" name="year">
                            </div>
                            <button type="submit" class="btn btn-primary" style="margin-bottom: 5px" >Thống kê</button>
                        </form>

                        <canvas id="myChart2"></canvas>
                    </div>
                </div>
            </div>

            <!--doanh thu theo tháng-->
            <p id="rightContent3"></p>
            <div class="mt-2">
                <div class="pt-2 pb-1">
                    <h5 class="text-center">DOANH THU THEO THÁNG</h5>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6 col-xs-12" style="background-color: cornsilk">
                        <table class="table">
                            <tr>
                                <th>Tháng</th>
                                <th>Doanh thu</th>
                            </tr>

                            <c:if test="${not empty revenueStatsByMonth[0][2]}">
                                <p class="h6" style="margin-top: 10px; font-weight: bold; text-align:center">
                                    <c:out value="NĂM ${revenueStatsByMonth[0][2]}" />
                                </p>
                                <c:forEach items="${revenueStatsByMonth}" var="r">
                                    <tr>
                                        <td>${r[0]}</td>
                                        <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${revenueStatsByMonth[0][2] == null}">
                                <td></td>
                                <td>Chưa có doanh thu</td>
                            </c:if>

                        </table>
                    </div>

                    <div class="col-md-6 col-xs-12">
                        <c:url value="/admins/reportsManager" var="action" />

                        <form action="${action}" method="POST">
                            <div class="mb-2 mt-2">
                                <input type="number" id="number" class="form-control" placeholder="Nhập năm" name="year2">
                            </div>
                            <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>

                        </form>
                        <canvas id="myChart3"></canvas>
                    </div>
                </div>
            </div>               

        </div>    



    </div>

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


