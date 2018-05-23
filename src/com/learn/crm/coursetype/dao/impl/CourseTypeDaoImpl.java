package com.learn.crm.coursetype.dao.impl;

import com.learn.crm.coursetype.dao.CourseTypeDao;
import com.learn.crm.coursetype.domain.CrmCourseType;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<CrmCourseType> findAll() {
        return this.getHibernateTemplate().find("from CrmCourseType");
    }
}
