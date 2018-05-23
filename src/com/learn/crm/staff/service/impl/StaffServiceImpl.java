package com.learn.crm.staff.service.impl;

import com.learn.crm.staff.dao.StaffDao;
import com.learn.crm.staff.domain.CrmStaff;
import com.learn.crm.staff.service.StaffService;
import com.learn.crm.utils.MyStringUtils;

import java.util.List;

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

    @Override
    public List<CrmStaff> findAllStaff() {
        return staffDao.findAll();
    }

    @Override
    public CrmStaff findById(String staffId) {
        return staffDao.findById(staffId);
    }

    @Override
    public void updateStaff(CrmStaff staff) {

        CrmStaff findStaff = staffDao.findById(staff.getStaffId());
        if (! findStaff.getLoginPwd().equals(staff.getLoginPwd())){
            findStaff.setLoginPwd(MyStringUtils.getMD5Value(staff.getLoginPwd()));
        }
        findStaff.setLoginName(staff.getLoginName());
        findStaff.setStaffName(staff.getStaffName());
        findStaff.setGender(staff.getGender());
        findStaff.setOnDutyDate(staff.getOnDutyDate());
        findStaff.setPost(staff.getPost());

    }
}
