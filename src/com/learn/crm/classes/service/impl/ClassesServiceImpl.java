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
}
