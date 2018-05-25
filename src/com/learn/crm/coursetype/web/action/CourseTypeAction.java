package com.learn.crm.coursetype.web.action;

import com.learn.crm.base.BaseAction;
import com.learn.crm.coursetype.domain.CrmCourseType;
import com.learn.crm.coursetype.service.CourseTypeService;
import com.learn.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CourseTypeAction extends BaseAction<CrmCourseType> {

    public String findAll(){
        /**
         * 简单查询
         */
        /*
        // 1.查找
        List<CrmCourseType> allCourseType = courseTypeService.findAll();
        // 2. 放入contextMap,  jsp采用“#key"获得
        ActionContext.getContext().put("allCourseType",allCourseType);
        */

        /**
         * 条件查询
         */
        /*
        // 1.查找
        List<CrmCourseType> allCourseType = courseTypeService.findAll(courseType);
        // 2. 放入contextMap,  jsp采用“#key"获得
        ActionContext.getContext().put("allCourseType",allCourseType);
        */
        /**
         *  分页 + 条件查询
         */
        PageBean<CrmCourseType> pageBean = this.getCourseTypeService().findAll(getModel(),getPageNum(),getPageSize());
        put("pageBean",pageBean);

        return "findAll";
    }

    /**
     * 添加/编辑显示jsp页面
     * @return
     */
    public String addOrEditUI(){
        //若有id则编辑，需查询详情
        if (StringUtils.isNotBlank(this.getModel().getCourseTypeId())){
            //将查询的数据放入栈顶，方便数据的回显
            CrmCourseType findCourseType = getCourseTypeService().findById(this.getModel().getCourseTypeId());
            push(findCourseType);
        }
        return "addOrEditUI";
    }
    /**
     * 添加/编辑功能
     * @return
     */
    public String addOrEdit(){
        this.getCourseTypeService().addOrEdit(this.getModel());
        return "addOrEdit";
    }

}
