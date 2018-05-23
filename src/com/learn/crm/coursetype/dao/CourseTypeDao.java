package com.learn.crm.coursetype.dao;

import com.learn.crm.coursetype.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeDao {

    public List<CrmCourseType> findAll();
}
