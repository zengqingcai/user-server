$(function () {
    $.ajax({
        url:"/initMenu",
        type:"post",
        dataType:"json",
        contentType :"application/json",
        success:function(data){
            if(data.code==200){
                initMenu(data)
            }else{
                alert(data.code);
            }
        },
        error:function () {
            alert("系统错误！")
        }
    });
});


function initMenu(data) {
    $('#menu').sidebarMenu(data);
}