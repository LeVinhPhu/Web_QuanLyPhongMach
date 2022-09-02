
<%-- 
    Document   : reports2Manager
    Created on : Aug 31, 2022, 6:26:11 PM
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

            <!--Tổng bệnh nhân-->
            <p id="rightContent0"></p>

            <div>
                <div style="text-align: center">
                    <h5>TỔNG SỐ LƯỢNG BỆNH NHÂN: <c:out value="${patientStats[0]}"></c:out></h5>
                    </div>
                </div>
                <!--Số lượng bệnh nhân theo năm-->
                <p id="rightContent1" style="padding-bottom: 80px"> </p>
                <div class="mt-2">
                    <div class="pt-2 pb-1">
                        <h5 class="text-center">SỐ LƯỢNG BỆNH NHÂN THEO CÁC NĂM</h5>
                    </div>

                    <div class="row mt-2">  
                        <div class="col-md-5 col-xs-12">
                            <table class="table">
                                <tr>
                                    <th>Năm</th>
                                    <th>Số lượng bệnh nhân</th>
                                </tr>

                            <c:forEach items="${patientStatsByYear}" var="r">
                                <tr>
                                    <td>${r[0]}</td>
                                    <td>${r[1]}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="col-md-7 col-xs-12">
                        <canvas id="myChartPatientStatsByYear"></canvas>
                    </div>
                </div>
            </div>

            <!--Số lượng bệnh nhân theo quý-->
            <p id="rightContent2" style="padding-bottom: 80px"> </p>
            <div class="mt-2">
                <div class="pt-2 pb-1">
                    <h5 class="text-center">SỐ LƯỢNG BỆNH NHÂN THEO QUÝ (NĂM <c:out value="${year1}" />)</h5>
                </div>

                <div class="row mt-2">  
                    <div class="col-md-5 col-xs-12">
                        <table class="table">
                            <tr>
                                <th>Quý</th>
                                <th>Số lượng bệnh nhân</th>
                            </tr>
                            <c:if test="${not empty patientStatsByQuarter[0][0]}"> 
                                <c:forEach items="${patientStatsByQuarter}" var="p">
                                    <tr>
                                        <td>${p[0]}</td>
                                        <td>${p[1]}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${patientStatsByQuarter[0][0] == null}">
                                <td></td>
                                <td>Chưa có bệnh nhân</td>
                            </c:if>
                        </table>
                    </div>
                    <div class="col-md-7 col-xs-12">
                        <c:url value="/admins/reports2Manager" var="action" />
                        <form action="${action}" method="POST">
                            <div class="mb-2 mt-2">
                                <input type="number" id="number" class="form-control" placeholder="Nhập năm" name="year1">
                            </div>
                            <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>
                        </form>
                        <canvas id="myChartPatientStatsByQuarter"></canvas>
                    </div>
                </div>
            </div>

            <!--Số lượng bệnh nhân theo tháng-->
            <p id="rightContent3" style="padding-bottom: 80px"> </p>
            <div class="mt-2">
                <div class="pt-2 pb-1">
                    <h5 class="text-center">SỐ LƯỢNG BỆNH NHÂN THEO THÁNG (NĂM <c:out value="${year2}" />)</h5>
                </div>

                <div class="row mt-2">  
                    <div class="col-md-5 col-xs-12">
                        <table class="table">
                            <tr>
                                <th>Tháng</th>
                                <th>Số lượng bệnh nhân</th>
                            </tr>
                            <c:if test="${not empty patientStatsByMonth[0][0]}"> 
                                <c:forEach items="${patientStatsByMonth}" var="p">
                                    <tr>
                                        <td>${p[0]}</td>
                                        <td>${p[1]}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${patientStatsByMonth[0][0] == null}">
                                <td></td>
                                <td>Chưa có bệnh nhân</td>
                            </c:if>
                        </table>
                    </div>
                    <div class="col-md-7 col-xs-12">
                        <form action="${action}" method="POST">
                            <div class="mb-2 mt-2">
                                <input type="number" id="number" class="form-control" placeholder="Nhập năm" name="year2">
                            </div>
                            <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>
                        </form>
                        <canvas id="myChartPatientStatsByMonth"></canvas>
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


    <c:forEach items="${patientStatsByYear}" var="c">
        data.push(${c[1]});
        labels.push('${c[0]}');
    </c:forEach>
    <c:forEach items="${patientStatsByQuarter}" var="c">
        data2.push(${c[1]});
        labels2.push('${c[0]}');
    </c:forEach>
    <c:forEach items="${patientStatsByMonth}" var="c">
        data3.push(${c[1]});
        labels3.push('${c[0]}');
    </c:forEach>

        patientStatsByYear(labels, data);
        patientStatsByQuarter(labels2, data2);
        patientStatsByMonth(labels3, data3);
    }
</script>

