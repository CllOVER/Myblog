//Demo
layui.use('form', function(){
    var form = layui.form;
    form.render();
    form.render('radio');


    //监听提交
    $(".SaveDemo").click(function (e) {
        var data = {
            "userName":$("#userName").html(),
            "userUsname":$("#userUsname").val(),
            "userAddress":$("#userAddress").val(),
            "userAge":$("#userAge").val(),
            "userBirthday":$("#userBirthday").val(),
            "userEmail":$("#userEmail").val(),
            "userPhone":$("#userPhone").val(),
            "userQq":$("#userQq").val(),
            "userDesc":$("#userDesc").val(),
            "userSex":$("#system_up input[name = userSex]").val()
        };
        $.ajax({
            url:href+"u/home/system/updateUser",
            data:JSON.stringify(data),
            type:"PUT",
            dataType:"json",
            contentType:"application/json",
            success:function (result) {
                console.log(result)
            }
        })
        e.preventDefault()
    })
});

layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#userBirthday' //指定元素
        ,min: '1900-1-1'
        ,max: '2099-12-31'
    });
});

$(document).ready(function () {
    $.ajax({
        url:href+"u/home/system/getAll",
        type:"GET",
        success:function (result) {
            var user = result.userMsg.user[0];
            $("#userName").html(user.userName);
            $("#userUsname").val(user.userUsname);
            $("#userAddress").val(user.userAddress);
            $("#userAge").val(user.userAge);
            $("#userBirthday").val(user.userBirthday);
            $("#userEmail").val(user.userEmail);
            $("#userPhone").val(user.userPhone);
            $("#userQq").val(user.userQq);
            $("#userDesc").val(user.userDesc);
            $("#system_up input[name = userSex]").val([user.userSex])
            //重新渲染表单
            layui.use('form', function(){
                var form = layui.form;  //只有执行了这一步，部分表单元素才会自动修饰成功
                form.render('radio');
                form.render('select');
            });
        }
    })
})
