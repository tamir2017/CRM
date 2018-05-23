package com.learn.crm.post.dao.impl;

import com.learn.crm.department.domain.CrmDepartment;
import com.learn.crm.post.dao.PostDao;
import com.learn.crm.post.domain.CrmPost;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<CrmPost> findAll(CrmDepartment department) {
        return this.getHibernateTemplate().find("from CrmPost where department = ?", department);
    }
}
