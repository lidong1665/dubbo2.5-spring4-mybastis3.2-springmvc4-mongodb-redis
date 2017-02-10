package com.lidong.dubbo.web.user.controller;

import com.lidong.dubbo.api.login.service.ILoginService;
import com.lidong.dubbo.api.user.service.IUserService;
import com.lidong.dubbo.model.user.User;
import com.lidong.dubbo.util.FastDFSUtil;
import com.lidong.dubbo.util.FileUtil;
import com.lidong.dubbo.util.JsonUtil;
import com.lidong.dubbo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称:lidong-dubbo
 * @类名:UserController
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/1/11 上午10:25
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Qualifier("userService")
    @Autowired
    IUserService userService;

    @Qualifier("loginService")
    @Autowired
    ILoginService loginService;

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/userList")
    public String user(HttpServletRequest request, Model model){
        List<User> users = null;
        try {
            users = userService.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("size = "+users.size());
        model.addAttribute("users", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", "111111111");
        Map<String, Object> login = null;
        try {
            login = loginService.login(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(login.get("user").toString());
        return "userList";
    }


    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    public ModelAndView getUser(HttpServletRequest request){
        String userId = request.getParameter("id");
        User user = null;
        try {
            user = this.userService.getUserById(Integer.parseInt(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView model= new ModelAndView();
        model.setViewName("update_user");
        model.addObject(user);
        return model;
    }


    /**
     *
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/getUserInfo")
    public ModelAndView getUserInfo(HttpServletRequest request){
        String userId = request.getParameter("id");
        User user = null;
        try {
            user = userService.getUserById(Integer.parseInt(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView model= new ModelAndView();
        model.setViewName("look_user");
        model.addObject(user);
        return model;
    }


    /**
     *
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest request,Model model,HttpSession httpSession){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.info("login   username="+username+"   password="+password);
        User user = new User();
        user.setName(username);
        user.setPassword(httpSession.getId());
        httpSession.setAttribute("user",user);
        String hello = null;
        try {
            hello = userService.sayHello("hejingyuan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("result="+hello);
        return JsonUtil.bean2json(user);
    }


    @RequestMapping("/getUserInfo1")
    public void getUserInfo1(HttpServletRequest request,HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        logger.info("-----"+httpSession.getId());
        logger.info("-----"+user.getName());
    }


    /**
     *
     * @param
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/login1")
    public String login1(@RequestBody Map<String,String> map, Model model){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        logger.info("login1  username="+username+"   password="+password);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return JsonUtil.bean2json(user);
    }

    /**
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request,Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));
        logger.info("username="+username+"   password="+password);
        this.userService.addUser(user);
        List<User> users = null;
        try {
            users = this.userService.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("users="+users.size());
        model.addAttribute("users", users);
        return "redirect:userList";
    }

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/delUser")
    public String delUser(HttpServletRequest request,Model model){
        String userId = request.getParameter("id");
        logger.info(" userId="+userId);
        int delUserById = 0;
        try {
            delUserById = userService.delUserById(Integer.parseInt(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(" delUserById="+delUserById);
        List<User> users = null;
        try {
            users = userService.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("users", users);
        model.addAttribute("delUserById", delUserById);
        return "redirect:userList";
    }


    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request,Model model){
        String userId = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        User user = new User();
        user.setId(Integer.parseInt(userId));
        user.setName(username);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));
        int i  = 0;
        try {
            i = userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<User> users = null;
        try {
            users = userService.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("users", users);
        model.addAttribute("update", i);
        return "redirect:userList";
    }


    @RequestMapping("/upload")
    public String addUser(@RequestParam("file") CommonsMultipartFile[] files,
                          HttpServletRequest request){

        for(int i = 0;i<files.length;i++){
            logger.info("fileName-->" + files[i].getOriginalFilename()+"     file-size--->"+files[i].getSize());
            Map<String, Object> retMap = FastDFSUtil.upload(files[i]);
            String code = (String) retMap.get("code");
            String group = (String) retMap.get("group");
            String msg = (String) retMap.get("msg");

            if ("0000".equals(code)){
                logger.info("文件上传成功");
                //TODO:将上传文件的路径保存到mysql数据库
            }else {
                logger.info("文件上传失败");
            }


        }
        return "/success";
    }




    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        try {
            FileUtil.saveImage(request, multipartResolver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/success";
    }
}
