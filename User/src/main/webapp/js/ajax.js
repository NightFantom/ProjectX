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
                data: "form="+$("#searchText").val(),
                success: function(data,status,jqXHR){
                    $(".floatLeft").append(data.toString());
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