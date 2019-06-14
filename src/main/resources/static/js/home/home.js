

$("#manage-tab").click(function () {
    $(".home_side").hide(500);
    $(".home_side_right").removeClass("col-md-9");
    $(".home_side_right").addClass("col-md-12");
})

$("#system-tab").click(function () {
    $(".home_side").hide(500);
    $(".home_side_right").removeClass("col-md-9");
    $(".home_side_right").addClass("col-md-12");
})
$("#home-tab").click(function () {
    $(".home_side").show(1000);
    $(".home_side_right").removeClass("col-md-12");
    $(".home_side_right").addClass("col-md-9");
})

$(document).ready(function () {

 /*   $.ajax({
        url:href+"home",
        type:"POST",
        dataType: "json",
        headers:{
            'Authorization':'JSESSIONID'
        },
        success:function (result) {
            console.log(result)
        }
    })*/


 var userId = msg.userId;
    //ajax拼接===========================================

    $(function() {
        to_page(1)
    });

    function to_page(pn) {
        $.ajax({
            url:href +"u/home/getArt/"+userId,
            type:"GET",
            data:"pn="+pn,
            dataType:"json",
            success:function (result) {
                //解析并显示
                build_home_list(result);
                //解析并显示分页信息
                /*build_home_list_info(result);*/
                //解析并显示分页条
                build_home_list_PagePilot(result);
                //博客管理界面
                build_home_manage_list(result);
            }
        })

        //标签显示
        $.ajax({
            url:href +"u/home/getTags/"+userId,
            type:"GET",
            dataType:"json",
            success:function (result) {
                //显示标签
                build_home_tags_show(result);
            }
        })
        //标签显示管理界面
        $.ajax({
            url:href +"manage/getTags/"+userId,
            data:"pn="+pn,
            type:"GET",
            dataType:"json",
            success:function (result) {
                //标签管理界面
                build_home_manage_tags_list(result);
                //分页
                build_home_manage_tags_PagePilot(result);

            }
        })
        //分类显示管理界面
        $.ajax({
            url:href +"manage/getCats/"+userId,
            data:"pn="+pn,
            type:"GET",
            dataType:"json",
            success:function (result) {
                //标签管理界面
                build_home_manage_cats_list(result);
                //分页
                build_home_manage_cats_PagePilot(result);

            }
        })

        //分类显示
        $.ajax({
            url:href +"u/home/getCats/"+userId,
            type:"GET",
            dataType:"json",
            success:function (result) {
                //显示分类
                build_home_cats_show(result);
            }
        })

        //按照日期顺序显示
        $.ajax({
            url:href +"u/home/getDate/"+userId,
            type:"GET",
            dataType:"json",
            success:function (result) {
                //显示分类
                build_home_date_asc(result);
            }
        })

        $.ajax({
            url:href +"u/home/getArtViewByDesc/"+userId,
            type:"GET",
            dataType:"json",
            success:function (result) {
                //显示分类
                build_home_ArtViewByDesc_desc(result);
            }
        })

        $.ajax({
            url:href +"u/home/getArtLikeByDesc/"+userId,
            type:"GET",
            dataType:"json",
            success:function (result) {
                //显示分类
                build_home_ArtLikeByDesc_desc(result);
            }
        })
    }



    //列表
    function  build_home_list(result) {
        //清空缓存
        $("#home_list").empty();
        var article = result.userMsg.article.list;
        //遍历取出
        $.each(article,function (index,item) {
            comArtId = item.artId;
            var myblog_articleDiv_title =
                        $("<div class=\" row blog_list\"><div class=\"col-md-10\"><a class='blog_info' href='article/"+item.artId+"' artId='"+item.artId+"'><h3  >"+item.artTitle+"</h3></a></div></div>");
            var myblog_articleDiv_point =
                        $("<div class=\"row\"><div class=\"col-md-10\" ><p >"+item.artPoint+"....."+"</p></div></div>");
            var myblog_articleDvi_tag =
                        $("<div class=\"row\">" +
                            "<div class=\"col-md-2\" ><p ><i class=\"layui-icon layui-icon-note\"></i><span>"+item.tag.tagName+"</span></p></div>" +
                            "<div class=\"col-md-10\">" +
                            "<ul class=\"home_blog_info\">" +
                            "<li><a href=\"edit_blog/"+item.artId+"\"><i class=\"layui-icon layui-icon-edit\">编辑</i></a></li>" +
                            "<li><i class=\"layui-icon layui-icon-reply-fill\"></i></li>" +
                            "<li><i class=\"layui-icon layui-icon-praise\"></i><span>"+item.artLike+"</span></li>" +
                            "<li><i class=\"layui-icon layui-icon-fire\"></i><span>"+item.artView+"</span></li>" +
                            "<li><i class=\"layui-icon layui-icon-username\"></i><span>"+item.users.userUsname+"</span></li>" +
                            "<li><i class=\"layui-icon layui-icon-date\"></i><span>"+item.artWritedate+"</span></li>" +
                            "</ul>" +
                            "</div>" +
                            "</div>");

            $("<li class=\"blog_list_li\"></li>").after("<br>").append(myblog_articleDiv_title)
                            .append(myblog_articleDiv_point).append(myblog_articleDvi_tag).appendTo("#home_list");


        })

    }

    //获取特定id的详情页
    $(document).on("click",".blog_list a",function () {
        var artId  = $(this).attr("artId");
        $.ajax({
            url:href+"article/"+artId,
            type:"GET",
            success:function (result) {
                console.log(result)
            }

        })
    })


    //分页条
    function build_home_list_PagePilot(result){
        //清空缓存数据
        $(".blog_pagination").empty();
        $(".left_next_div").empty();
        $(".left_prev_div").empty();
        //分页：上一页
        var blog_prev_i = $("<i class=\"layui-icon layui-icon-left\">上一页</i>");
        var blog_prev_Btn = $(" <button type=\"button\" class=\"btn btn-light\"></button>").append(blog_prev_i);
        $("<div class=\"left_prev\"></div>").append(blog_prev_Btn).appendTo(".left_prev_div");
        //是否存在上一页
        if (result.userMsg.article.hasPreviousPage == false){
            blog_prev_Btn.addClass("disabled");
            $(".left_prev").hide();
        }else{
            blog_prev_Btn.click(function () {
                to_page(result.userMsg.article.pageNum - 1);
            })
        }

        //分页：下一页
        var blog_next_i = $("<i class=\"layui-icon layui-icon-right\">下一页</i>");
        var blog_next_Btn = $(" <button type=\"button\" class=\"btn btn-light\"></button>").append(blog_next_i);
        $("<div class=\"left_next\"></div>").append(blog_next_Btn).appendTo(".left_next_div");
        //是否存在下一页
        if (result.userMsg.article.hasNextPage == false){
            blog_next_Btn.addClass("disabled");
            $(".left_next").hide();
        }else{
            blog_next_Btn.click(function () {
                to_page(result.userMsg.article.pageNum + 1);
            })
        }

        //分页条
        var ul = $("<ul class=\"pagination\"></ul>");
        $.each(result.userMsg.article.navigatepageNums,function (index,item) {
            var blog_PagePilot_li = $("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">"+item+"</a></li>");
            //加入点击跳转
            blog_PagePilot_li.click(function () {
                to_page(item)
            })
            //激活状态:当前页/非当前页
            if (result.userMsg.article.pageNum == item){
                blog_PagePilot_li.addClass("active");
            }
            ul.append(blog_PagePilot_li);

        })
        $("<nav aria-label=\"...\"></nav>").append(ul).appendTo(".blog_pagination");

    }

    //标签全部信息
    function build_home_tags_show(result) {
        $(".page_tags_scanf").empty();
       var home_tags = result.userMsg.tags;
       $.each(home_tags,function (index,item) {
           var home_page_a = $("<a class=\"badge badge-pill badge-secondary tags_secondary\" href=\"#\">"+item.tagName+"</a>");
           home_page_a.appendTo(".page_tags_scanf");
       })
    }

    //分类全部信息
    function build_home_cats_show(result) {
        $(".page_cats_scanf").empty();
        var home_cats = result.userMsg.cats;
        $.each(home_cats,function (index,item) {
            var home_page_a = $("<a class=\"badge badge-pill badge-secondary cats_secondary\" href=\"#\">"+item.catName+"</a>");
            home_page_a.appendTo(".page_cats_scanf");
        })
    }

    //时间全部信息
    function build_home_date_asc(result) {
        $(".page_time_scanf").empty();
        var home_date = result.userMsg.date;
        $.each(home_date,function (index,item) {
            var home_page_a = $(" <h4><a class=\"badge badge-pill badge-secondary date_secondary\" href=\"#\">" +
                ""+item.art_writedate+"年<span class=\"badge badge-pill badge-light\">"+item.art_id+"</span></a></h4>");
            home_page_a.appendTo(".page_time_scanf");
        })
    }

    function build_home_ArtViewByDesc_desc(result) {
        $(".page_view_scanf").empty();
        var home_artByDesc = result.userMsg.ArtViewByDesc;
        var ul = $("<ul class=\"list-group\"></ul>");
        $.each(home_artByDesc,function (index,item) {
            var home_artByDesc_li = $("<a href='#' class=\"list-group-item d-flex justify-content-between align-items-center\">" +
                ""+item.artTitle+"<span class=\"badge badge-primary badge-pill\">"+item.artView+"</span></a>");
            ul.append(home_artByDesc_li);
        })
        ul.appendTo(".page_view_scanf");
    }

    function build_home_ArtLikeByDesc_desc(result) {
        $(".like_scanf").empty();
        var home_artByDesc = result.userMsg.ArtLikeByDesc;
        var ul = $("<ul class=\"list-group\"></ul>");
        $.each(home_artByDesc,function (index,item) {
            var home_artByDesc_li = $("<a href='#' class=\"list-group-item d-flex justify-content-between align-items-center\">" +
                ""+item.artTitle+"<span class=\"badge badge-primary badge-pill\">"+item.artLike+"</span></a>");
            ul.append(home_artByDesc_li);
        })
        ul.appendTo(".like_scanf");
    }


    //博客管理界面显示
    function build_home_manage_list(result) {
        $(".home_manage_article").empty();
        var manage_article = result.userMsg.article.list;
        var ul = $("<ul class=\"list-group\"></ul>");
        $.each(manage_article,function (index,item) {
            var manage_article_div = $("<li class=\"list-group-item list-group-item-action \">" +
                "<div class=\"row\">" +
                "<a href='article/"+item.artId+"' artId='"+item.artId+"' class=\"col-md-7\">"+item.artTitle+"</a>" +
                "<span class=\"col-md-1\">"+item.artStatus+"</span>" +
                "<span class=\"col-md-1\">"+item.artView+"</span>" +
                "<span class=\"col-md-1\">"+item.artLike+"</span>" +
                "<a href=\"#\" class=\"col-md-1\">编辑</a>" +
                "<a href=\"#\" class=\"col-md-1\">删除</a>" +
                "</div>" +
                "</li>");
            ul.append(manage_article_div);
        })
        ul.appendTo(".home_manage_article");
    }

    //管理界面标签显示
    function build_home_manage_tags_list(result) {
        $(".home_manage_tag").empty();
        var home_manage_tags = result.userMsg.tags.list;
        var ul = $("<ul class=\"list-group\"></ul>");
        $.each(home_manage_tags, function (indes,item) {
            var li = $("<li class=\"list-group-item list-group-item-action \">" +
                "<div class=\"row\">" +
                "<a href=\"#\" class=\"col-md-7\">"+item.tag_name+"<span>("+item.ta_count+")</span></a>" +
                "<a href=\"#\" class=\"col-md-1\">编辑</a>" +
                "<a href=\"#\" class=\"col-md-1\">删除</a>" +
                "</div>" +
                "</li>");
            ul.append(li);
        });
        ul.appendTo(".home_manage_tag");
    }

    function build_home_manage_tags_PagePilot(result){
        //更改过
        $(".tagul").empty();
        //上一页
        var tags_prev = $("<li class=\"page-item tags_prev\">" +
            "<a class=\"page-link\" href=\"#\">上一页</a>" +
            "</li>");
        if (result.userMsg.tags.hasPreviousPage == false){
            tags_prev.addClass("disabled");
            $(".tags_prev").hide();
        }else{
            tags_prev.click(function () {
                to_page(result.userMsg.tags.pageNum - 1);
            })
        }
        //下一页
        var tags_next = $("<li class=\"page-item tags_next\">" +
            "<a class=\"page-link\" href=\"#\">下一页</a>" +
            "</li>");
        if (result.userMsg.tags.hasNextPage == false){
            tags_next.addClass("disabled");
            $(".tags_next").hide();
        }else{
            tags_next.click(function () {
                to_page(result.userMsg.tags.pageNum + 1);
            })
        }
        //分页条
        var ul = $("<ul class=\"pagination tagul\"></ul>");
        $.each(result.userMsg.tags.navigatepageNums,function (index,item) {
              var blog_PagePilot_li = $("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">"+item+"</a></li>");
            //加入点击跳转
            blog_PagePilot_li.click(function () {
                to_page(item)
            })
            //激活状态:当前页/非当前页
            if (result.userMsg.tags.pageNum == item){
                blog_PagePilot_li.addClass("active");
            }
            ul.append(blog_PagePilot_li);
        })
        ul.append(tags_prev).append(tags_next);
        $("<nav aria-label=\"...\"></nav>").append(ul).appendTo(".tags_pagination");

    }


    function build_home_manage_cats_list(result) {
        $(".home_manage_cat").empty();
        var home_manage_cats = result.userMsg.cats.list;
        var ul = $("<ul class=\"list-group\"></ul>");
        $.each(home_manage_cats, function (indes,item) {
            var li = $("<li class=\"list-group-item list-group-item-action \">" +
                "<div class=\"row\">" +
                "<a href=\"#\" class=\"col-md-7\">"+item.cat_name+"<span>("+item.ca_count+")</span></a>" +
                "<a href=\"#\" class=\"col-md-1\">编辑</a>" +
                "<a href=\"#\" class=\"col-md-1\">删除</a>" +
                "</div>" +
                "</li>");
            ul.append(li);
        });
        ul.appendTo(".home_manage_cat");
    }

    function build_home_manage_cats_PagePilot(result){

        $(".catul").empty();
        //上一页
        var cats_prev = $("<li class=\"page-item cats_prev\">" +
            "<a class=\"page-link\" href=\"#\">上一页</a>" +
            "</li>");
        if (result.userMsg.cats.hasPreviousPage == false){
            cats_prev.addClass("disabled");
            $(".cats_prev").hide();
        }else{
            cats_prev.click(function () {
                to_page(result.userMsg.cats.pageNum - 1);
            })
        }
        //下一页
        var cats_next = $("<li class=\"page-item cats_next\">" +
            "<a class=\"page-link\" href=\"#\">下一页</a>" +
            "</li>");
        if (result.userMsg.cats.hasNextPage == false){
            cats_next.addClass("disabled");
            $(".cats_next").hide();
        }else{
            cats_next.click(function () {
                to_page(result.userMsg.cats.pageNum + 1);
            })
        }
        //分页条
        var ul = $("<ul class=\"pagination catul\"></ul>");
        $.each(result.userMsg.cats.navigatepageNums,function (index,item) {
            var blog_PagePilot_li = $("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">"+item+"</a></li>");
            //加入点击跳转
            blog_PagePilot_li.click(function () {
                to_page(item)
            })
            //激活状态:当前页/非当前页
            if (result.userMsg.cats.pageNum == item){
                blog_PagePilot_li.addClass("active");
            }
            ul.append(blog_PagePilot_li);
        })
        ul.append(cats_prev).append(cats_next);
        $("<nav aria-label=\"...\"></nav>").append(ul).appendTo(".cats_pagination");
    }
})

