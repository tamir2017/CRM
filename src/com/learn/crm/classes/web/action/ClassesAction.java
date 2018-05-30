package com.learn.crm.classes.web.action;

import com.learn.crm.base.BaseAction;
import com.learn.crm.classes.domain.CrmClasses;
import com.learn.crm.utils.MyStringUtils;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class ClassesAction extends BaseAction<CrmClasses> {

    /**
     * 查询所有
     * @return
     */
    public String findAll(){
        List<CrmClasses> allClasses =  this.getClassesService().findAll();
        this.set("allClasses",allClasses);
        return "findAll";
    }

    /**
     * 显示上传表单
     * @return
     */
    public String uploadUI(){
        CrmClasses findClasses =  this.getClassesService().findById(this.getModel().getClassId());
        this.push(findClasses);
        return "uploadUI";
    }

    private File schedule;                 //上传内容
    private String scheduleFileName;       //上传文件名
    private String scheduleContentType;    //上传类型

    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }
    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }
    public void setScheduleContentType(String scheduleContentType) {
        this.scheduleContentType = scheduleContentType;
    }

    /**
     * 文件上传
     * @return
     */
    @InputConfig(resultName = "uploadInput")
    public String upload() throws IOException{
        //1 将课表保存到硬盘
        // 1.1位置
        String parentDir = "/root/IdeaProjects/JavaWeb01Pro/CRM_demo/web/WEB-INF/upload";
        // 1.2文件名为随机数，并且没有拓展名
        String fileName = MyStringUtils.getUUID();
        //1.3 保存
        FileUtils.copyFile(schedule,new File(parentDir,fileName));



        //2 更新
        this.getModel().setUploadTime(new Date());
        this.getModel().setUploadPath("/WEB-INF/upload/" + fileName);
        this.getModel().setUploadFilename(scheduleFileName);
        this.getClassesService().updateUpload(this.getModel());

        return "upload";
    }


}
