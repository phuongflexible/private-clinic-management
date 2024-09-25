<%-- 
    Document   : index
    Created on : Jun 2, 2024, 3:51:37 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${message}</h1>
<ul>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name == null}">
            <li>
                <a href="<c:url value="/login" />">Đăng nhập</a>
            </li>
        </c:when>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            <li>
                <a href="#">${pageContext.request.userPrincipal.name}</a>
            </li>
            <li>
                <a href="<c:url value="/logout" />">Đăng xuất</a>
            </li>
        </c:when>
    </c:choose>
</ul>
