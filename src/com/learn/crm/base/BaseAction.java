package com.learn.crm.base;

import com.learn.crm.coursetype.service.CourseTypeService;
import com.learn.crm.department.service.DepartmentService;
import com.learn.crm.post.service.PostService;
import com.learn.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    //1 封装数据
    private T t;
    @Override
    public T getModel() {
        return t;
    }
    //1.1 实例化T
    public BaseAction(){
        try{
            //1获得运行时class
            ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) paramType.getActualTypeArguments()[0];
            //2反射创建实例
            t = clazz.newInstance();
        }catch (Exception e){
            //将编译异常转换成运行异常
            throw new RuntimeException(e);
        }

    }

    //2 spring注入service，多个  （可选）
    //**提供setter方法，让spring进行注入
    //**提供getter方法，让子类可以获得Spring注入的对象
    //员工
    private StaffService staffService;
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
    public StaffService getStaffService() {
        return staffService;
    }
    //职务
    private PostService postService;
    public void setPostService(PostService postService) {
        this.postService = postService;
    }
    public PostService getPostService() {
        return postService;
    }
    //部门
    private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    public DepartmentService getDepartmentService() {
        return departmentService;
    }
    //课程类别
    private CourseTypeService courseTypeService;
    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }
    public CourseTypeService getCourseTypeService() {
        return courseTypeService;
    }
    //班级
    // 后续添加



    //3 分页数据  （可选）
    private int pageNum = 1;
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageNum() {
        return pageNum;
    }

    private int pageSize = 2;
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageSize() {
        return pageSize;
    }

    // 4简化值栈操作
    public void push(Object o){
        ActionContext.getContext().getValueStack().push(o);
    }
    public void set(String key,Object o){
        ActionContext.getContext().getValueStack().set(key, o);
    }
    public void put(String key,Object value){
        ActionContext.getContext().put(key, value);
    }
    public void putSession(String key,Object value){
        ActionContext.getContext().getSession().put(key,value);
    }
    public void putApplication(String key,Object value){
        ActionContext.getContext().getApplication().put(key,value);
    }

}
