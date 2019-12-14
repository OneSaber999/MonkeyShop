function change(img) {
    img.src = "getCode?"+new Date().getTime();
}

var flag = true; //标记位
function FocusItem(obj) {
    if ($(obj).attr('name') == 'veryCode'){

        $(obj).next().next().html('').removeClass('error');

    } else {

        $(obj).next().html('').removeClass('error');

    }
}
function CheckItem(obj) {

    var msgBox = $(obj).next();
    switch ($(obj).attr('name')) {
        case  'userName':
             var url;
            if (obj.value == ''){
                msgBox.html('用户名不能为空');
                msgBox.addClass('error');
                flag = false;
            }else{
                url = "usernamecheck?name=" + encodeURI($(obj).val()) + "&" + new Date().getTime();
                // "false" "true"

                $.get(url,function (data) {

                    if (data == "false"){
                        msgBox.html('用户名已存在!');
                        msgBox.addClass('error');
                        flag = false;

                    } else {
                        msgBox.html().removeClass('error');
                    }
                });
            }
            break;
        case  'password':
            if (obj.value == ''){
                msgBox.html('密码不能为空');
                msgBox.addClass('error');
                flag = false;

            }else {
                flag = true;
            }
            break;
        case  'rePassword':
            if (obj.value == ''){
                msgBox.html('确认密码不能为空');
                msgBox.addClass('error');
                flag = false;

            }else if ($(obj).val() != $('input[name="password"]').val()) {
                msgBox.html('两次输入的密码不一致');
                msgBox.addClass('error');
                flag = false;

            }else{
                flag = true;
            }
            break;
        case  'veryCode':
            var numShow = $(obj).next().next();
            var url;
            if (obj.value == '') {
                numShow.html('验证码不能为空');
                numShow.addClass('error');
                flag = false;

            } else {
                url = "usernumcheck?num=" + encodeURI($(obj).val()) + "&" + new Date().getTime();
                $.get(url, function (numdata) {
                    if (numdata == 'false') {
                        numShow.html('验证码输入错误');
                        numShow.addClass('error');
                        flag = false;

                    } else {
                        numShow.html('').removeClass('error');
                        flag = true;
                    }
                });
            }
            break;

    }

}

function checkForm(frm){
    let els = frm.getElementsByTagName('input');

    //onblur 带有这个属性的需要验证
    for (let i = 0; i < els.length; i++) {
        if (els[i] != null){
            if (els[i].getAttribute("onblur")){
                CheckItem(els[i]);
            }
        }
    }

    return flag;

}