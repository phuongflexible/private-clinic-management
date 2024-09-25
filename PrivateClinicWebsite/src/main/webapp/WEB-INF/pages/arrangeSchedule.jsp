<%-- 
    Document   : newjsp
    Created on : Jun 26, 2024, 7:14:25 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2 class="mt-3">SẮP LỊCH TRỰC</h2>

<c:url value="/arrangeSchedule" var="action"/>
<form:form method="post" action="${action}" modelAttribute="schedule">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="workDate" placeholder="Ngày làm việc" path="workDate"/>
        <label for="workDate">Ngày làm việc</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="shift" placeholder="Ngày làm việc" path="shift"/>
        <label for="shift">Ca trực</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:label path="scheduleDoctorSet">Bác sĩ</form:label> <br> <br>
        <c:forEach var="d" items="${doctors}"> 
            <div>
                <form:checkbox path="scheduleDoctorSet" value="${d.id}" label="${d.name}"/>
            </div>     
        </c:forEach>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:label path="scheduleNurseSet">Y tá</form:label> <br> <br>
        <c:forEach var="n" items="${nurses}"> 
            <div>
                <form:checkbox path="scheduleNurseSet" value="${n.id}" label="${n.name}"/>
            </div>     
        </c:forEach>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="note" placeholder="Ngày làm việc" path="note"/>
        <label for="note">Ghi chú</label>
    </div>

    <div class="form-floating">
        <button class="btn btn-info mb-1" type="submit">Sắp</button>
    </div>
</form:form>
