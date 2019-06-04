$(function(){
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
})
