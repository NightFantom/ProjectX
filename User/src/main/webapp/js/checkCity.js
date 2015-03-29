/**
 * Created by Виктор on 28.03.2015.
 */
jQuery(document).ready(function ($) {
    var $cities = jQuery('#popUpSelectCity');
    var $selectCity =jQuery('#selectCity');
    var $popup = jQuery('#popUp');
    $cities.hide();
    if (status == 'false') {

    }else{

    }
    $selectCity.hover(function(){$cities.show();},function(){$cities.hide();});
});
