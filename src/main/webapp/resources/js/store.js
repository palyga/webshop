jQuery(document).ready(function( ){
	var jsono;
	var product;
	var pr;

	var current=0, sum =0, price=0 ;
	var $count,
		srcImg,
		name,
		pricegoods;

	/**************Корзина**********/
	$('a#go').click( function(e){
		e.preventDefault();
		if($(".cart .quantity").text()!=0){
			$('#overlay').fadeIn(300,
				function(){
					$('#modal_form')
						.css('display', 'block')
						.animate({opacity: 1, top: '10%'}, 500);
				});
			$('#overlay,.continue').click( function(){
				$('#modal_form')
					.animate({opacity: 0, top: '0%'}, 200,
					function(){
						$(this).css('display', 'none');
						$('#overlay').fadeOut(400);
					}
				);
			});
		}
	});
	/*Кнопка купити/*/
	$(".buy").click(function(e){
		e.preventDefault();
		console.log($(this).attr("id"));
		$.post("/addToCart", {id:  $(this).attr("id"),quantity:  1});



		$count=$(".cart .quantity").text()*1;//преведеня до числа
		console.log($count);
		if($(this).html()!=="В корзині"){
			console.log('in if');
			$(this).html("В корзині").css("width","100px");
			$count+=1;
			$(".cart .quantity").text(""+$count);
			//jsono=jQuery.getJSON('/projson' , {id:  $(this).attr("id")},
			// function(json){return json});
			// console.log(jsono);
			//alert (JSON.stringify(jsono));
			//console.log(jsono[0].price);
			function palyga(json) {

				console.log('in json');
				product = json;
				console.log(product);
				console.log(product.price);

			}
			jQuery.getJSON('/projson' , {id:  $(this).attr("id")}, palyga);


			pr = parseInt(product.price);

			console.log(pr);
			sum += pr;
			console.log(sum);
			$(".order span").text(sum+"грн");
			$("#modal_form .cart_goods").append('<div  class="things" id="'+product.id+'"><span></span><div class="del">X</div><img src="'+product.proutes+'"><a href="#">'+product.name+'</a><div class="sum">'+product.price+'</div><div class="count"><input type="button" value="-" class="qtyminus" field="quantity" /><input type="text" name="quantity" value="1" class="qty" /><input type="button" value="+" class="qtyplus" field="quantity" /></div><hr></div>');

			//$("#modal_form .cart_goods").append('<div  class="things"><span></span><div class="del">X</div><img src="'+product.proutes+'"><a href="#">'+product.name+'</a><div class="sum">'+product.price+'</div><div class="count"><input type="button" value="-" class="qtyminus" field="quantity" /><input type="text" name="quantity" value="1" class="qty" /><input type="button" value="+" class="qtyplus" field="quantity" /></div><hr></div>');
			//var pr = parseInt(product.price);
			//sum += pr;
			//$(".order span").text(sum+"грн");
			/*Цикл пошуку конкретного товару по ID*/
			/*for(var i= 0; i<goods_json.length; i++){
			 if($(this).attr("id")==goods_json[i].id){
			 srcImg=goods_json[i].proutes;
			 name=goods_json[i].name;
			 pricegoods=goods_json[i].price;
			 }
			 }*/

		}
		else{
			$('a#go').click();
		}
		$(".del").click(function(e){
			$.post("/removeFromCart", {id: (this.parentNode.id)});
			e.stopImmediatePropagation() ;
			sum -= parseInt($(this).parent().children().eq(4).text());
			$(".cart .quantity").text(""+(--$count));
			$(".order span").text(sum+"грн");
			if($count==0)
				$(".box_goods").eq($(this).parent().children().eq(0).text()).children().eq(2).text("Купити");
			$(this).parent().remove();
			if($(".cart .quantity").text()==0)
				$("#overlay").click();

		});

		/******** + - *********/

		$('.qtyplus').click(function(e){
			// Stop acting like a button
			e.stopImmediatePropagation() ;
			// Get the field name

			var input = $(this).prev();
			// Get its current value
			var currentVal = parseInt(input.val());
			// If is not undefined
			if (!isNaN(currentVal)) {
				// Increment
				input.val(currentVal + 1);
			} else {
				// Otherwise put a 0 there
				input.val(1);
			}
			//$.post("/addToCart", {id:  this.parentNode.parentNode.id, quantity:input.val()});
			var minus = parseInt($(this).parent().parent().children().eq(4).text());
			price = pr*(currentVal + 1);
			sum +=price-minus; /*добавляєм до суми текучу ціну вираховуючи попередню*/
			$(this).parent().parent().children().eq(4).text(price+"грн");
			$(".order span").text(sum+"грн");

		});
		// This button will decrement the value till 0
		$(".qtyminus").click(function(e) {
			// Stop acting like a button
			e.stopImmediatePropagation();
			// Get the field name
			var input = $(this).next();
			// Get its current value
			var currentVal = parseInt(input.val());
			// If it isn't undefined or its greater than 0
			if (!isNaN(currentVal) && currentVal > 1) {
				// Decrement one
				input.val(currentVal - 1);
				var minus = parseInt($(this).parent().parent().children().eq(4).text());
				price = pr*(currentVal - 1);
				sum +=price-minus; /*добавляєм до суми текучу ціну вираховуючи попередню*/
				$(this).parent().parent().children().eq(4).text(price+"грн");
				$(".order span").text(sum+"грн");
			} else {
				// Otherwise put a 0 there
				input.val(1);
			}
			//$.post("/addToCart", {id:  this.parentNode.parentNode.id, quantity:input.val()});
		});
	});
});