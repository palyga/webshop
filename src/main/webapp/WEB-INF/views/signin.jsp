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

    <script src="../../resources/js/lazypload.js"></script>


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
            background: rgba(0, 0, 0, 0.77);
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




            <div class="login btn btn-success"><a href="/cart">Корзина</a><span class="amount">0</span></div>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container" style="margin-top:75px">

    <div class="container">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <div class="panel-heading">
                    <div class="panel-title">Sign In</div>
                </div>

                <div style="padding-top:30px" class="panel-body" >

                    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                    <form action="<c:url value='j_spring_security_check'/>" method="POST" id="loginform" class="form-horizontal" role="form">

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input id="login-username" type="text" class="form-control" name="j_username"  placeholder="email">
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input id="login-password" type="password" class="form-control" name="j_password" placeholder="password">
                        </div>


                        <div style="margin-top:10px" class="form-group">
                            <!-- Button -->

                            <div class="col-sm-12 controls">
                                <input type="submit" value="Login" id="btn-login" class="btn btn-success">
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-md-12 control">
                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                    Don't have an account!
                                    <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                        Sign Up Here
                                    </a>
                                </div>
                            </div>
                        </div>


                    </form>



                </div>
            </div>
        </div>

        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">

                    <div class="panel-title">Sign Up</div>
                    <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                </div>
                <div class="panel-body" >

                    <form:form method="post" action="/signup"  id="signupform" class="form-horizontal" commandName="newUser" role="form">


                        <div id="signupalert" style="display:none" class="alert alert-danger">
                            <p>Error:</p>
                            <span></span>
                        </div>



                        <div class="form-group">
                            <label for="email" class="col-md-3 control-label">Email</label>
                            <div class="col-md-9">
                                <form:input path="email" class="form-control" name="email" placeholder="Email Address"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="firstname" class="col-md-3 control-label">First Name</label>
                            <div class="col-md-9">
                                <form:input path="firstName" type="text" class="form-control" name="firstname" placeholder="First Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-md-3 control-label">Last Name</label>
                            <div class="col-md-9">
                                <form:input type="text" path="lastName" class="form-control" name="lastname" placeholder="Last Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-md-3 control-label">Password</label>
                            <div class="col-md-9">
                                <form:input path="password" type="password" class="form-control" name="passwd" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-md-3 control-label">Confirm Password</label>
                            <div class="col-md-9">
                                <form:input path="confirmPassword" type="password" class="form-control" name="passwd" placeholder="Password"/>
                            </div>
                        </div>



                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                               <input id="btn-signup" type="submit" value="Register" class="btn btn-info">
                            </div>
                        </div>

                    </form:form>
                </div>
            </div>




        </div>
    </div>

    <!-- jQuery -->
    <script src="../../resources/js/jquery.js"></script>

    <!--<script type="text/javascript" src="../../resources/js/store.js"></script>-->

    <!-- Bootstrap Core JavaScript -->
    <script src="../../resources/js/bootstrap.min.js"></script>
</div>
</body>

</html>
