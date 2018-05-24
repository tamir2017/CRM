package com.learn.crm.coursetype.dao.impl;

import com.learn.crm.coursetype.dao.CourseTypeDao;
import com.learn.crm.coursetype.domain.CrmCourseType;
import com.learn.crm.page.PageHibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

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

    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(c) from CrmCourseType c where 1=1" + condition;
        List<Long> list =  this.getHibernateTemplate().find(hql,params);
        return list.get(0).intValue();
    }

    @Override
    public List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from CrmCourseType where 1=1" + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>().setHql(hql).setPageSize(pageSize).setParams(params).setStartIndex(startIndex));
    }
}
