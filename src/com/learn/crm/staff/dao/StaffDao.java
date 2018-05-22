package com.learn.crm.staff.dao;

import com.learn.crm.staff.domain.CrmStaff;

import java.util.List;

public interface StaffDao {
    /**
     * find by loginName and loginPassword
     * @param loginName
     * @param loginPwd
     * @return
     */
    public CrmStaff find(String loginName, String loginPwd);

    /**
     *
     * @return
     */
    public List<CrmStaff> findAll();

    /**
     *
     * @param staffId
     * @return
     */
    public CrmStaff findById(String staffId);
}
