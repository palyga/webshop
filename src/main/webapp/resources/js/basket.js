jQuery(document).ready(function( ){
    var pr=0,price;
    var sum =parseInt($(".order span").text());
    console.log(sum);


    $(".del").click(function(){
        $.post( "/removeFromCart",{id:this.parentNode.id}, function( data ) {
            $(".order span").text(data+" грн");
         });
        $(this).parents(".things").animate({ opacity: 'hide' }, "slow");

    });


    $(".qtyminus").click(function(e) {
        $.post( "/minusProductCart",{id:this.parentNode.parentNode.id}, function( data ) {
            obj = JSON.parse(data);
            var ref=obj.id;
            $("#"+ref+" .sum").text(obj.pprice+" грн");
            $("#"+ref+" .qty").attr("value",obj.amount);
            $(".order span").text(obj.total+" грн");
        });

    });

    $('.qtyplus').click(function(e){
        $.post( "/plusProductCart",{id:this.parentNode.parentNode.id}, function( data ) {
            obj = JSON.parse(data);
            var ref=obj.id;
            $("#"+ref+" .sum").text(obj.pprice+" грн");
            $("#"+ref+" .qty").attr("value",obj.amount);
            $(".order span").text(obj.total+" грн");
        });


    });








});   