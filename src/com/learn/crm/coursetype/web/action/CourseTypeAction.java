package com.learn.crm.coursetype.web.action;

import com.learn.crm.coursetype.domain.CrmCourseType;
import com.learn.crm.coursetype.service.CourseTypeService;
import com.learn.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

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

    //分页数据
    private int pageNum = 1;
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    private int pageSize = 2;
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /////////////////////////////////////////////////////////////
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
        PageBean<CrmCourseType> pageBean = this.courseTypeService.findAll(courseType,pageNum,pageSize);
        ActionContext.getContext().put("pageBean",pageBean);

        return "findAll";
    }

    /**
     * 添加/编辑显示jsp页面
     * @return
     */
    public String addOrEditUI(){
        //若有id则编辑，需查询详情
        if (StringUtils.isNotBlank(this.courseType.getCourseTypeId())){
            //将查询的数据放入栈顶，方便数据的回显
            CrmCourseType findCourseType = courseTypeService.findById(this.courseType.getCourseTypeId());
            ActionContext.getContext().getValueStack().push(findCourseType);
        }
        return "addOrEditUI";
    }
    /**
     * 添加/编辑功能
     * @return
     */
    public String addOrEdit(){
        this.courseTypeService.addOrEdit(courseType);
        return "addOrEdit";
    }

}
