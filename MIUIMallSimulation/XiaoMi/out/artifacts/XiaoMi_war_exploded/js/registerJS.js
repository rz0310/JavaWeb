/*  function panduan(){
     var username = regist.username.value;
     var password = regist.password.value;
     var repassword = regist.repassword.value;
     var tel = regist.tel.value;
     var yanzhengma = regist.yanzhengma.value;

     if(username==""){
         document.getElementById("space1").innerHTML="<font color='red'>*</font>";

         return false;
     }
     if(password==""){
         document.getElementById("space2").innerHTML="<font color='red'>*</font>";
         return false;
     }

     if(repassword==""){
         document.getElementById("space3").innerHTML="<font color='red'>*</font>";
         return false;
     }
     if(password!=repassword){
         document.getElementById("space3").innerHTML="<font color='red'>*</font>";
         return false;
     }
     if(tel==""){
         document.getElementById("space4").innerHTML="<font color='red'>*</font>";
         return false;
     }
     if(yanzhengma==""){
         document.getElementById("space5").innerHTML="<font color='red'>*</font>";
         return false;
     }
 }
  */
function onblur1() {
    var username = regist.username.value;
    if (username == "") {
        document.getElementById("space1").innerHTML = "<font color='red'>*请输入账号</font>";
        return false;
    }
    if (username != "") {
        document.getElementById("space1").innerHTML = "";
    }
}

function onblur2() {
    var password = regist.password.value;
    if (password == "") {
        document.getElementById("space2").innerHTML = "<font color='red'>*请输入密码</font>";
        return false;
    }
    if (password != "") {
        document.getElementById("space2").innerHTML = "";
    }
}

function onblur3() {
    var repassword = regist.repassword.value;
    if (repassword == "") {
        document.getElementById("space3").innerHTML = "<font color='red'>*请输入确认密码</font>";
        return false;
    }
    if (repassword != "") {
        document.getElementById("space3").innerHTML = "";
    }
}

function onblur4() {
    var tel = regist.tel.value;
    if (tel == "") {
        document.getElementById("space4").innerHTML = "<font color='red'>*请输入手机号</font>";
        return false;
    }
    if (tel != "") {
        document.getElementById("space4").innerHTML = "";
    }
}

function onblur5() {
    var yanzhengma = regist.yanzhengma.value;
    if (yanzhengma == "") {
        document.getElementById("space5").innerHTML = "<font color='red'>*请输入验证码</font>";
        return false;
    }
    if (yanzhengma != "") {
        document.getElementById("space5").innerHTML = "";
    }
}

function onfocus1() {
    var username = regist.username.value;
    if ((/[\u4e00-\u9fa5]+/).test(username)) {
        document.getElementById("space1").innerHTML = "<font color='red'>*请不要输入汉字</font>";
    }
}

function yanzheng() {
    //获取账号和密码
    var username = fm.username.value;
    var userpassword = fm.password.value;
    var yanzhengma = fm.yanzhengma.value;
    if (username == "" && userpassword == "") {
        document.getElementById("space1").innerText = "账号不能为空";
        document.getElementById("space2").innerText = "密码不能为空";
        document.getElementById("error").innerText = "";
        return false;
    }
    if (username == "" && userpassword != "") {
        document.getElementById("space2").innerText = "";
        document.getElementById("space1").innerText = "账号不能为空";
        document.getElementById("error").innerText = "";
        return false;
    }
    if (username != "" && userpassword == "") {
        document.getElementById("space1").innerText = "";
        document.getElementById("space2").innerText = "密码不能为空";
        document.getElementById("error").innerText = "";
        return false;
    }
}