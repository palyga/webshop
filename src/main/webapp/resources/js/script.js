
function loadData() {

    var $body = $('body');
    
    //var $nytHeaderElem = $('#nytimes-header');
    //var $nytElem = $('#nytimes-articles');
    //var $greeting = $('#greeting');
	
	var $tabularasa=$('#tabularasa');
	$tabularasa.append('<tr><th>First</th><th>Second</th><th>Third</th><th>Fourth</th></tr>');
	
	/*var $test=$('#test');
	$test.text("Hi");*/
	
    // clear out old data before new request
    /*$wikiElem.text("");
    $nytElem.text("");

    // load streetview

    // YOUR CODE GOES HERE!
	var street = $('#street').val();
	
	var city = $('#city').val();
	var address=street+', '+city;
	
	$greeting.text("So, you want to live at"+address);
	
	url='https://maps.googleapis.com/maps/api/streetview?size=400x400&location='+address+'';
	
	$body.append('<img class="bgimg" src="'+url+'">');
	
	
	
	var NyTUrl='http://api.nytimes.com/svc/search/v2/articlesearch.json?q='+city+'&sort=newest&api-key=fbf64ffce7612d21d58c89adada4927c:6:70472006';
	alert(NyTUrl);*/
	
	
	
	$.getJSON(NyTUrl,function(data){
		//$nytHeaderElem.text('NY Times Articles about'+city);
		
		
		//articles=data.response.docs;
		
		for(var i=0;i<articles.length;i++){
			var a=articles[i];
			$nytElem.append('<li class="article">'+'<a href'+a.web_url+'">'+ a.headline.main+'</a>'+'<p>'+a.snippet+'</p>'+'</li>');
			
		};
	}).error(function(e){
		$nytHeaderElem.text("Some error");
	});
	
	
	
	alert("Hello");
	
	
    return false;
};

$('#form-container').submit(loadData);

$("#btn").click(function() {
	alert("My button was clicked!");
	
	$.getJSON('/ajax',function(data){
	});

});
	
	
	
// loadData();
