//控制选中的商品版本以及更新响应的价格
function updatePrice(goodsVersion) {
    var div1 = goodsVersion.parentElement.childNodes[0];
    var div2 = goodsVersion.parentElement.childNodes[1];
    if(div1 == goodsVersion&&goodsVersion.firstChild.childNodes[0].style.color != "rgb(255, 103, 0)"){
        goodsVersion.firstChild.childNodes[0].style.color = "#ff6700";
        goodsVersion.firstChild.childNodes[1].style.color = "#ff6700";
        goodsVersion.style.borderColor = "#ff6700";
        div2.firstChild.childNodes[1].style.color = "#000";
        div2.firstChild.childNodes[0].style.color = "#000";
        div2.style.borderColor = "#bbb";
    }else if(div1 == goodsVersion&&goodsVersion.firstChild.childNodes[0].style.color == "rgb(255, 103, 0)"){
        goodsVersion.firstChild.childNodes[0].style.color = "#000";
        goodsVersion.firstChild.childNodes[1].style.color = "#000";
        goodsVersion.style.borderColor = "#bbb";
    }
    if(div2 == goodsVersion&&goodsVersion.firstChild.childNodes[1].style.color != "rgb(255, 103, 0)"){
        goodsVersion.firstChild.childNodes[0].style.color = "#ff6700";
        goodsVersion.firstChild.childNodes[1].style.color = "#ff6700";
        goodsVersion.style.borderColor = "#ff6700";
        div1.firstChild.childNodes[1].style.color = "#000";
        div1.firstChild.childNodes[0].style.color = "#000";
        div1.style.borderColor = "#bbb";
    }else if(div2 == goodsVersion&&goodsVersion.firstChild.childNodes[1].style.color == "rgb(255, 103, 0)"){
        goodsVersion.firstChild.childNodes[0].style.color = "#000";
        goodsVersion.firstChild.childNodes[1].style.color = "#000";
        goodsVersion.style.borderColor = "#bbb";
    }
    var goodsInfo = document.getElementById("showGoodsInfo");
    xiaoji(goodsInfo);
}
//控制选中的商品颜色
function updateColor(goodsColor) {
    if(goodsColor.firstChild.childNodes[0].style.color == "rgb(255, 103, 0)"){
        goodsColor.firstChild.childNodes[0].style.color = "#000";
        goodsColor.firstChild.childNodes[1].style.color = "#000";
        goodsColor.style.borderColor = "#bbb";
    }else{
        goodsColor.firstChild.childNodes[0].style.color = "#ff6700";
        goodsColor.firstChild.childNodes[1].style.color = "#ff6700";
        goodsColor.style.borderColor = "#ff6700";
    }
    var goodsInfo = document.getElementById("showGoodsInfo");
    xiaoji(goodsInfo);
}
function xiaoji(goodsInfo) {
    goodsInfo.childNodes
    var div1 = goodsInfo.childNodes[0].childNodes[0].childNodes[0].childNodes[0];
    var div2 = goodsInfo.childNodes[0].childNodes[1].childNodes[0].childNodes[0];
    var div3 = goodsInfo.childNodes[2].childNodes[0].childNodes[0].childNodes[0];
    if(div1.style.color == "rgb(255, 103, 0)"&&div3.style.color == "rgb(255, 103, 0)"){
        var goodsName = document.getElementById("goodsName").textContent;
        var goodsVersion=goodsInfo.childNodes[0].childNodes[0].childNodes[0].childNodes[0].textContent;
        // var goodsVersion = document.getElementById("goodsVersion").textContent;//货物版本
        var goodsColor = document.getElementById("goodsColor").textContent;
        var goodsPrice = goodsInfo.childNodes[0].childNodes[0].childNodes[0].childNodes[1].textContent;
        document.getElementById("xiaoji").childNodes[0].childNodes[0].innerText = goodsName+" "+goodsVersion+" "+goodsColor;
        document.getElementById("xiaoji").childNodes[0].childNodes[1].innerText = goodsPrice;//小计的价格
        document.getElementById("goodPrice").innerText = goodsPrice;
        document.getElementById("totalPrice").innerText = "总计："+goodsPrice;
        document.getElementById("cart").setAttribute("href","GoCart?goodsName="+goodsName+"&goodsNum="+1+"&goodsVersion="+goodsVersion+"&nowPage=1");
    }else if(div2.style.color == "rgb(255, 103, 0)"&&div3.style.color == "rgb(255, 103, 0)"){
        var goodsName = document.getElementById("goodsName").textContent;
        var goodsVersion=goodsInfo.childNodes[0].childNodes[1].childNodes[0].childNodes[0].textContent;
        var goodsColor = document.getElementById("goodsColor").textContent;
        var goodsPrice = goodsInfo.childNodes[0].childNodes[1].childNodes[0].childNodes[1].textContent;
        document.getElementById("xiaoji").childNodes[0].childNodes[0].innerText = goodsName+" "+goodsVersion+" "+goodsColor;
        document.getElementById("xiaoji").childNodes[0].childNodes[1].innerText = goodsPrice;//小计的价格
        document.getElementById("goodPrice").innerText = goodsPrice;
        document.getElementById("totalPrice").innerText = "总计："+goodsPrice;
        var goodsNum = 1;
        document.getElementById("cart").setAttribute("href","GoCart?goodsName="+goodsName+"&goodsNum="+goodsNum+"&goodsVersion="+goodsVersion+"&nowPage=1");
    }else{
        document.getElementById("xiaoji").childNodes[0].childNodes[0].innerText = "";
        document.getElementById("xiaoji").childNodes[0].childNodes[1].innerText = "";
        document.getElementById("goodPrice").innerText = "";
        document.getElementById("totalPrice").innerText = "总计：0.00元";
        document.getElementById("cart").setAttribute("href","GoCart?goodsName="+goodsName+"&goodsNum="+1+"&goodsVersion="+goodsVersion+"&nowPage=1");
    }
}