// 创建Ajax对象函数

function getAjax() {
    var xmlHttp;

    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
    }
    return xmlHttp;
}

var overNum = 0;

// 使用Ajax
function user(li) {
    if (overNum < 1) {
        var xmlHttp = getAjax();
        var as = li.getElementsByTagName("a");
        var type1 = as[0].innerText;
        var type2 = as[1].innerText;
        var url = "showGoods?type1=" + type1 + "&type2=" + type2;
        xmlHttp.open("get", url, true);
        xmlHttp.send();
        xmlHttp.onreadystatechange = function f() {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                var divs = li.getElementsByTagName("div");
                var responseText = xmlHttp.responseText;
                var strings = responseText.split("+--+");
                divs[1].innerHTML = strings[0];
                divs[1].nextElementSibling.innerHTML = strings[1];
            }
        }
    }
    overNum = overNum + 1;
}

function unuser(li) {
    overNum = 0;
}

function loadindexdownimg() {
    var xmlHttp = getAjax();
    xmlHttp.open("get", "showIndexDownImg", true);
    xmlHttp.send();
    xmlHttp.onreadystatechange = function f() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var div = document.getElementById("indexdown");
            var s = div.innerHTML + xmlHttp.responseText;
            div.innerHTML = s;
        }
    }
}

function loadidleimg() {
    var xmlHttp = getAjax();
    xmlHttp.open("get", "showIdleGoods", true);
    xmlHttp.send();
    xmlHttp.onreadystatechange = function f() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var div = document.getElementById("mainCenter");
            div.innerHTML = xmlHttp.responseText;
        }
    }
}

function loadlastimg() {
    var xmlHttp = getAjax();
    xmlHttp.open("get", "showBottomImg", true);
    xmlHttp.send();
    xmlHttp.onreadystatechange = function f() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var div1 = document.getElementById("content");
            var div2 = document.getElementById("content2");
            var strings = xmlHttp.responseText.split("+--+");
            div1.innerHTML = strings[0] + "<div class = 'clear'></div>";
            div2.innerHTML = strings[1];
        }
    }
}

window.onload = function () {
    loadidleimg();
    loadindexdownimg();
    loadlastimg();
};