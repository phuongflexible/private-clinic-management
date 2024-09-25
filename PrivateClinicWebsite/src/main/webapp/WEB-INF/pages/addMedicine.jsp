<%-- 
    Document   : addMedicine
    Created on : Jun 24, 2024, 11:22:58 AM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2 class="mt-3">
    <c:choose>
        <c:when test="${medicine.id > 0}">Cập nhật thông tin thuốc</c:when>
        <c:otherwise>Thêm thông tin thuốc</c:otherwise>
    </c:choose>
</h2>

<c:url value="/addMedicine" var="action"/>
<form:form method="post" action="${action}" modelAttribute="medicine" enctype="multipart/form-data"> 
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="name" placeholder="Tên thuốc" path="name"/> <%--gia tri cua path phai trung voi ten truong o file Bacsi.java--%>
        <label for="name">Tên thuốc</label> 
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control mt-3" id="description" placeholder="Mô tả" path="description"/> 
        <label for="description">Mô tả</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control mt-3" id="unit" placeholder="Đơn vị" path="unit"/> 
        <label for="unit">Đơn vị</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control mt-3" id="price" placeholder="Giá tiền" path="price"/>  
        <label for="price">Giá tiền</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control mt-3" id="quantity" placeholder="Số lượng trong kho" path="quantity"/> 
        <label for="quantity">Số lượng trong kho</label>    
    </div>
            
    <div class="form-floating mb-3 mt-3">
        <form:select path="categoryId.id" class="form-select" id="categoryId">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>    
        </form:select>
        <label for="categoryId" class="form-lable">Danh mục</label>
    </div>
        
    <div class="form-floating">
        <button class="btn btn-info mb-1" type="submit">
            <c:choose>
                <c:when test="${medicine.id > 0}">Cập nhật thông tin</c:when>
                <c:otherwise>Thêm thông tin</c:otherwise>
            </c:choose>   
        </button>
        <form:hidden path="id"/>
    </div>
</form:form>
