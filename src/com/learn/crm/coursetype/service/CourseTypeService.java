package com.learn.crm.coursetype.service;

import com.learn.crm.coursetype.domain.CrmCourseType;
import com.learn.crm.page.PageBean;

import java.util.List;

public interface CourseTypeService {

    public List<CrmCourseType> findAll();

    public List<CrmCourseType> findAll(CrmCourseType courseType);

    public CrmCourseType findById(String courseTypeId);

    public void addOrEdit(CrmCourseType courseType);

    /**
     * 分页 + 条件 查询
     * @param courseType 条件
     * @param pageNum 当前页
     * @param pageSize 每页显示的个数
     * @return
     */
    public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum, int pageSize);
}
