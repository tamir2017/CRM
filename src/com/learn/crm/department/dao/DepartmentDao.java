package com.learn.crm.department.dao;

import com.learn.crm.department.domain.CrmDepartment;

import java.util.List;

public interface DepartmentDao {

    /**
     *
     * @return
     */
    public List<CrmDepartment> findAll();
}
