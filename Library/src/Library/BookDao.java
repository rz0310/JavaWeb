package Library;

import java.sql.SQLException;
import java.util.Date;

public interface BookDao {
//    增加
    void insertBook();
//    删除
    void deleteBook();
//    查找
    void queryBook() throws SQLException;
//    借阅
    void borrowBook() throws SQLException;
//    归还
    void returnBook();
//    查看所有
    void queryAll() throws SQLException;
}
