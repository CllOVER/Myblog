
layui.use(['layer','layedit', 'form','jquery'],function() {
    var form = layui.form, layer = layui.layer;
    var $ = layui.$;
    var layedit = layui.layedit;
    var index = layedit.build('comment',{
        tool: ['strong', 'italic', 'underline', '|', 'left', 'center', 'right', '|', 'face', 'link', 'unlink'],  //定制工具栏
        height: 250
    }); //建立编辑器



    $(".comment_go").click(function () {
        commment();
        var data = {
            'comContent':layedit.getContent(index),
            'comUserId':msg.userId,
            'comArtId':comArtId
        }
        $.ajax({
            url:href+"u/home/article/comment/add",
            type:"POST",
            data:JSON.stringify(data),
            dataType:"json",
            contentType: 'application/json; charset=UTF-8',
            success:function (result) {
                console.log(result)
            }
        })

    })
})

function commment(){
    $.ajax({
        url:href+"u/home/article/comment/list/"+comArtId,
        type:"GET",
        success:function (result) {
            console.log(result);

        }
    })
}


/*function comment_user(result) {

    var comment = result.userMsg.comment;
    var ul = $("<ul></ul>");
    var comment_all = '';
    $.each(comment,function (index,item) {
        var comment_photo = $("<div class=\"col-md-1\"><img th:src='@{"+item.userPhoto+"}' alt=\"...\" class=\"img-circle photo_med\"></div>");
        var comment_li = $("<li class=\"row\">"+item.user.userUsname+"" +
            "<span class=\"col-md-4\">&nbsp;&nbsp;发表于:<span>"+item.comDate+"</span></span>" +
            "<span class=\"col-md-2\"></span>" +
            "<span class=\"col-md-2\"><i class=\"layui-icon layui-icon-praise\"></i>"+item.comLike+"赞</span>" +
            "<a class=\"btn btn-link btn-sm main_comment1\" data-toggle=\"collapse\" href=\"#multiCollapseExample1\" role=\"button\" aria-expanded=\"false\" aria-controls=\"multiCollapseExample1\">" +
            "<i class=\"layui-icon layui-icon-dialogue\"></i>(2000)回复</a></li>");
        var comment_li_content = $("<li class=\"col-md-9\"><p class=\"comment_content\">"+item.comContent+"</p></li><br><hr>");
        ul.append(comment_li).append(comment_li_content);
        var comment_div = $("<div class=\"col-md-11\"></div>").append(ul);
         comment_all = $("<div class=\"row\" ></div>").append(comment_photo).append(comment_div);
    })
    comment_all.appendTo(".comment");
}*/


