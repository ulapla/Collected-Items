<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<html xmlns:th="https://www.thymeleaf.org">--%>
<jsp:include page="header.jsp"/>
        <div >
            <c:if test="${message}">
                <h2>${message}</h2>
            </c:if>
        </div>

        <div>
            <form:form method="POST" enctype="multipart/form-data" action="/file/add" modelAttribute="item">
                <form:hidden path="id"/>

                <table>
                    <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
                    <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
                </table>
            </form:form>
        </div>


<jsp:include page="footer.jsp"/>