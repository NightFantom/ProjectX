jQuery(document).ready(function($){

    var $search =  jQuery("#searchText");

    $search.autocomplete({
        source:function(request, response){
            jQuery.ajax({
                url: "/user/autoComplete.do" ,
                type: "POST",
                data: "searchString=" + $search.val(),
                dataType: "json",
                success: function(data){
                    response(data);
                }
            })},
        delay: 300,
        minLength: 3
    })
});