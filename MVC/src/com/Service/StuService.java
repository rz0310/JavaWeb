package com.Service;

import com.Dao.StuDao;

public class StuService {
    StuDao stuDao;

    public StuDao getStuDao() {
        return stuDao;
    }

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }
}
