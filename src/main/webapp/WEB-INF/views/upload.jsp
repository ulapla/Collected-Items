<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<html xmlns:th="https://www.thymeleaf.org">--%>
<html>
    <body>

        <div >
            <c:if test="${message}">
                <h2>${message}</h2>
            </c:if>
        </div>

        <div>
            <form method="POST" enctype="multipart/form-data" action="/">
                <table>
                    <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
                    <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
                </table>
            </form>
        </div>

        <div>
            <ul>
            <c:forEach items="${files}" var="file">
                <li><a href="${file}"></a>${file} </li>
            </c:forEach>
        <%--        <li th:each="file : ${files}">--%>
        <%--            <a th:href="${file}" th:text="${file}" />--%>
        <%--        </li>--%>
            </ul>
        </div>

    </body>
</html>