package com.learn.crm.coursetype.service.impl;

import com.learn.crm.coursetype.dao.CourseTypeDao;
import com.learn.crm.coursetype.domain.CrmCourseType;
import com.learn.crm.coursetype.service.CourseTypeService;

import java.util.List;

public class CourseTypeServiceImpl implements CourseTypeService {

    private CourseTypeDao courseTypeDao;
    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public List<CrmCourseType> findAll() {
        return courseTypeDao.findAll();
    }
}
