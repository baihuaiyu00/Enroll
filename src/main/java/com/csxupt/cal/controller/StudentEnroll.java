package com.csxupt.cal.controller;

import com.csxupt.cal.entity.Student;
import com.csxupt.cal.service.StuInfoInsert;
import com.csxupt.cal.service.StuShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Admin on 2016/8/31.
 */
@Controller
public class StudentEnroll {

    @Autowired
    private StuShow stuShow;

    @RequestMapping(value = "stu/{id}", method = RequestMethod.GET)
    public String mainer(@PathVariable String id, HttpServletRequest request) {
        switch (id) {
            case "show":{
                List<Student> stu_list = stuShow.show();
                request.setAttribute("stu_list",stu_list);
                request.setAttribute("stus_num",stu_list.size());
                return "page/showStu";
            }

            case "check":{
                return "page/enroll";
            }

        }
        return null;
    }

    @RequestMapping("stu/test")
    public void testShow(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("test");
    }

    /**
     * 报名表单输入处理方法，将学生信息保存至数据库
     */
    @Autowired
    StuInfoInsert stuInfoInsert;

    @RequestMapping(value = "stu/create",method = RequestMethod.POST)
    public String create(@ModelAttribute Student student, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(student);
        String result = stuInfoInsert.createStu(student);
        if("1".equals(result)) {
            request.setAttribute("result","报名成功");
            request.getSession().removeAttribute("schoolNum");
            System.out.println("去掉了session");
            return "page/success";
        }else if("0".equals(result)){
            request.setAttribute("result","报名重复");
            return "page/success";
        }else{
            request.setAttribute("result","服务器繁忙");
            return "page/success";
        }
    }

    /**
     * 此方法为了连接教务系统，检测用户教务处学号密码是否正确，否则不予跳至下一界面
     * @param request
     * @return path
     */
    @RequestMapping(value = "stu", method = RequestMethod.POST)
    public String index(HttpServletRequest request){
        return "page/enroll";
    }

//    /**
//     * 简单首页跳转方法
//     * @param request
//     * @return path
//     */
//    @RequestMapping(value = "stu/check", method = RequestMethod.GET)
//    public String login(HttpServletRequest request){
//        return "page/checkNum";
//    }
//
//
//    @Autowired
//    StuShow stuShow;
//
//    @RequestMapping(value = "stu/show", method = RequestMethod.GET)
//    public String show(HttpServletRequest request,HttpServletResponse response){
//        List<Student> stu_list = stuShow.show();
//        request.setAttribute("stu_list",stu_list);
//        request.setAttribute("stus_num",stu_list.size());
//        return "page/showStu";
//    }

}




