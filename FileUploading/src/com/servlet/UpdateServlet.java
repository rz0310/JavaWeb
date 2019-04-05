package com.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        创建文件获取工厂类
        DiskFileItemFactory dfit = new DiskFileItemFactory();
//        通过工厂创建上传文件的操作类
        ServletFileUpload sfu = new ServletFileUpload(dfit);
//        使用操作类获取form表单提交过来的所有文件（FileItem类型），保存到集合
//        request作为参数
        try {
            List<FileItem> fileItems = sfu.parseRequest(request);
//            遍历集合
            for(FileItem fileItem:fileItems){
                if(!fileItem.isFormField()){
                    String pathname = fileItem.getName();
                    HttpSession session = request.getSession();
                    session.setAttribute("pathname",pathname);
                    System.out.println(pathname);
//                    根据文件创建对应文件的输入流
                    InputStream in = fileItem.getInputStream();
//                    根据请求设置文件上传的路径
//                    String realPath = request.getServletContext().getRealPath("/file");
                    String realPath = "E:\\Idea\\FileUploading\\web\\img";
//                    创建文件输出流，指定输出路径
                    OutputStream out = new FileOutputStream(new File(realPath,pathname));
//                    使用IOUtils工具类中的方法将输入流中的内容复制到输出流
                    IOUtils.copy(in,out);
//                    关闭资源
                    out.close();
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
