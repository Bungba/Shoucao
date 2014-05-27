
function minus(){
    var input=document.getElementById("year");
    var amount=parseInt(input.value);
    input.value=--amount;
    }
function plus(){
    var input=document.getElementById("year");
    var amount=parseInt(input.value);
    input.value=++amount;
    }
$(document).ready(function(){
    $("ul li").click(function(){
        var $self=$(this);
        $("ul li").css({"background-color":"#f5f5f5","color":"#c8c8c8"});
        $self.css({"background-color":"#c3e2d3","color":"white"});
})
})

