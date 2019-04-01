package com.Test;

import com.Dao.Imp.StuDaoImp;
import com.Dao.StuDao;
import com.Service.StuService;
import org.junit.Test;

public class TestDemo {
    @Test
    public void test(){
        StuDao stuDao = new StuDaoImp();
        StuService stuService = new StuService();
//        stuService
    }
}
