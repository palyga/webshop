
function getLimitproducts(count){
    root='/getProductsByLimit/' + count + '/9/';
    jQuery.getJSON(root, {}, function (json) {
        for (var i = 0; i < json.length; i++) {
            var product = json[i];
            $("#mainblock").append("<div class='col-sm-4 col-lg-4 col-md-4'><div class='thumbnail'><img src='http://placehold.it/320x150' alt=''><div class='caption'><h4 class='pull-right'>$" + product.price + "</h4><h4><a href='#'>" + product.name + "</a></h4><p>" + product.description + "</p></div><div class='ratings'><p><a class='btn btn-primary buy' href='#'' id='" + product.id + "'>Buy Now!</a></p></div> </div> </div>");
        }
    });
    count +=9;
    return count;

}
rCount = 1;
$(window).scroll(function () {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
        rCount=getLimitproducts(rCount);
    }
});

