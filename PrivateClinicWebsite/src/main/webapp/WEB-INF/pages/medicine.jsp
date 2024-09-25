<%-- 
    Document   : medicine
    Created on : Jun 24, 2024, 9:40:31 AM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="text-primary text-center mt-1">
    <h1>DANH SÁCH THUỐC</h1>
</div>
<div class="mt-3">
    <a class="btn btn-info" href="<c:url value="/addMedicine"/>">Thêm</a> 
</div>

<form action="http://localhost:8080/PrivateClinicWebsite/findMedicine" method="get" class="mt-3">
    <label for="kw">Nhập từ khóa</label>
    <input type="text" id="kw" name="kw" />
    <button type="submit" class="btn btn-info">Tìm kiếm</button>  
</form>

<div class="container mt-3">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>STT</th>
                <th hidden>Id</th>
                <th>Tên thuốc</th>
                <th>Mô tả</th>
                <th>Đơn vị</th>
                <th>Giá cả</th>
                <th>Lượng thuốc trong kho</th>
                <th>Danh mục</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${medicines}" var="m">
                <tr>
                    <td>
                        <c:set var="i" value="${i + 1}"></c:set>
                        <c:out value="${i}"></c:out>
                        </td>
                        <td hidden>${m.id}</td>
                    <td>${m.name}</td>
                    <td>${m.description}</td>
                    <td>${m.unit}</td>
                    <td>${String.format("%.2f", m.price)} VNĐ</td>
                    <td>${m.quantity}</td>
                    <td>${m.categoryId.name}</td>
                    <td>
                        <c:url value="/deleteMedicine/${m.id}" var="url"/>
                        <a class="btn btn-info" href="<c:url value="/updateMedicine/${m.id}"/>">Cập nhật</a>
                        <button onclick="deleteDoctor('${url}', ${d.id})" class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>    
</div>

<script src="<c:url value="/js/script.js"/>"></script>