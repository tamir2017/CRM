package com.learn.crm.post.web.action;

import com.learn.crm.post.domain.CrmPost;
import com.learn.crm.post.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {

    CrmPost post = new CrmPost();
    @Override
    public CrmPost getModel() {
        return post;
    }

    private PostService postService;
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    ///////////////////////////////////////////////////////

    /**
     * ajax findAll post by department
     * @return
     */
    public String findAllWithDepartment() throws IOException{
        //1.find
        List<CrmPost> allPost = postService.findAll(post.getDepartment());

        //2.javaBean => json
        //2.1 排除不需要数据
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"department","staffSet"});
        //2.2 转换
        String jsonData = JSONArray.fromObject(allPost,jsonConfig).toString();

        //3.json data => browser
        //3.1响应中文乱码
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");

        //3.2发送
        ServletActionContext.getResponse().getWriter().print(jsonData);

        return "none";
    }
}
