package com.learn.crm.staff.service;

import com.learn.crm.staff.domain.CrmStaff;

import java.util.List;

public interface StaffService {

    public CrmStaff login(CrmStaff staff);

    public List<CrmStaff> findAllStaff();

    public CrmStaff findById(String staffId);
}
