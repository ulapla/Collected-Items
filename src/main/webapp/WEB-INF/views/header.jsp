<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Collected items</title>

    <!-- Bootstrap Core CSS -->

    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- MetisMenu CSS -->
<%--    <link href="<c:url value="/resources/vendor/metisMenu/metisMenu.min.css"/>" rel="stylesheet">--%>

    <!-- DataTables CSS -->
<%--    <link href="<c:url value="/resources/vendor/datatables/css/dataTables.bootstrap4.css"/>" rel="stylesheet">--%>

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/dist/css/sb-admin-2.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <header class="align-items-start app-header flex-column flex-md-row navbar navbar-expand-md navbar-light">
        <div class="align-items-baseline d-flex flex-row navbar-brand p-lg-3 pl-3 pr-3 pt-3">
            <%--            <a class="" href="#">SB Admin v2.0</a>--%>
            <%--            <button class="collapsed ml-auto navbar-toggler" type="button" data-toggle="collapse"--%>
            <%--                    data-target="#side-menu-wrapper" aria-controls="side-menu" aria-expanded="false"--%>
            <%--                    aria-label="Toggle navigation" style="--%>
            <%--">--%>
            <%--                <span class="navbar-toggler-icon"></span>--%>
            <%--            </button>--%>
        </div>
        <ul class="nav navbar-nav ml-md-auto flex-row navbar-top-links">
                        <li class="nav-item dropdown">
                            <a style="background-color: rgb(240, 240, 240)" class="nav-link dropdown-toggle nav-link" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-user fa-fw"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-user">
                                <a class="dropdown-item" href="/login"><i class="fa fa-user fa-fw"></i>Zaloguj</a>
                                <a class="dropdown-item" href="/logout"><i class="fa fa-plus-circle fa-fw"></i>Nowy użytkownik</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/create/user"><i class="fa fa-sign-out fa-fw"></i>Wyloguj</a>
                            </div>
                        </li>
        </ul>
    </header>
    <div class="d-md-flex">
        <div class="sidebar" role="navigation">
            <div class="sidebar-nav collapse navbar-collapse show" id="side-menu-wrapper">
                <ul class="nav navbar-nav navbar-collapse flex-column side-nav list-group" id="side-menu">
                    <%--                    <li class="sidebar-search">--%>
                    <%--                        <div class="input-group custom-search-form">--%>
                    <%--                            <input type="text" class="form-control" placeholder="Search...">--%>
                    <%--                            <span class="input-group-btn">--%>
                    <%--                                <button class="btn btn-white" type="button">--%>
                    <%--                                    <i class="fa fa-search"></i>--%>
                    <%--                                </button>--%>
                    <%--                            </span>--%>
                    <%--                        </div>--%>
                    <%--                        <!-- /input-group -->--%>
                    <%--                    </li>--%>
                    <li class="list-group-item">
                        <a href="/home">Strona główna</a>
                    </li>
                    <li class="list-group-item">
                        <a href="/api/item/all">Wszystkie elementy</a>
                    </li>
                    <li class="list-group-item">
                        <a href="/api/item/add">Dodaj nowy element</a>
                    </li>
                    <li class="list-group-item">
                        <a href="/api/location/all">Wszystkie lokalizacje</a>
                    </li>
                    <li class="list-group-item">
                        <a href="/api/location/add">Dodaj nową lokalizację</a>
                    </li>
                    <li class="list-group-item">
                        <a href="/api/category/all">Wszystkie kategorie</a>
                    </li>
                    <li class="list-group-item">
                        <a href="/api/category/add">Dodaj nową kategorię</a>
                    </li>

                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>

