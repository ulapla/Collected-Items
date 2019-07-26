<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style type="text/css">

    li
    {
        display:inline;
    }
</style>
<jsp:include page="../header.jsp"/>

        <div id="page-wrapper" class="p-4">
            <div class="row">
                <div class="col-xl-12">
                    <h1 class="page-header">Wszystkie elementy</h1>

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
                                <thead>
                                    <tr>
                                        <th>Nazwa/wartość</th>
                                        <th>Rodzaj</th>
                                        <th>Opis</th>
                                        <th>Ilość</th>
                                        <th>Lokalizacja</th>
                                    </tr>

                                    <tr>
                                        <form action="/api/item/search/" method="post">
                                           <td> <input type="text" name="name"/></td>
                                            <td> <select name="categoryId">
                                                <option></option>
                                                <c:forEach items="${categories}" var="category">
                                                    <option value="${category.id}">${category.name}</option>
                                                </c:forEach>
                                            </select>

                                            <td> <input type="text" name="description"/></td>
                                            <td></td>
                                            <td></td>
                                            <td><button type="submit">Szukaj</button> </td>

                                        </form>

                                    </tr>
                                </thead>
                                <c:forEach items="${page.content}" var="item">
                                     <tr>
                                         <td><a href="/api/item/show/${item.id}">${item.name}</a></td>
                                        <td>${item.category.name}</td>
                                        <td>${item.description}</td>
                                        <td>${item.quantity}</td>
                                        <td><c:forEach items="${item.itemLocations}" var="location">
                                            ${location.location.name}<br>
                                        </c:forEach>
                                        </td>

                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                        <util:pagination thispage="${page}"></util:pagination>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-xl-12 -->
            </div>
            <!-- /.row -->

            <!-- /.row -->
        </div>
<jsp:include page="../footer.jsp"/>