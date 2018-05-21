package com.learn.crm.staff.dao.impl;

import com.learn.crm.staff.dao.StaffDao;
import com.learn.crm.staff.domain.CrmStaff;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    @Override
    public CrmStaff find(String loginName, String loginPwd) {
        List<CrmStaff> allStaff = this.getHibernateTemplate().find("from CrmStaff where loginName=? and loginPwd=?",loginName,loginPwd);
        if (allStaff.size() == 1){
            return allStaff.get(0);
        }
        return null;
    }

    @Override
    public List<CrmStaff> findAll() {
        return this.getHibernateTemplate().find("from CrmStaff");
    }


}
