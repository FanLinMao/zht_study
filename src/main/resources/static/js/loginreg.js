//注册-点击时出现提示——username
$('[data-toggle="name"]').tooltip({
    placement: 'right',
    tipClass: 'tooltip-primary',
    title:'不得以特殊符号开头！'
});

//注册-点击时出现提示——password
$('[data-toggle="password"]').tooltip({
    placement: 'right',
    tipClass: 'tooltip-primary',
    title:'由英文字母和数字组成的4-10位字符'
});
//注册-点击时出现提示——password2
$('[data-toggle="repwa"]').tooltip({
    placement: 'right',
    tipClass: 'tooltip-primary',
    title:'请再次输入密码'
});

//注册-点击时出现提示——date
$('[data-toggle="date"]').tooltip({
    placement: 'right',
    tipClass: 'tooltip-primary',
    title:'选择或者输入一个日期：yyyy-MM-dd！'
});

//注册-点击时出现提示——phone
$('[data-toggle="phone"]').tooltip({
    placement: 'right',
    tipClass: 'tooltip-primary',
    title:'以1开头，二位为3,4,5,7,8,9的11位手机号！'
});

// 仅选择日期
$(".form-date").datetimepicker(
    {
        language:  "zh-CN",
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: "yyyy-mm-dd"
    });

//登录-验证输入信息
function checklogin(){
    var phone = $("#phone").val();
    var password = $("#password").val();
    var authcode = $("#authcode").val();
    if (phone == ""){
        alert("手机号不能为空");
        //username.focus();
        return false;
    }
    else if (password==""){
        alert("密码不能为空");
        //password.focus();
        return false;
    }
    else if (authcode==""){
        alert("请填写验证码");
        //authcode.focus();
        return false;
    }
    else{return true;}

}

//注册-用户名验证
function validate_name() {
    var name = $("#username").val();
    if(name == ""){
        $("#namehint").html("用户名不得为空");
        $("#namehint").css("color", "red");
        $("#xiugai").removeAttr("disabled");
        $("#button").attr("disabled","disabled");
    } else{
        $("#namehint").html("YES");
        $("#namehint").css("color", "greed");
        $("#button").removeAttr("disabled");
    }
}

//注册-密码验证1
function validate_paw() {
    var pwd = $("#password").val();
    var reg=/^[a-zA-Z0-9]{4,10}$/;
    if(pwd == ""){
        $("#pwd").html("密码不得为空");
        $("#pwd").css("color", "red");
        $("#xiugai").removeAttr("disabled");
        $("#button").attr("disabled","disabled");
    }else if(reg.test(pwd)!=false) {
        $("#pwd").html("YES");
        $("#pwd").css("color", "green");
        $("#xiugai").removeAttr("disabled");
        $("#button").removeAttr("disabled");
    }else{
        $("#pwd").html("NO");
        $("#pwd").css("color", "red");
        $("#xiugai").removeAttr("disabled");
        $("#button").attr("disabled","disabled");
    }
}

//注册-密码验证2-验证是否为空
function validate() {
    var pwd = $("#password").val();
    var pwd1 = $("#password2").val();
    <!-- 对比两次输入的密码 -->
    if(pwd == pwd1)
    {
        $("#tishi").html("两次密码相同");
        $("#tishi").css("color","green");
        $("#button").removeAttr("disabled");
    }
    else {
        $("#tishi").html("*两次密码不相同");
        $("#tishi").css("color","red")
        $("#button").attr("disabled","disabled");
    }
}

//注册-验证手机号
function validate_phone() {
    var phone =$("#phone").val();
    var myreg=/^[1][3,4,5,7,8,9][0-9]{9}$/;
    if(phone==""){
        $("#phonehint").html("*手机号不能为空");
        $("#phonehint").css("color","red")
        $("button").attr("disabled","disabled");

    }else if(!myreg.test(phone)){
        $("#phonehint").html("*手机号不存在");
        $("#phonehint").css("color","red")
        $("#button").attr("disabled","disabled");
    }
    else {
        $("#phonehint").html("YES");
        $("#phonehint").css("color","green");
        $("#button").removeAttr("disabled");
    }
}

//验证复选框的值
function checkRegister(){
    var radios = document.getElementsByName("gender");
    var tag = false;
    var val;
    for(radio in radios) {
        if(radios[radio].checked) {
            tag = true;
            val = radios[radio].value;
            break;
        }
    }
    if(tag) {
        //alert(val);
        return  true;
    }
    else {
        alert("请选择。。。。");
        return  false;
    }
    return  true;

}