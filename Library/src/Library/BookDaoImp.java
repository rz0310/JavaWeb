package Library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BookDaoImp implements BookDao{
//    插入
    @Override
    public void insertBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入图书编号：");
        int num = sc.nextInt();
        System.out.println("请输入图书名称：");
        String name = sc.next();
        System.out.println("请输入图书作者：");
        String author = sc.next();
        String sql = "insert into book(id,bookName,bookAuthor) values("+num+",'"+name+"','"+author+"');";
        int insert = DBUtil.insert(sql);
        if(insert > 0){
            System.out.println("插入成功！");
        }else{
            System.out.println("插入失败！");
        }
    }
//    删除
    @Override
    public void deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的图书名称：");
        String name = sc.next();
        String sql = "delete from book where bookName = '"+name+"';";
        int delete = DBUtil.delete(sql);
        if(delete > 0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
    }
    //    查看所有
    @Override
    public void queryAll() throws SQLException {
        String sql = "select * from book";
        ResultSet rs = DBUtil.query(sql);
        System.out.println("图书编号"+"\t\t"+"图书名称"+"\t\t"+"图书作者"+"\t\t"+"图书状态"+"\t\t\t"+"借阅时间"+"\t\t\t\t\t\t\t\t"+"归还时间"+"\t\t\t\t\t\t\t\t"+"借阅次数");
        if(rs == null){
            return;
        }
        while(rs.next()){
            Book book = new Book();//创建新的书的对象
            book.setId(rs.getInt("id"));
            book.setBookName(rs.getString("bookName"));
            book.setBookAuthor(rs.getString("bookAuthor"));
            book.setBookStatus(rs.getString("bookStatus"));
            book.setBorrowTime(rs.getString("borrowTime"));
            book.setReturnTime(rs.getString("returnTime"));
            book.setBorrowTimes(rs.getInt("borrowTimes"));
            System.out.println(book.getId()+"\t\t\t"+book.getBookName()+"\t\t\t"+book.getBookAuthor()+"\t\t"+book.getBookStatus()+"\t\t"+book.getBorrowTime()+"\t"+book.getReturnTime()+"\t\t\t\t"+book.getBorrowTimes());
        }
    }
//    查询
    @Override
    public void queryBook() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的图书名称：");
        String name = sc.next();
        String sql = "select * from book where bookName ='"+name+"';";
        ResultSet rs = DBUtil.query(sql);
        System.out.println("图书编号"+"\t\t"+"图书名称"+"\t\t"+"图书作者"+"\t\t"+"图书状态"+"\t\t\t"+"借阅时间"+"\t\t\t\t\t\t\t\t"+"归还时间"+"\t\t\t\t\t\t\t\t"+"借阅次数");
        if(rs == null){
            return;
        }
        while(rs.next()){
            Book book = new Book();//创建新的书的对象
            book.setId(rs.getInt("id"));
            book.setBookName(rs.getString("bookName"));
            book.setBookAuthor(rs.getString("bookAuthor"));
            book.setBookStatus(rs.getString("bookStatus"));
            book.setBorrowTime(rs.getString("borrowTime"));
            book.setReturnTime(rs.getString("returnTime"));
            book.setBorrowTimes(rs.getInt("borrowTimes"));
            System.out.println(book.getId()+"\t\t\t"+book.getBookName()+"\t\t\t"+book.getBookAuthor()+"\t\t"+book.getBookStatus()+"\t\t"+book.getBorrowTime()+"\t"+book.getReturnTime()+"\t\t\t\t"+book.getBorrowTimes());
        }
    }
//    借阅
    @Override
    public void borrowBook() throws SQLException {
        Calendar c = Calendar.getInstance();//获取日历对象
        String borrowTime = c.getTime().toString();//获取当前时间
        System.out.println("请输入你要借阅的图书名称：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int borrowTimes = 0;
        String sql1 = "select bookStatus from book where bookName = '"+name+"';";
        ResultSet rs = DBUtil.query(sql1);
        if(rs.next()){
            String bookStatus = rs.getString("bookStatus");
            if("true".equals(bookStatus)){
                String sql2 = "update book set borrowTimes = '"+(++borrowTimes)+"',borrowTime='"+borrowTime+"',bookStatus = 'false' where bookName = '"+name+"';";
                int update = DBUtil.update(sql2);
                if(update > 0){
                    System.out.println("借阅成功!");
                }else{
                    System.out.println("借阅失败!");
                }
            }else{
                System.out.println("该书已借出！");
            }
        }else{
            System.out.println("该书不存在！");
        }

    }
//    归还
    @Override
    public void returnBook() {
        Calendar c = Calendar.getInstance();
        String returnTime = c.getTime().toString();
        System.out.println("请输入你要归还的图书名称：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String sql = "update book set returnTime ='"+returnTime+"',bookStatus = 'true' where bookName ='"+name+"';";
        int update = DBUtil.update(sql);
        if(update > 0){
            System.out.println("归还成功!");
        }else{
            System.out.println("归还失败!");
        }
    }
}
