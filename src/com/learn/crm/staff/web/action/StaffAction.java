package com.learn.crm.staff.web.action;

import com.learn.crm.department.domain.CrmDepartment;
import com.learn.crm.department.service.DepartmentService;
import com.learn.crm.staff.domain.CrmStaff;
import com.learn.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff>{

    private CrmStaff staff = new CrmStaff();
    @Override
    public CrmStaff getModel() {
        return staff;
    }

    private StaffService staffService;
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //////////////////////////////////////////////////////

    /**
     * 员工登录
     * @return
     */
    public String login(){

        //1 查询员工
        CrmStaff findStaff = staffService.login(staff);
        //2 是否成功
        if(findStaff != null){
            //成功
            // 3.1 session作用域保存数据
            ActionContext.getContext().getSession().put("loginStaff", findStaff);
            // 3.2 重定向首页 -- xml配置
            return "success";
        }
        //4 不成功
        this.addFieldError("", "用户名与密码不匹配");
        // * 请求转发显示
        return "login";

    }

    /**
     * 显示首页
     * @return
     */
    public String home(){
        return "home";
    }

    /**
     * 查询所有
     * @return
     */
    public String findAll(){
        List<CrmStaff> allStaff = staffService.findAllStaff();
        ActionContext.getContext().put("allStaff",allStaff);

        return "findAll";
    }

    public String editUI(){
        //1. find stuff by id
        CrmStaff findStaff = staffService.findById(staff.getStaffId());
        ActionContext.getContext().getValueStack().push(findStaff);

        //2.find all department
        List<CrmDepartment> allDepartment = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("allDepartment",allDepartment);

        return "editUI";
    }

}
