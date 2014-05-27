$(document).ready(function(){
    $("div.small_box").click(function(){
        var  $self = $(this);
        var x = $self.offset().left;
        var y = $self.offset().top;
        var $gou = $("div.gou");
        var $gou_x = x + $self.width()-(2/3)*$gou.width();
        var $gou_y = y - $gou.height()/2;
        $gou.css({"left":$gou_x,"top":$gou_y});
        $gou.show();
    })
})
