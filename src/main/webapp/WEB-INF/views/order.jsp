<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.03.2015
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>


    <!-- Custom CSS -->
    <link href="../../resources/css/shop-homepage.css" rel="stylesheet">

    <link rel="stylesheet" href="../../resources/css/reset.css">
    <link rel="stylesheet" href="../../resources/css/shopstyle.css">

    <!-- jQuery -->
    <script src="../../resources/js/jquery.js"></script>

    <!--<script type="text/javascript" src="../../resources/js/store.js"></script>-->

    <!-- Bootstrap Core CSS -->
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">


    <!-- Bootstrap Core JavaScript -->
    <script src="../../resources/js/bootstrap.min.js"></script>

    <script src="../../resources/js/store.js"></script>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        div#bs-example-navbar-collapse-1 {
            min-height: 70px;
        }

        .navbar-nav > li > a {
            padding: 0 10px;
            line-height: 70px;
        }

        a.navbar-brand {
            padding: 0 10px;
            line-height: 70px;
        }

        .bs-example.bs-example-tabs {
            margin: 20px 0;
            border: 1px solid #ccc;
        }

        .list-group {
            width: 100%;
        }

        .cart {
            float: right;
            position: relative;
            line-height: 70px;
            padding-right: 30px;
            color: #fff;
            cursor: pointer;
        }

        .quantity {
            position: absolute;
            top: 22px;
            right: 0;
            background: #fff;
            display: block;
            color: #000;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            line-height: 1.5;
            text-align: center;
        }

        span.glyphicon.glyphicon-shopping-cart {
            font-size: 18px;
        }

        .login {
            float: right;
            margin: 18px;
        }

        .lead {
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
            background: none repeat scroll 0% 0% #FFF;
            display: inline-block;
            margin: 0;
            width: 65%
        }

        .sidebar {
            margin-top: 20px;
        }

        @media (max-width: 768px) {
            .cart {
                float: left;
            }
        }

        a.buy.btn.btn-primary {
            margin-bottom: 10px;
        }

        img {
            width: 800px;
            height: 300px;
        }
    </style>
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Andrew's shop</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>


            <a id="go" href="#" class="cart">
                <span class="glyphicon glyphicon-shopping-cart"></span>Cart<span class="quantity">0</span>
            </a>

            <div id="modal_form">
                <h1>Корзина</h1>

                <div class="cart_goods"></div>

                <div class="footer">
                    <div class="order">
                        <p>Всього: <span></span></p>

                        <div class="btn_order">Оформити замовлення</div>
                    </div>
                    <div class="continue">Продовжити покупки</div>

                </div>
            </div>
            <div id="overlay"></div>
            <!-- Подложка -->


            <sec:authorize access="isAuthenticated()" var="isLoggedIn"/>
            <c:choose>
                <c:when test="${isLoggedIn}">

                    <div class="login btn btn-success"><a href="<c:url value="j_spring_security_logout"/>">Log out</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="login btn btn-success"><a href="/signin">Sign in</a></div>
                </c:otherwise>
            </c:choose>

            <div class="login btn btn-success"><a href="/cart">Корзина</a><span class="amount">0</span></div>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row" style="margin-top:75px">

        <div class="col-lg-12 text-center v-center">

            <h1>Залишився лише останній крок</h1>

            <h4 style="margin-top: 20px;margin-bottom: 10px">Список покупок:</h4>

            <c:if test="${!empty productsMap}">
                <c:forEach items="${productsMap}" var="pr">
                    <p class="lead">${pr.key.name}</p>
                </c:forEach>
                <br><br><br>
            </c:if>
            <p class="lead" style="margin-top: 15px;margin-bottom: 10px;font-size:25px">На суму: ${totalPrice}</p>

            <form:form method="post" action="/order" commandName="newOrder">
            <form class="col-lg-12">
                <div class="input-group" style="width:340px;text-align:center;margin:0 auto;">
                    <form:input path="destination" class="form-control input-lg"
                                placeholder="Введіть адресу доставки" type="text"/>
                    <span class="input-group-btn"><button class="btn btn-lg btn-primary" type="submit">OK
                    </button></span>
                </div>
            </form>
        </div>
        </form:form>


    </div>

</div>
<!-- /.container -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Andrew & Nazik Website 2015</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="../../resources/js/jquery.js"></script>

<!--<script type="text/javascript" src="../../resources/js/store.js"></script>-->

<!-- Bootstrap Core JavaScript -->
<script src="../../resources/js/bootstrap.min.js"></script>

</body>

</html>


