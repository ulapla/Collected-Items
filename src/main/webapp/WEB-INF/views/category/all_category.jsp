<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>
<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Wszystkie kategorie</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">
<table width="100%" class="table table-striped table-bordered table-hover"
       id="dataTables-example">
    <tr>
        <th>Nazwa</th>
    </tr>
    <c:forEach items="${categories}" var="category">
    <tr>
        <td>${category.name}</td>
        <td><a href="/api/category/edit/${category.id}">Edytuj</a> </td>
        <td><a class="confirm" href="/api/category/delete/${category.id}">Usuń</a> </td>
    </tr>
    </c:forEach>
</table>
<jsp:include page="../footer.jsp"/>