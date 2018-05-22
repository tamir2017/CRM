package com.learn.crm.department.service.impl;

import com.learn.crm.department.dao.DepartmentDao;
import com.learn.crm.department.domain.CrmDepartment;
import com.learn.crm.department.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<CrmDepartment> findAll() {
        return departmentDao.findAll();
    }
}
