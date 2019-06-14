/*
* 初始化编辑器
* */
tinymce.init({
    selector:'textarea',
    menubar: false,  //禁用菜单栏
    plugins: "advcode",

    //添加参数
    plugins: [
        "advlist autolink lists link image charmap preview",
        "searchreplace visualblocks fullscreen",
        "insertdatetime media table contextmenu paste",
        "emoticons textcolor",
    ],
    height:'560px',
    //启用工具栏并显示如下项
    // 工具栏
    toolbar1: "undo redo | styleselect | fontselect | fontsizeselect | bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent",
    toolbar2: " preview | forecolor backcolor emoticons | table | link image media | code",
    //字体设置
    font_formats: "宋体=宋体;黑体=黑体;仿宋=仿宋;楷体=楷体;隶书=隶书;幼圆=幼圆;" +
        "Arial=arial,helvetica,sans-serif;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Tahoma=tahoma,arial,helvetica,sans-serif;Times New Roman=times new roman,times;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings,zapf dingbats",
    fontsize_formats: "8pt 10pt 12pt 14pt 18pt 24pt 36pt",
    //防止图片路径报错
    relative_urls: false,
    //换行符会被转换成 br 元素
    convert_newlines_to_brs: false,
    //在换行处 TinyMCE 会用 BR 元素而不是插入段落
    force_br_newlines: false,
    //不允许拖动大小
    resize: false,
    //禁用拼写检查
    gecko_spellcheck: false
});
