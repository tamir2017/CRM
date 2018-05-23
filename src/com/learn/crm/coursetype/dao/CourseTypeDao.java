package com.learn.crm.coursetype.dao;

import com.learn.crm.coursetype.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeDao {

    public List<CrmCourseType> findAll();

    public List<CrmCourseType> findAll(String condition, Object[] params);

    public CrmCourseType findById(String courseTypeId);

    public void saveOrUpdate(CrmCourseType courseType);
}
