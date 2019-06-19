$(function(){
    var courseId = $("#courseId").val();
    console.log(courseId);

	//导航栏页面间跳转
   $('ul > li').each(function (index) {
       if (index == 0){
           $(this).click(function () {
           	   $("ul > li").removeClass("active");
           	   $(this).addClass("active");
               $("#wrap").show();
               $("#courseNote").hide();
               $("#courseComment").hide();
               $("#commentBox").hide();
               
           });
       } else if (index == 1) {
           $(this).click(function () {
           	   $("ul > li").removeClass("active");
               $(this).addClass("active");
               $("#wrap").hide();
               $("#courseNote").show();
               $("#courseComment").hide();
               $("#commentBox").hide();
           });
       } else if (index == 2) {
           $(this).click(function () {
           	   $("ul > li").removeClass("active");
               $(this).addClass("active");
               $("#wrap").hide();
               $("#courseNote").hide();
               $("#courseComment").show();
               $("#commentBox").show();
           });
       }
   });
   //发布评论
   $("#releaseComment").click(function () {
        var content = $("#text_comment").val();
       $.ajax({
           url: '/studycenter/addComment',
           type: 'post',
           data: {
               courseId:courseId,
               commentContent:content
           },
           success: function (data) {
               $("#text_comment").val("")
                alert(data)
           },
       });
   });
    //保存笔记
    $("#releaseNote").click(function () {
        var note = $("#text_note").val();
        $.ajax({
            url: '/studycenter/addNote',
            type: 'post',
            data: {
                courseId: courseId,
                note: note
            },
            success: function (data) {
                $("#text_note").val(note);
                alert(data)
            },
        });
    });
    //选课和退课
    $("#btn_selectcourse").click(function () {
        var val = $("#btn_selectcourse").text();
        if (val == "选课"){
            alert("选课成功！")
            $("#btn_selectcourse").text("退课");
        } else if (val == "退课"){
            alert("退课成功！")
            $("#btn_selectcourse").text("选课");
        }
        /*var val = $("#btn_selectcourse").val();
        var url = '';
        if ("选课" == val){
            url = "/studycenter/addCourse";
        }
        if ("退课" == val){
            url = "/studycenter/removeCourse";
        }
        $.ajax({
            url: url,
            type: 'post',
            async: false,
            data: {
                courseId: courseId
            },
            success: function (data) {
                alert(data);
                if (val == "选课"){
                    $("#btn_selectcourse").val("退课");
                }
                if (val == "退课"){
                    $("#btn_selectcourse").val("选课");
                }
            },
        });*/
    });
    //获取评论信息
    $.ajax({
        url: '/studycenter/getViews',
        type: 'get',
        data: {
            courseId: courseId,
            pageNo: 1
        },
        success: function (data) {
            console.log(data)
            var arr = data.list;
            for (var i = 0; i < arr.length; i++) {
                $("#courseComment").append("<div class='comment' >\n" +
                    "\t\t\t\t  <a href='#' class='avatar'>\n" +
                    "\t\t\t\t    <i class='icon-user icon-2x'></i>\n" +
                    "\t\t\t\t  </a>\n" +
                    "\t\t\t\t  <div class='content'>\n" +
                    "\t\t\t\t    <div class='pull-right text-muted' >" + arr[i].reviewtime + "</div>\n" +
                    "\t\t\t\t    <div><a href='#'>用户" + i + "</a></div>\n" +
                    "\t\t\t\t    <div class='text' >" + arr[i].review + "</div>\n" +
                    "\t\t\t\t    <div class='actions'>\n" +
                    "\t\t\t\t      <a href='#'>回复</a>\n" +
                    "\t\t\t\t      <a href='#'>编辑</a>\n" +
                    "\t\t\t\t      <a href='#'>删除</a>\n" +
                    "\t\t\t\t    </div>\n" +
                    "\t\t\t\t  </div>\n" +
                    "\t\t\t\t</div>\n"
                )
            }
            $("#courseComment").append("<ul class='pager'>" +
                "<li><a href='#'>首页</a></li>" +
                "<li><a href='#'>上一页</a></li>" +
                "<li><a href='#'>下一页</a></li>" +
                "<li><a href='#'>尾页</a></li>" +
                "</ul>")
        }
    })

    /*var pageNo = 1;
    $(".pager > li").each(function (index) {
        if (index == 0){//首页
            $(this).click(function () {
                $.ajax({
                    url: 'studycenter/getViews',
                    type: 'get',
                    data: {
                        courseId: 1001,
                        pageNo: 1
                    },
                    success: function (data) {
                        console.log(data)
                        var arr = data.list;
                        for (var i = 0; i < arr.length; i++) {
                            $("#courseComment").append("<div class='comment' >\n" +
                                "\t\t\t\t  <a href='###' class='avatar'>\n" +
                                "\t\t\t\t    <i class='icon-user icon-2x'></i>\n" +
                                "\t\t\t\t  </a>\n" +
                                "\t\t\t\t  <div class='content'>\n" +
                                "\t\t\t\t    <div class='pull-right text-muted' >"+ arr[i].reviewtime +"</div>\n" +
                                "\t\t\t\t    <div><a href=''###'>用户"+ i +"</a></div>\n" +
                                "\t\t\t\t    <div class='text' >"+ arr[i].review +"</div>\n" +
                                "\t\t\t\t    <div class='actions'>\n" +
                                "\t\t\t\t      <a href='##'>回复</a>\n" +
                                "\t\t\t\t      <a href='##'>编辑</a>\n" +
                                "\t\t\t\t      <a href='##'>删除</a>\n" +
                                "\t\t\t\t    </div>\n" +
                                "\t\t\t\t  </div>\n" +
                                "\t\t\t\t</div>\n"
                                )
                        }
                        $("#courseComment").append("<ul class='pager'>" +
                            "<li><a href='#'>首页</a></li>" +
                            "<li><a href='#'>上一页</a></li>" +
                            "<li><a href='#'>下一页</a></li>" +
                            "<li><a href='#'>尾页</a></li>" +
                            "</ul>")
                    }
                })
            })
        }*/ /*else if (index == 1){//上一页
            $(this).click(function () {
                $.ajax({
                    url: '/getViews',
                    type: 'get',
                    data: {
                        courseId: courseId
                    },
                    success: function (data) {
                        console.log(data)
                    }
                })
            })
        } else if (index == 2){//下一页
            $(this).click(function () {
                $.ajax({
                    url: '/getViews',
                    type: 'get',
                    data: {
                        courseId: courseId
                    },
                    success: function (data) {
                        console.log(data)
                    }
                })
            })
        } else if (index == 3){//尾页
            $(this).click(function () {
                $.ajax({
                    url: '/getViews',
                    type: 'get',
                    data: {
                        courseId: courseId
                    },
                    success: function (data) {
                        console.log(data)
                    }
                })
            })
        }*/
    //})

})
