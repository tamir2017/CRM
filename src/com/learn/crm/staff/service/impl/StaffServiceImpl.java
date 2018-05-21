package com.learn.crm.staff.service.impl;

import com.learn.crm.staff.dao.StaffDao;
import com.learn.crm.staff.domain.CrmStaff;
import com.learn.crm.staff.service.StaffService;
import com.learn.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public CrmStaff login(CrmStaff staff) {
        // MD5 => loginPwd
        String loginPwd = MyStringUtils.getMD5Value(staff.getLoginPwd());
        return staffDao.find(staff.getLoginName(),loginPwd);
    }
}
