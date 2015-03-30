/**
 * Created by Виктор on 28.03.2015.
 */
var $popUpCheckCity;
/**
 * Инициализация всплывашки уточнения города
 */
function initPopUp(){

    $("#popUpChangeCityCross").click(function(){
        $popUpCheckCity.css("display", "none");
    });
    $("#popUpChangeCityAnswerYes").click(function(){
        $popUpCheckCity.css("display", "none");
    });
    $popUpCheckCity.animate({
        opacity:1
    }, 900);
}

jQuery(document).ready(function () {
    var changeCity;
    $(".changeCityLink").click(function(){
        var changeCity = $(this);
        var id = changeCity.attr("id");
        $.ajax({
            url: path + "/changeCity.do" ,
            type: "POST",
            data: "id=" + id,
            dataType: "json",
            success: function(data){
                if(data.success){
                    $("#currentCity").html(changeCity.html());
                }
            }
        })
    });
    $popUpCheckCity = $("#popUpCheckCity");
    initPopUp();

});