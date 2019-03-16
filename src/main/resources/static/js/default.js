var footer = "<nav class='navbar navbar-default fixed-bottom justify-content-center' style='z-index:-1;'><div class='navbar-inner navbar-content-center text-center'>" +
    "<p>© 2018 Draymonder Copyright.&emsp;Powered by icloud.</p></div></nav>";

var globalConfig = {};

var userConfig = {};

/**
 * 服务器响应提示
 */
function responseTip(data) {
    layer.closeAll();
    var json = JSON.parse(data);
    if (json.success === true) {
        layer.msg("保存成功");
    } else {
        alerts("保存失败，请稍后重新尝试");
    }
}

function checkPassword(password, passwordConfirm) {
    return password === passwordConfirm;
}

$(document).ready(function () {
    // layer.load(1);
    // layer.closeAll();
    // 加载页脚
    $("#footer").html(footer);
    // $("body").append("<button onclick='changeBackgroundImage();' class='rounded-circle btn btn-light random-image' " +
    //     "style='position: fixed;width: 3rem;height: 3rem;bottom: 1rem;right: 1rem;'>" +
    //     "<span class='glyphicon glyphicon-retweet'></span></button>");
});


function setCSS() {
    for (var m = 0; m < globalConfig.css.length; m++) {
        var node = globalConfig.css[m];
        var tempElement = node.selector;
        var element = [];
        if (tempElement instanceof Array) {
            element = tempElement;
        } else {
            element = element.concat(tempElement);
        }
        var tempItem = node.style;
        var item = [];
        if (tempItem instanceof Array) {
            item = tempItem;
        } else {
            item = item.concat(tempItem);
        }
        for (var j = 0; j < element.length; j++) {
            for (var k = 0; k < item.length; k++) {
                var css = item[k].split(":");
                $(element[j]).css(css[0].trim(), rtrim(css[1].trim(), ";"));
            }
        }
    }
}