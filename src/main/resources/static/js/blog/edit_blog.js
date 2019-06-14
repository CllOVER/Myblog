

$(function () {
    var artTop_hidden = $("#artTop_hidden").val();
    var artOpenPrivate_hidden = $("#artOpenPrivate_hidden").val();
    var artStatus_hidden = $("#artStatus_hidden").val();
    if (artTop_hidden == 1){
       $("#artTop_label_1").removeClass("active");
        $("#artTop_label_2").addClass("active");
    }
    if (artOpenPrivate_hidden == 0){
        $("#add_open_label_1").removeClass("active");
        $("#add_open_label_2").addClass("active");
    }
    if (artStatus_hidden == 0){
        $("#add_status_label_1").removeClass("active");
        $("#add_status_label_2").addClass("active");
    }


    $("#update_blog_succ").click(function () {

        //获取当前地址的参数
        var url = decodeURI(window.location.href);
        var argsIndex = url .split("/",6);
        var comArtId = argsIndex[5];

        var addBlog ={
            "artTitle": $("#inputSuccess1").val(),
            "artContent" : tinyMCE.activeEditor.getContent(),
            "catName" : $(".cads").val(),
            "tagName" : $(".tags").val(),
            "artTop" : $(".add_top input[name = artTop]").val(),
            "artOpenPrivate" : $(".add_open input[name = artOpenPrivate]").val(),
            "artStatus" : $(".add_status input[name = artStatus]").val(),
            "artDesc" : $(".artDesc").val(),
            "artPoint" : $(".artPoint").val(),
            "artUserId" : msg.userId,
            "artId" : comArtId
        }

        $.ajax({
            url:href+"u/edit_blog",
            data:JSON.stringify(addBlog),
            type:"POST",
            dataType:"json",
            contentType: 'application/json; charset=UTF-8',
            success:function (result) {
                console.log(result)
            }
        })
    })

})
