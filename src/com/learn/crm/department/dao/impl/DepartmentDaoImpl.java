package com.learn.crm.department.dao.impl;

import com.learn.crm.department.dao.DepartmentDao;
import com.learn.crm.department.domain.CrmDepartment;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

    @Override
    public List<CrmDepartment> findAll() {
        return this.getHibernateTemplate().find("from CrmDepartment");
    }
}
