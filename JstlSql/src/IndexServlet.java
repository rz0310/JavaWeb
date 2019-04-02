import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        使用数据库连接的connection进行数据库的操作
        try {
//            创建Context上下文对象
            Context context = new InitialContext();
//            根据数据使用的数据类型，加上数据源的名称，获取数据源
            DataSource lookup = (DataSource) context.lookup("java:/comp/env/jdbc/mysql");
//            根据数据源获取数据库连接
            Connection conn = lookup.getConnection();
            String sql = "select * from user where username=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "renjing");
            ResultSet rs = ps.executeQuery();
            int id = 0;
            String username = null;
            String password = null;
            while (rs.next()) {
                id = rs.getInt("id");
                username = rs.getString("username");
                password = rs.getString("password");
            }
            System.out.println(id);
            System.out.println(username);
            System.out.println(password);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
