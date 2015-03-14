$(function addCommens() {
    $("#commentSubmit").click({
        /*source : function(request, response) {
            $.ajax({
                async : true,
                type : "GET",
                url : "/",
                dataType : "json",
                data : {
                    stationStartsWith : request.term
                },
                success : function(data) {
                    response($.map(data.stations, function(item) {
                        return {
                            label : item,
                            value : item
                        };
                    }));
                }
            });
        },
        minLength : 1,
        open : function() {
            $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        close : function() {
            $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }*/
    });
});