<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>
<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Lokalizacje elementu</h1>
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
        <th>Miejsce</th>
        <th>Pozycja</th>
        <th>Ilość</th>
    </tr>
    <c:forEach items="${itemLocations}" var="itemLocation">
    <tr>
        <td>${itemLocation.location.place}</td>
        <td>${itemLocation.location.position}</td>
        <td>${itemLocation.quantity}</td>

        <td><a href="/api/item/location/edit/${itemLocation.id}">Zmień ilość</a> </td>
        <td><a href="/api/item/location/delete/${itemLocation.id}">Usuń</a> </td>
    </tr>
    </c:forEach>
</table>
<jsp:include page="../footer.jsp"/>
