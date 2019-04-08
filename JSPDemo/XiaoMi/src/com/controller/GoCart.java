package com.controller;

import com.bean.Carts;
import com.bean.Goods;
import com.dao.CartDao;
import com.dao.GoodsDao;
import com.imp.CartImp;
import com.imp.GoodsImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "GoCart",urlPatterns = "/GoCart")
public class GoCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        获取session，判断session中是否有goodsHashMap，没有新创建，否则不创建。
        HttpSession session = request.getSession();
        HashMap<Carts, Integer> goodsHashMap = (HashMap<Carts, Integer>) session.getAttribute("goodsHashMap");
        if(goodsHashMap == null){
//        创建map用来保存购物车中的货物
            goodsHashMap = new HashMap<>();
        }
        int goodsNum = Integer.valueOf(request.getParameter("goodsNum"));
//        Integer goodsNum = (Integer) session.getAttribute("goodsNum");//购物车加入货物的初始数量为1
//        if(goodsNum == null){
//
//        }
//        获取request参数
        String goodsName = request.getParameter("goodsName");
        String goodsVersion = request.getParameter("goodsVersion");
        String nowPage = request.getParameter("nowPage");
        GoodsDao goodsDao = new GoodsImp();
        int goodsId = goodsDao.getIdByNameAndVersion(goodsName, goodsVersion);//根据货物名称和版本查询id
        Goods goods = goodsDao.getGoodsById(goodsId);//根据id获取该货物的所有购物车中需要的信息，保存到Goods对象
//        将购物车中数据持久化，插入数据库
        CartDao cartDao = new CartImp();
        Carts carts = new Carts();
        carts.setId(goods.getId());
        carts.setName(goods.getName());
        carts.setVersion(goods.getVersion());
        carts.setColor(goods.getColor());
        carts.setNum(goodsNum);
        carts.setPrice(goods.getPrice());
        carts.setImg(goods.getImg());
        Boolean aBoolean = false;
        if(!goodsHashMap.containsKey(carts)){
            goodsHashMap.put(carts,goods.getNum());
            aBoolean = cartDao.insert(carts);
        }else{
            goodsNum++;
            carts.setNum(goodsNum);
            aBoolean = cartDao.update(goodsId,goodsNum);
            goodsHashMap.remove(carts);
            goodsHashMap.put(carts, goodsNum);
        }
        if (aBoolean){
//        把集合保存到session中
            session.setAttribute("goodsHashMap",goodsHashMap);
            session.setAttribute("goodsNum",goodsNum);
            request.getRequestDispatcher("gouwuche.jsp").forward(request,response);//跳转
        }else{
            request.getRequestDispatcher("adderror.jsp").forward(request,response);
        }
    }
}
