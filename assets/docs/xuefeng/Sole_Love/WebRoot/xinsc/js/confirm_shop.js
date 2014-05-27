$(document).ready(function(){
    $("input#sub_confirm").click(function(){
        $("div.mask").css("height",$(document).height());
        $("div.mask").css("width",$(document).width());
        $("div.mask").show();
        $("div.mask_info").show();
    })
    $("div.x").click(function(){
        $("div.mask").hide();
        $("div.mask_info").hide();
    })
})

function minus(){
    var input=document.getElementById("amount");
    var amount=parseInt(input.value);
    if(amount===1){
        return ;
    }
    input.value=--amount;
}
function plus(){
    var input=document.getElementById("amount");
    var amount=parseInt(input.value);
    input.value=++amount;
}
