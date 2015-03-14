<%--
  Created by IntelliJ IDEA.
  User: Василь
  Date: 28.02.2015
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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

        .pmpicture {
            max-width: 400px;
            max-height: 600px;
        }
    </style>

</head>

<body>

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

                    <div class="login btn btn-success"><a href="j_spring_security_logout">Log out</a>
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

    <div class="row">

        <div class="col-md-3 sidebar" style="margin-top: 90px;">
            <p class="lead">Category</p>

            <div class="list-group">
                <a href="/mobile/" class="list-group-item ">Mobile phone</a>
                <a href="/tablet/" class="list-group-item">Tablet</a>
                <a href="/notebook/" class="list-group-item">Notebook</a>
            </div>
        </div>

        <div class="col-md-9" style="margin-top:75px">

            <div class="thumbnail">
                <img width="320" height="150" class="img-responsive pmpicture" src="/picture/${product.proutes}" alt="">

                <div class="caption-full">
                    <h4 class="pull-right">${product.price} грн</h4>
                    <h4><${product.name}</h4>

                    <p>${product.description}</p>

                    <div class="ratings">
                        <p>
                            <a href="#" id="${product.id}" class="buy btn btn-primary">Buy Now!</a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="well">


                <div class="text-right">
                    <c:choose>
                        <c:when test="${isLoggedIn}">
                            <a class="btn btn-success" id="commentSubmit">Leave a Review</a>
                        </c:when>
                        <c:otherwise>
                            <a class="btn btn-success" id="commentSubmit">Please, log in to add comment</a>
                        </c:otherwise>
                    </c:choose>
                </div>

                <hr>


                <c:if test="${!empty commentList}">
                    <c:forEach items="${commentList}" var="com">
                        <div class="row">
                            <div class="col-md-12">
                                <p>${com.comment}</p>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>
                </c:if>


            </div>

        </div>

    </div>

</div>
<!-- /.container -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="../../resources/js/jquery.js"></script>

<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../resources/js/bootstrap.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</body>

</html>