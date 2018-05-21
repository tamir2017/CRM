package com.learn.crm.staff.dao;

import com.learn.crm.staff.domain.CrmStaff;

public interface StaffDao {
    /**
     * find by loginName and loginPassword
     * @param loginName
     * @param loginPwd
     * @return
     */
    public CrmStaff find(String loginName, String loginPwd);
}
