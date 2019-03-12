package com.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imp.GoodsImp;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.bean.Goods;
import com.dao.GoodsDao;

/**
 * @desc 商品添加
 * @author liangqi
 *
 */
@WebServlet("/ProviderAddServlet")
public class ProviderAddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Goods goods = new Goods();
		try {
			// 1.创建获取文件的工厂类
			FileItemFactory df = new DiskFileItemFactory();
			// 2.创建操作类
			ServletFileUpload up = new ServletFileUpload(df);
			// 3.获取请求的表单数据。每个数据封装成一个对象。存放到List集合中。
			List<FileItem> list = up.parseRequest(request);

			// 4.遍历获取每个表单数据
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					// // 5.是(普通表单元素)
					// // 5.1 表单元素的name值
					String fieldName = fileItem.getFieldName();
					// 5.2 表单元素用户输入的value值
					String fiedValue = fileItem.getString("utf-8");
					
					switch(fieldName) {
						case "name":goods.setName(fiedValue);break;
						case "img":goods.setImg(fiedValue);break;
						case "price":goods.setPrice(Double.valueOf(fiedValue));break;
						case "num":goods.setNum(Integer.parseInt(fiedValue));break;
						case "desc":goods.setDesc(fiedValue);break;
						case "version":goods.setVersion(fiedValue);break;
						case "color":goods.setColor(fiedValue);break;
						case "type":goods.setType(Integer.parseInt(fiedValue));break;
					}
				} else {
					// 6. 是(上传的表单元素)
					// 上传的文件的文件名
					String fileName = fileItem.getName();
					//设置goods属性
					goods.setImg("upload/"+fileName);

					// 获取 webapps中 相对路径为/upload 的全路径.
					String realPath = this.getServletContext().getRealPath("/upload");
					// 上传文件到 服务器中。
					InputStream input = fileItem.getInputStream();
					// 设置输出流。指定输出字节数据到指定的url。
					FileOutputStream output = new FileOutputStream(realPath + "//" + fileName);
					// 将指定流 写入到 指定的url中。
					IOUtils.copy(input, output);
					
					// 关闭资源
					output.close();
					input.close();
					
					
				}
			}
		} catch (FileUploadException | SecurityException | IllegalArgumentException  e) {
			e.printStackTrace();
		}

		// 进行添加操作
		GoodsDao goodsdao = new GoodsImp();
		boolean bool_add = goodsdao.addGoods(goods);

		if (bool_add == true) {
			request.getRequestDispatcher("ProviderListServlet?diPage=1").forward(request, response);
		} else {
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("providerAdd.jsp").forward(request, response);
		}
	}

}
