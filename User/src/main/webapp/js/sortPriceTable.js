jQuery(document).ready(function ($) {

    var $list = jQuery("#listButton");
    var $map = jQuery("#mapButton");
    var $price = jQuery("#price");
    var $workArea = jQuery("#workArea");
    $workArea.css("display","none");

    $price.tablesorter({
        sortList: [[3,0]],
        headers: {
            0: {sorter: false},
            1: {sorter: false},
            4: {sorter: false}
        },
        widgets: ["zebra"],
        widgetOptions : {
            zebra :[ "row1", "row2" ]
        },
        sortReset   : true

    });

    var $sel = jQuery(".sorter-false");
    $sel.removeClass("tablesorter-headerUnSorted");

    $price.bind("sortEnd",function(e, table) {
        $sel.removeClass("tablesorter-headerUnSorted");
    });



    $list.click(function(){
        if($list.hasClass("buttonNotCheck")){
            $list.removeClass("buttonNotCheck");
            $list.addClass("buttonCheck");
            $map.removeClass("buttonCheck");
            $map.addClass("buttonNotCheck");
            $price.removeAttr("style");
            $workArea.css("display","none");
            $price.insertBefore($workArea);
        }
    });

    $map.click(function(){
        if($map.hasClass("buttonNotCheck")){
            $map.removeClass("buttonNotCheck");
            $map.addClass("buttonCheck");
            $list.removeClass("buttonCheck");
            $list.addClass("buttonNotCheck");
            $workArea.removeAttr("style");
            $price.css("display","none");
            $workArea.insertBefore($price);
        }
    });

});