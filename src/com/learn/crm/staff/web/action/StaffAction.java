package com.learn.crm.staff.web.action;

import com.learn.crm.base.BaseAction;
import com.learn.crm.department.domain.CrmDepartment;
import com.learn.crm.department.service.DepartmentService;
import com.learn.crm.staff.domain.CrmStaff;
import com.learn.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class StaffAction extends BaseAction<CrmStaff> {

    /**
     * 员工登录
     * @return
     */
    public String login(){

        //1 查询员工
        CrmStaff findStaff = getStaffService().login(this.getModel());
        //2 是否成功
        if(findStaff != null){
            //成功
            // 3.1 session作用域保存数据
            putSession("loginStaff", findStaff);
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
        List<CrmStaff> allStaff = getStaffService().findAllStaff();
        put("allStaff",allStaff);

        return "findAll";
    }

    public String editUI(){
        //1. find stuff by id
        CrmStaff findStaff = getStaffService().findById(getModel().getStaffId());
        ActionContext.getContext().getValueStack().push(findStaff);

        //2.find all department
        List<CrmDepartment> allDepartment = getDepartmentService().findAll();
        set("allDepartment",allDepartment);

        return "editUI";
    }

    public String edit(){
        this.getStaffService().updateStaff(getModel());
        return "edit";

    }
}
