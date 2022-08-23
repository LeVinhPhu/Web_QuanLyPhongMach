<%-- 
    Document   : reports
    Created on : Aug 21, 2022, 10:41:49 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-2 col-12 mb-2 btn btn-success">
    <a 
        href="<c:url value="/admins/adminIndex"/>" 
        style="text-decoration: none; color: white">Quay lại</a>
</div>

<div class="setMargin">       
    <div id="titles" class="mb-4 mt-2 pt-2 pb-2">
        <h4 class="text-center">Tổng doanh thu</h4>
    </div>

    <div class="myBorder row">  
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



<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/statistic.js" />"></script>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];
        
    <c:forEach items="${revenueStats}" var="c">
        data.push(${c[1]});
        labels.push('${c[0]}');
    </c:forEach>
      
        revenueStats(labels, data);
    }
</script>


