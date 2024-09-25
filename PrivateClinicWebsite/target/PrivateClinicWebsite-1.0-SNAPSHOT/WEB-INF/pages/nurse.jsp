<%-- 
    Document   : nurse
    Created on : Jun 21, 2024, 9:48:26 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="text-primary text-center mt-1">
    <h1>DANH SÁCH Y TÁ</h1>
</div>
<div class="mt-3">
    <a class="btn btn-info" href="<c:url value="/addNurse"/>">Thêm</a>
</div>
<form action="http://localhost:8080/PrivateClinicWebsite/findNurse" method="get">
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
                <th>Họ tên</th>
                <th>Giới tính</th>
                <th>Ngày sinh</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Ảnh</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${nurses}" var="n">
                <tr>
                    <td>
                        <c:set var="i" value="${i + 1}"></c:set>
                        <c:out value="${i}"></c:out>
                        </td>
                        <td hidden>${n.id}</td>
                    <td>${n.name}</td>
                    <td>${n.gender}</td>
                    <td>${n.birthday}</td>
                    <td>${n.phoneNumber}</td>
                    <td>${n.email}</td>
                    <td><img class="card-img-top" src="${n.avatar}" alt="${n.name}" style="width:200px;"></td>
                    <td>
                        <c:url value="/deleteNurse/${n.id}" var="url"/>
                        <a class="btn btn-info" href="<c:url value="/updateNurse/${n.id}"/>">Cập nhật</a>
                        <button onclick="deleteDoctor('${url}', ${d.id})" class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>    
</div>

<script src="<c:url value="/js/script.js"/>"></script>
