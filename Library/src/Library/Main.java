package Library;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        while(true){
            System.out.println("**************欢迎来到图书管理系统**************");
            System.out.println("请按功能选择序号：");
            System.out.println("0.退出系统");
            System.out.println("1.插入图书");
            System.out.println("2.删除图书");
            System.out.println("3.查询图书");
            System.out.println("4.借阅图书");
            System.out.println("5.归还图书");
            System.out.println("6.查看所有");
            System.out.println("请输入序号：");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            BookDaoImp bdi = new BookDaoImp();
            switch(i){
                case 0:
                    System.out.println("感谢使用，欢迎再次使用~");
                    return;
                case 1:
                    bdi.insertBook();
                    break;
                case 2:
                    bdi.deleteBook();
                    break;
                case 3:
                    bdi.queryBook();
                    break;
                case 4:
                    bdi.borrowBook();
                    break;
                case 5:
                    bdi.returnBook();
                    break;
                case 6:
                    bdi.queryAll();
                    break;
                default:
                    System.out.println("这个序号不存在哦！");
                    break;
            }
        }
    }
}
