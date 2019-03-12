function changeInfo(a) {
    var span = a.parentElement.previousElementSibling;
    var innerHTML = span.innerHTML;
    span.innerHTML = "<input type='text' placeholder='"+innerHTML+"' class='change' style='width: 100px;height: 30px'>";
    var span2 = a.parentElement;
    span2.innerHTML = "<a href='' style='margin-right: 10px' onmouseover='save(this)' onmouseout='mouseout()'>保存</a><a href='#' onclick='outchange(this)'>退出编辑</a>";
}


function outchange(a) {
    var span2 = a.parentElement;
    span2.innerHTML = "<a href='' onclick='changeInfo(this)'>编辑</a>";
    var span = span2.previousElementSibling;
    var input = span.firstChild;
    span.innerHTML = input.placeholder;
}


var number = 0;
function save(a) {
    if (number<1) {
        var span = a.parentElement.previousElementSibling;
        var span3 = span.previousElementSibling;
        var input = a.parentElement.previousElementSibling.firstElementChild;
        var value = input.value;
        var href = "UpdateSelfInfo?item=" + span3.id + "&value=" + value;
        a.href = href;
    }
    number = number+1;
}

// 鼠标离开事件
function mouseout() {
    number = 0;
}