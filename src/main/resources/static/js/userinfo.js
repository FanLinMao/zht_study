/*判断用户类别*/
function tryapitest(){
    $.ajax({
        url:"/userinfo/selectuser",
        type:"get",
        dataType:"json",
        success:function(data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var role= "普通用户";
                if (data[i].role==1){
                    role = "管理员";
                }
                var userID = data[i].userID;
                console.log(userID);
                $("#usertable").after("<tr><th><input type=\"checkbox\" value='"+userID+"'/></th><td>" +data[i].userID+"</td><td>"+ data[i].userName + "</td><td>" + data[i].phone +"</td><td>"+data[i].gender+"</td><td>"+data[i].birth+"</td><td>"+role+"</td></tr>")
            }
        }

    })
}
/*查找指定用户*/
function find_user(){
    var userID = $("#userID").val();
    if (userID == ""){
        alert("请输入要查询的账号！")
    }else{
    //alert(userID);
    $.ajax({
        url:'/userinfo/finduser',
        type:"post",
        data:{"userID":userID},
        success:function(data) {
            alert("查找成功");
            var role= "普通用户";
            if (data.role==1){
                role = "管理员";
            }
            var userID = data.userID;
            console.log(userID);
            $("#table-title").after("<tr><td><input type=\"checkbox\" style='color: red' value='"+userID+"'/></td><td>" +data.userID+"</td><td>"+ data.userName + "</td><td>" + data.phone +"</td><td>"+data.gender+"</td><td>"+data.birth+"</td><td>"+role+"</td></tr>")
        },
        error: function() {
            alert("该用户不存在！");
        }
    })
    }
}
/*删除指定用户*/
function delete_user(){
    var userID = $("input[type='checkbox']:checked").val();
    if (userID == null){
        alert("请选择要删除的账号")
    }else{
    console.log(userID);
    alert("确定删除？");
    $.ajax({
        url:'/userinfo/deleteuser',
        type:"post",
        data:{"userID":userID},
        success:function(data) {
            alert("删除成功");
        },
        error: function() {
            alert("删除失败");
        }
    })
    }

}
/*添加用户信息*/
function add_user(){
    var userName = $("#userName").val();
    var password = $("#password").val();
    //var radio =  document.getElementsByName("gender3");
    var gender = "男";
    var birth = $("#birth").val();
    var phone = $("#phone").val();
    var userjson={userName:userName,password:password,gender:gender,birth:birth,phone:phone}
    console.log(userjson);
    $.ajax({
        url:'/userinfo/adduser',
        type:"post",
        data:userjson,
        success:function(data) {
            alert("添加成功");
            alert(data);
        },
        error: function() {
            alert("添加失败");
        }
    })
}
/*更新用户信息显示*/
function update_find(){
    var userID = $("input[type='checkbox']:checked").val();
    alert("需要更新的数据时"+userID)
    $.ajax({
        url:'/userinfo/finduser',
        type:"post",
        data:{"userID":userID},
        success:function(data) {
            alert("更新-查找成功");
            var role= "普通用户";
            if (data.role==1){
                role = "管理员";
            }
            var userID = data.userID;
            console.log(userID);
            $("#update-user").after("<tr><td>用户ID<input id='update-ID' value='"+userID+"'</td></tr>"
                +"<tr><td>用户名<input  id='update-name' value='"+data.userName+"'</td></tr><tr><td>"
                +"<tr><td>用户密码<input type='password' id='update-paw' value='"+data.password+"'</td></tr><tr><td>"
                +"<tr><td>手机号<input id='update-phone' value='"+data.phone+"'</td></tr><tr><td>"
                + "<tr><td>用户类型<input id='update-role' value='"+data.role+"'</td></tr><tr><td>"
                +"<tr><td>性别<input id='update-gender' value='"+data.gender+"'</td></tr><tr><td>"
                +"<tr><td>出生日期<input id='update-birth' value='"+data.birth+"'</td></tr><tr><td>")
            /* 点击按钮打开对话框 */
            document.getElementById('inputbox2').style.display = 'block';
            },
        error: function() {
            alert("更新--该用户不存在！");
        }
    })
}

/*更新用户信息*/
function update_user(){
    var userID = $("#update-ID").val();
    var userName = $("#update-name").val();
    var password = $("#update-paw").val();
    var gender = $("#update-gender").val();
    var birth = $("#update-birth").val();
    var phone = $("#update-phone").val();
    console.log(userName);
    var userjson={userID:userID,userName:userName,password:password,gender:gender,birth:birth,phone:phone}
    console.log(userjson);
    //alert(userID);
    $.ajax({
        url:'/userinfo/updateuser',
        type:"post",
        data:userjson,
        success:function(data) {
            alert(data);
            alert("更新成功");
            console.log(data);
        },
        error: function() {
            alert("更新失败");
        }
    })
}

//点击按钮出现另一个框
//添加
function change2(){
    document.getElementById('inputbox2').style.display='none';  /* 点击按钮打开/关闭 对话框 */
}
//添加
function change1(n){
    document.getElementById('inputbox1').style.display=n?'block':'none';  /* 点击按钮打开/关闭 对话框 */
}






