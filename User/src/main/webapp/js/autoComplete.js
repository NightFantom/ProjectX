jQuery(document).ready(function($){

    var $search =  jQuery("#searchText");

    $search.autocomplete({
        source:function(request, response){
            jQuery.ajax({
                url: "/user/autoComplete.do" ,
                type: "POST",
                data: $search.attr("value"),// по идее должна отправиться строка, которую ввел человек в поиск
                dataType: "json",
                success: function(data){
                    var items = data.value; // data.value =  массив из строк, можно наверно убрать эту переменную
                    response(items);
                }
        })},
        delay: 300,
        minLength: 3
    })
});