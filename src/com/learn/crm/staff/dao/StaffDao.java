package com.learn.crm.staff.dao;

import com.learn.crm.base.BaseDao;
import com.learn.crm.staff.domain.CrmStaff;

import java.util.List;

public interface StaffDao extends BaseDao<CrmStaff>{
    /**
     * find by loginName and loginPassword
     * @param loginName
     * @param loginPwd
     * @return
     */
    public CrmStaff find(String loginName, String loginPwd);


}
