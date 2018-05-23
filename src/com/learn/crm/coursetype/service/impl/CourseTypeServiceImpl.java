package com.learn.crm.coursetype.service.impl;

import com.learn.crm.coursetype.dao.CourseTypeDao;
import com.learn.crm.coursetype.domain.CrmCourseType;
import com.learn.crm.coursetype.service.CourseTypeService;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
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

    @Override
    public List<CrmCourseType> findAll(CrmCourseType courseType) {
        //1.1 拼凑查询条件
        StringBuilder builder = new StringBuilder();
        //1.2 拼凑实际参数
        List<Object> paramsList = new ArrayList<Object>();

        //2.过滤条件
        //2.1 课程类别
        if (StringUtils.isNotBlank(courseType.getCourseName())){
            builder.append("and courseName like ?");
            paramsList.add("%"+courseType.getCourseName()+"%");
        }
        //2.2 课程简介
        if (StringUtils.isNotBlank(courseType.getRemark())){
            builder.append("and remark like ?");
            paramsList.add("%"+courseType.getRemark()+"%");
        }
        //2.3 总学时
        if (StringUtils.isNotBlank(courseType.getTotalStart())){
            builder.append("and total >= ?");
            paramsList.add(Integer.parseInt(courseType.getTotalStart()));
        }
        if (StringUtils.isNotBlank(courseType.getTotalEnd())){
            builder.append("and total <= ?");
            paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
        }
        //2.4 课程费用
        if (StringUtils.isNotBlank(courseType.getCourseCostStart())){
            builder.append("and courseCost >= ?");
            paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
        }
        if (StringUtils.isNotBlank(courseType.getCourseCostEnd())){
            builder.append("and courseCost <= ?");
            paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
        }

        //3.使用
        //条件 ，格式：“and ...?  and ...”
        String condition = builder.toString();
        //实际参数
        Object[] params = paramsList.toArray();

        return courseTypeDao.findAll(condition,params);
    }
}
