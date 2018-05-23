package com.learn.crm.coursetype.web.action;

import com.learn.crm.coursetype.domain.CrmCourseType;
import com.learn.crm.coursetype.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {

    CrmCourseType courseType = new CrmCourseType();
    @Override
    public CrmCourseType getModel() {
        return courseType;
    }
    private CourseTypeService courseTypeService;
    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    /////////////////////////////////////////////////////////////
    public String findAll(){
        // 1.查找
        List<CrmCourseType> allCourseType = courseTypeService.findAll();
        // 2. 放入contextMap,  jsp采用“#key"获得
        ActionContext.getContext().put("allCourseType",allCourseType);
        return "findAll";
    }


}
