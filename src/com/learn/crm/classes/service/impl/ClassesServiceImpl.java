package com.learn.crm.classes.service.impl;

import com.learn.crm.classes.dao.ClassesDao;
import com.learn.crm.classes.domain.CrmClasses;
import com.learn.crm.classes.service.ClassesService;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {

    private ClassesDao classesDao;
    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    @Override
    public List<CrmClasses> findAll() {
        return classesDao.findAll();
    }

    @Override
    public CrmClasses findById(String classesId) {
        return classesDao.findById(classesId);
    }

    @Override
    public void updateUpload(CrmClasses c) {
        //1 首先查询  再次更新    快照与一级缓存
        CrmClasses findClass = this.classesDao.findById(c.getClassId());
        findClass.setUploadFilename(c.getUploadFilename());
        findClass.setUploadPath(c.getUploadPath());
        findClass.setUploadTime(c.getUploadTime());
    }

}
