

function getForm() {
    var username = $("#username").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();
    var name = $("#name").val();
    var sex = $("#sex").val();
    var age = $("#age").val();
    var date = $("#date").val();

    if (password != password2) {
        alert("两次输入密码不一致");
        return;
    }

    var array = [{
        "username":username,
        "password":password,
        "name":name,
        "sex":sex,
        "age":age,
        "date":date
    }];

    if (username == "" || password == "" || name == "") {
        alert("请填写必要信息！");
        return;
    }

    return JSON.stringify(array);
}

$(document).ready(function(){
    $("#btn_reg").click(function(){
        var data = getForm();
        $.ajax({
            url:"Register",
            data:data,
            type:"post",
            dataType:"json",
            success:"ok!"
        })
    });
});