$(function(){
    var courseId = $("#courseId").val();

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
        var content = $("#text_comment").text();
       $.ajax({
           url: '/studycenter/addComment',
           type: 'post',
           data: {courseId:courseId,
               commentContent:content
           },
           success: function (data) {

           },
       });
   });
    //保存笔记
    $("#releaseNote").click(function () {
        var note = $("#text_note").text();
        $.ajax({
            url: '/studycenter/addNote',
            type: 'post',
            data: {
                courseId: "1003",
                note: note
            },
            success: function (data) {
                alert(data)
            },
        });
    });
    //选课
    $("#btn_selectcourse").click(function () {
        $.ajax({
            url: '/studycenter/addCourse',
            type: 'post',
            data: {
                courseId: courseId
            },
            success: function (data) {

            },
        });
    });

})
