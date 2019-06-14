layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#test1'
        ,width: '100%', //设置容器宽度
        height:'400px'
        ,arrow: 'always', //始终显示箭头
        //,anim: 'updown' //切换动画方式
        autoplay:'true',  //自动切换
    });
});


$(document).ready(function () {
    $(".photo_a img").click(function () {
        $(".model_user").toggle(500);
    })

})
