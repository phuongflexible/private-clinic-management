<%-- 
    Document   : header
    Created on : Jun 2, 2024, 4:58:32 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">Quản lý phòng mạch tư</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/doctor"/>">Quản lý bác sĩ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/nurse"/>">Quản lý y tá</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/medicine"/>">Quản lý thuốc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/arrangeSchedule"/>">Sắp lịch trực</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/stats"/>">Thống kê báo cáo</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
