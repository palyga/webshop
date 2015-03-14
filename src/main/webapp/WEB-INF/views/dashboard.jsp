<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="../../resources/css/reset.css">
	<link rel="stylesheet" href="../../resources/css/dashboard.css">
	<script type="text/javascript" src="../../resources/js/jquery.js"></script>
	<script type="text/javascript" src="../../resources/js/stupidtable.min.js"></script>
	<script type="text/javascript" src="../../resources/js/jquery.hideseek.min.js"></script>
	<script type="text/javascript" src="../../resources/js/user.js"></script>
	<script>
		$(function(){
			$(window).scroll(function(){
				console.log($(document).height());
				console.log($(window).height());
				console.log($(window).scrollTop());
				if ($(window).scrollTop() == $(document).height() - $(window).height()){
					var h = parseInt($(".content").css("height"));
					$(".content").css("height",  h+10+"px");
				}
			});

			$(window).resize(function(){
				if ($(window).width() >= '783')
					if ($(".sidebar,.post").css("display")=="none")
						$(".btn_menu").click();
			});
			$(".btn_menu").click(function(){
				if ($(".sidebar,.post").css("display")!="none") {
					$(".sidebar,.post").animate({width:"hide",marginRight:"0"},200);
					$(".content").css({marginLeft:"0",width:"100%"});
				}
				else{
					$(".sidebar,.post").animate({width:"show"},200);
					$(".content").css({
						width:"",
						marginLeft:""});
				}
			});

			$("#logout").click(function(){
				$.post("logout.do");
			});

			$(".main_nav li a").click(function(){
				var json = {"buyerName":"3","address":"verbliany","productsList":[{"id":2,"category":"IOS","name":"Camera","pictureUrl":"images/2.png","price":140,"description":"hahaha","url":"camera"}]};
			});

			$("#restart").click(function(){
				alert("restart")
				jQuery.getJSON('/getProductsByLimit/' + count + '/9/', {}, function (json) {
					for (var i = 0; i < json.length; i++) {
						var product = json[i];
						$("#mainblock").append("<div class='col-sm-4 col-lg-4 col-md-4'><div class='thumbnail'><img src='http://placehold.it/320x150' alt=''><div class='caption'><h4 class='pull-right'>$" + product.price + "</h4><h4><a href='#'>" + product.name + "</a></h4><p>" + product.description + "</p></div><div class='ratings'><p><a class='btn btn-primary buy' href='#'' id='" + product.id + "'>Buy Now!</a></p></div> </div> </div>");
					}
				});
			});


			/*************Sort*****************/
			$("#table1").stupidtable();

			/***********edit**********/
			$("input.main_check").click(function(){
				if ($("input.main_check").prop("checked")){
					$(".check").prop("checked",true);
					$("input:text").prop("disabled",false)
				}
				else{
					$(".check").prop("checked",false);
					$("input:text").prop("disabled",true)
				}
			});
			$("input.check").click(function(){
				console.log($(this).parent().parent());
				if ($("input.check").prop("checked")){
					$($(this).parent().parent() +" input:text").prop("disabled",false)
				}
				else{
					$($(this).parent()+"input:text").prop("disabled",true)
				}
			});
			/*********Add********/

			$(".add").click(function(){
				$("#table1").append('<tr><td><input class="check" type="checkbox"></td>'+
				'<td><input type="text"   value=""></td>'+
				'<td><input type="text"   value=""></td>'+
				'<td><input type="text"  value=""></td>'+
				'<td><input type="text"  value=""></td></tr>')
			});
			/********search*******/



		});
	</script>
</head>
<body>
<div class="wrapper_dashboard">
	<header>
		<div class="post"><p>Post man</p></div>
		<div class="btn_menu"></div>
		<p class="logo"><span class="company_name" >Company</span></p>
		<div class="h_menu">
			<ul>
				<li><a href="#"><img src="../../resources/images/dashboard/msg.png" alt="Nav_images"></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/calls.png" alt="Nav_images"></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/menu_icon.png" alt="Nav_images"></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/settings.png" alt="Nav_images"></a></li>
				<li><a href="#">Sign out</a></li>
			</ul>
		</div>
	</header>
	<div class="sidebar">
		<div class="guest">
			<div class="post"><p>Post man</p></div>
			<img src="../../resources/images/dashboard/guest.jpg" alt="guest">
			<p>Welcome <br/> Guest</p>
		</div>
		<div class="main_nav">
			<ul>
				<li><a href="#"><img src="../../resources/images/dashboard/db_ico.png" alt="Nav_images"><p>Dashboard</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/ui_ico.png" alt="Nav_images"><p>Elements</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/ui_ico.png" alt="Nav_images"><p>Products</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/ui_ico.png" alt="Nav_images"><p>Users</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/ui_ico.png" alt="Nav_images"><p>Orders</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/table_ico.png" alt="Nav_images"><p>Tables</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/chats_ico.png" alt="Nav_images"><p>Charts</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/mail_ico.png" alt="Nav_images"><p>Mail</p></a></li>
				<li><a href="#"><img src="../../resources/images/dashboard/pages_ico.png" alt="Nav_images"><p>Pages</p></a></li>
				<li><a id="logout" href="#"><img src="../../resources/images/dashboard/folder_ico.png" alt="Nav_images"><p>Pages link</p></a></li>
			</ul>
		</div>
	</div>
	<div class="content">
		<button id="restart">Restart</button>
		<button>Save</button>
		<button>Delete</button>
		<button>Search</button>


		<input id="search" name="search-highlight" placeholder="Start typing here" type="text" data-list="body" autocomplete="off">


		<section class= "table">
			<form:form action="" method="put" modelAttribute="userGrid">
				<table id= "table1">
					<thead>
					<tr><th><input type="checkbox" class="toggleAll" /></th>
						<th data-sort="string">Category</th>
						<th data-sort="string">Name</th>
						<th data-sort="string">Description</th>
						<th data-sort="float">Price</th>
						<th data-sort="string">Picture</th>
					</tr>
					</thead>



					<tr>
						<td><input class="check" type="checkbox"></td>
						<td><input type="text" disabled="disabled" value="12"></td>
						<td><input type="text" disabled="disabled" value="1232"></td>
						<td><input type="text" disabled="disabled" value="dfg"></td>
						<td><input type="text" disabled="disabled" value="454"></td>
						<td><form:form method="post" action="saveFile"
									   modelAttribute="uploadForm"
									   enctype="multipart/form-data">
							<input name="files" type="file" multiple accept="image/*,image/jpeg"  />
							<input name="pname" hidden="hidden" type="text"  />
							<input type="submit" value="Upload" />
						</form:form></td>
					</tr>

					<tr>
						<td><input class="check" type="checkbox"></td>
						<td><input type="text" disabled="disabled" value="1we2"></td>
						<td><input type="text" disabled="disabled" value="6732"></td>
						<td><input type="text" disabled="disabled" value="dfg"></td>
						<td><input type="text" disabled="disabled" value="454"></td>
						<td><form:form method="post" action="saveFile"
									   modelAttribute="uploadForm"
									   enctype="multipart/form-data">
							<input name="files" type="file" multiple accept="image/*,image/jpeg"  />
							<input name="pname" hidden="hidden" type="text"  />
							<input type="submit" value="Upload" />
						</form:form></td>
					</tr>

					<tr>
						<td><input class="check" type="checkbox"></td>
						<td><input type="text" disabled="disabled" value="1322"></td>
						<td><input type="text" disabled="disabled" value="hg32"></td>
						<td><input type="text" disabled="disabled" value="d6g"></td>
						<td><input type="text" disabled="disabled" value="454"></td>
						<td><form:form method="post" action="saveFile"
									   modelAttribute="uploadForm"
									   enctype="multipart/form-data">
							<input name="files" type="file" multiple accept="image/*,image/jpeg"  />
							<input name="pname" hidden="hidden" type="text"  />
							<input type="submit" value="Upload" />
						</form:form></td>
					</tr>

					<tr>
						<td><input class="check" type="checkbox"></td>
						<td><input type="text" disabled="disabled" value="21"></td>
						<td><input type="text" disabled="disabled" value="532"></td>
						<td><input type="text" disabled="disabled" value="6g"></td>
						<td><input type="text" disabled="disabled" value="454"></td>
						<td><form:form method="post" action="saveFile"
									   modelAttribute="uploadForm"
									   enctype="multipart/form-data">
							<input name="files" type="file" multiple accept="image/*,image/jpeg"  />
							<input name="pname" hidden="hidden" type="text"  />
							<input type="submit" value="Upload" />
						</form:form></td>
					</tr>
				</table>
			</form:form>
		</section>
		<!--
		<section class= "table">
			<table id= "table2">
				<thead>
				<th><input class="main_check" type="checkbox"></th>
				<th data-sort="string">Name</th>
				<th data-sort="string">Goods</th>
				<th data-sort="string">Status</th>
				<th data-sort="float">Price</th>
				</tr>
				</thead>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>12</td>
					<td>2</td>
					<td>33</td>
					<td>43</td>
				</tr>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>1</td>
					<td>sdf2</td>
					<td>3</td>
					<td>44</td>
				</tr>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
			</table>
		</section>-->
		<!--<section class= "table">
			<table id= "table3">
				<thead>
				<th><input class="main_check" type="checkbox"></th>
				<th data-sort="string">Name</th>
				<th data-sort="string">Goods</th>
				<th data-sort="string">Status</th>
				<th data-sort="float">Price</th>
				</tr>
				</thead>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>12</td>
					<td>2</td>
					<td>33</td>
					<td>43</td>
				</tr>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>1</td>
					<td>sdf2</td>
					<td>3</td>
					<td>44</td>
				</tr>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
				<tr>
					<td><input class="check" type="checkbox"></td>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
			</table>
		</section>-->
	</div>
</div>

</body>
</html>