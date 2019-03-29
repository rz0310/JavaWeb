package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    public SuccessServlet() {
        System.out.println("构造1");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get1");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("第二个");
        System.out.println("Post1");
        String name = (String) req.getAttribute("name");
        System.out.println("Session中的name="+name);
        req.getRequestDispatcher("success2").forward(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("销毁1");
    }
}
