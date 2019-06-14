/*
* 提交内容
* */
$(document).ready(function () {
    $(".add_Btn").click(function () {
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
          "userId" : msg.userId,
    }
        $.ajax({
            url : href+"addBlog",
            data : JSON.stringify(addBlog),
            type : "POST",
            dataType: "json",
            contentType: 'application/json; charset=UTF-8',
            success:function (result) {
                console.log(result.msg)
            }
        })
    })
})
