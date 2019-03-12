window.onload=function () {
    var num = document.getElementById("num");
    changeGoodsNumber(num);
}
function changeGoodsNumber(num) {
    var number = num.value;
    var price = num.parentNode.previousElementSibling.innerText;
    price.substr(0,length-1);
    var totalPrice = (price*number).toFixed(1);
    num.parentNode.nextElementSibling.firstElementChild.innerText = totalPrice;
    update();
}
function check(check) {
    var price = check.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.firstElementChild.innerText;//当前选中商品的价格
    var num = check.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.firstElementChild.value;//当前选中商品的数量
    num = parseInt(num);
    price = parseInt(price)*parseInt(num);
    document.getElementById("choose").innerText = num;
    document.getElementById("totalPrice").innerText = price.toFixed(2)+"元";
    //取消选中后
    if(check.checked == false){
        document.getElementById("choose").innerText = 0;
        document.getElementById("totalPrice").innerText = 0;
    }
    update();
}
function update() {
    var checks = document.getElementsByName("check");
    var nums = 0;
    var totalPrice = 0;
    var count = 0;
    var totalNum= 0;
    count = parseInt(count);
    for (var i = 0; i < checks.length; i++) {
        if(checks[i].checked  == true){
            var num = checks[i].parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.firstElementChild.value;
            var xiaojiPrice = checks[i].parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.firstElementChild.innerText;
            nums = parseInt(nums)+parseInt(num);
            totalPrice = parseInt(totalPrice)+parseInt(xiaojiPrice);
            count = count+1;
        }
        var goodsNum = checks[i].parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.firstElementChild.value;
        totalNum = parseInt(totalNum) + parseInt(goodsNum);
    }
    document.getElementById("choose").innerText = nums;
    document.getElementById("totalPrice").innerText = totalPrice.toFixed(2)+"元";
    document.getElementById("total").innerText = totalNum;
    if(count == checks.length){
        document.getElementById("quanxuan").checked = true;
    }else{
        document.getElementById("quanxuan").checked = false;
    }
}

function checkAll(all) {
    if(all.checked == true){//全选框被选中
        selectAll();
    }else {
        checkNo();
    }
}
function selectAll() {
    var check = document.getElementsByName("check");//全选框
    var nums = document.getElementsByName("changeGoodsNum");//单选框结点集合
    var sum = 0;//商品总数量
    var totalPrice = 0;//总价
    //遍历所有单选框,使得选中状态一致
    for (var i = 0; i < check.length; i++) {
        check[i].checked = true;
    }
    //遍历单选框，获取每个单选框选中的商品数量
    for (var i = 0; i < nums.length; i++) {
        var price = nums[i].parentElement.nextElementSibling.firstElementChild.textContent;//根据单选框，获取对应的商品的单价
        totalPrice = parseInt(totalPrice)+parseInt(price);//根据单价计算总价
        var num = nums[i].value;//根据单选框，获取对应的商品的数量
        sum = parseInt(sum)+parseInt(num);//根据每隔商品的数量计算选中的总数量
    }
    // document.getElementById("total").innerText = sum;商品总数
    document.getElementById("choose").innerText = sum;//更新选中的商品的数量
    document.getElementById("totalPrice").innerText = totalPrice.toFixed(2)+"元";//更新总价
}
function checkNo() {
    var check = document.getElementsByName("check");//全选框
    //遍历所有单选框,使得选中状态一致
    for (var i = 0; i < check.length; i++) {
        check[i].checked = false;
    }
    document.getElementById("choose").innerText = 0;//更新选中的商品的数量
    document.getElementById("totalPrice").innerText = 0+"元";//更新总价
}