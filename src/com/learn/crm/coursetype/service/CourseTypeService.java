package com.learn.crm.coursetype.service;

import com.learn.crm.coursetype.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeService {

    public List<CrmCourseType> findAll();

    public List<CrmCourseType> findAll(CrmCourseType courseType);

    public CrmCourseType findById(String courseTypeId);

    public void addOrEdit(CrmCourseType courseType);
}
