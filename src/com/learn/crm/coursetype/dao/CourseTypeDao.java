package com.learn.crm.coursetype.dao;

import com.learn.crm.coursetype.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeDao {

    public List<CrmCourseType> findAll();

    public List<CrmCourseType> findAll(String condition, Object[] params);

    public CrmCourseType findById(String courseTypeId);

    public void saveOrUpdate(CrmCourseType courseType);

    /**
     * 分页，查询总记录数
     * @param condition
     * @param params
     * @return
     */
    public int getTotalRecord(String condition, Object[] params);

    /**
     * 分页，查询结果
     * @param condition
     * @param params
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize);
}
