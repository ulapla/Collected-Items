<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>
<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Szczegóły elementu</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <table width="100%" class="table table-striped table-bordered table-hover table-responsive">
        <tr>
            <th>Nazwa/wartość</th>
            <th>Rodzaj</th>
            <th>Opis</th>
            <th>Ilość</th>
        <tr>
            <td>${item.name}</td>
            <td>${item.category.name}</td>
            <td>${item.description}</td>
            <td>${item.quantity}</td>
            <td> <a class="confirm" href="/api/item/delete/${item.id}">Usuń element</a></td>
        </tr>
    </table>
    <div class="col-xl-12">
        <p>
        <c:choose>
            <c:when test="${item.fileName != null}">
                <form style="display: inline" action="/api/file/get/${item.fileName}">
                    <input type="submit" value="Nota aplikacyjna"/>
                </form>
            </c:when>
            <c:otherwise>
                <form style="display: inline" action="/api/file/add/${item.id}">
                    <input  type="submit" value="Dodaj notę aplikacyjną"/>
                </form>
            </c:otherwise>
        </c:choose>
        <form style="display: inline" action="/api/item/edit/${item.id}">
            <input  type="submit" value="Edytuj"/>
        </form>

        <form style="display: inline" action="/api/item/${item.id}/add/location">
            <input  type="submit" value="Dodaj lokalizację"/>
        </form>
        </p>
    </div>

    <div class="row">
        <div class="col-xl-12">
            <div class="card">
        <h3>Lokalizacje</h3>
                <!-- /.card-header -->
                <div class="card-body">
                    <table width="100%" class="table table-striped table-bordered table-hover table-responsive"
                           id="dataTables-example">
                        <tr>
                            <th>Miejsce</th>
                            <th>Pozycja</th>
                            <th>Ilość</th>
                            <th>Zużyto</th>
                        </tr>
                        <c:forEach items="${itemLocations}" var="itemLocation">
                            <tr>
                                <td>${itemLocation.location.place}</td>
                                <td>${itemLocation.location.position}</td>
                                <td>${itemLocation.quantity}</td>
                                <td>
                                    <form action="/api/item/quick/sub" method="post" >
                                        <input type="number" name="usedQuantity"/>
                                        <input type="hidden" name="itemLocationId" value="${itemLocation.id}">
                                        <input type="submit" value="Zatwierdź"/>
                                    </form>
                                </td>

<%--                                <td><a href="/api/item/location/edit/${itemLocation.id}">Zmień ilość</a></td>--%>
                                <td><a class="confirm" href="/api/item/location/delete/${itemLocation.id}">Usuń</a></td>
                            </tr>
                        </c:forEach>
                    </table>



                    <jsp:include page="../footer.jsp"/>
