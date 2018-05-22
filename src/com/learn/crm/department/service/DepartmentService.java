package com.learn.crm.department.service;

import com.learn.crm.department.domain.CrmDepartment;

import java.util.List;

public interface DepartmentService {

    /**
     *
     * @return
     */
    public List<CrmDepartment> findAll();
}
