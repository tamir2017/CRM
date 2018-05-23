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


    @Override
    public List<CrmCourseType> findAll(String condition, Object[] params) {
        String hql = "from CrmCourseType where 1=1" + condition;
        return this.getHibernateTemplate().find(hql,params);
    }

    @Override
    public CrmCourseType findById(String courseTypeId) {
        return this.getHibernateTemplate().get(CrmCourseType.class,courseTypeId);
    }

    @Override
    public void saveOrUpdate(CrmCourseType courseType) {
        this.getHibernateTemplate().saveOrUpdate(courseType);
    }
}
