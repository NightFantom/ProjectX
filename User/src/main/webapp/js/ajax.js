/**
 * Created by Виктор on 20.11.2014.
 */
var cUrl ;
jQuery(document).ready(function($){

    jQuery('#searchText').autocomplete({
        source: function (response, request) {
            jQuery.ajax({
                type: "POST",
                url: cUrl+"/autoComplete.do",
                dataType: "json",
                success: function(data){
                    alert(data.name);
                }

            })
        },
        delay: 300,
        minLength: 3,
        select: function (event, ui) {

        }
    });

});

function contextUrl(context){
    cUrl = context;
}