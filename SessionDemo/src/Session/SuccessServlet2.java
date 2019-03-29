package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success2")
public class SuccessServlet2 extends HttpServlet {
    public SuccessServlet2() {
        System.out.println("构造2");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("第三个");
        System.out.println("Post2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get2");
        doPost(request,response);
    }
    @Override
    public void destroy() {
        System.out.println("销毁2");
    }
}
