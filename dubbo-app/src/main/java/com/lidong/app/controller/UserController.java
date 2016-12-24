package com.lidong.app.controller;  
  
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.lidong.api.service.login.ILoginService;
import com.lidong.api.service.user.IUserService;
import com.lidong.model.user.User;
import com.lidong.util.FileUtil;
import com.lidong.util.JsonUtils;

  
  
@Controller 
@RequestMapping("/user")  
public class UserController {  
	
	private static final Logger logger = Logger.getLogger(UserController.class);
    
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
    public String user(HttpServletRequest request,Model model){    
        List<User> users = this.userService.getAllUser(); 
        logger.info("size = "+users.size());
        model.addAttribute("users", users); 
        Map<String, Object> map = new HashMap<>();
        map.put("user", "111111111");
		Map<String, Object> login = loginService.login(map);
        logger.info(login.get("user").toString());
        return "userList";  
    }
    
    
    /**
     *   
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getUser")  
    public ModelAndView getUser(HttpServletRequest request){ 
    	String userId = request.getParameter("id");
        User user = this.userService.getUserById(Integer.parseInt(userId)); 
        ModelAndView model= new ModelAndView();
        model.setViewName("update_user"); 
        model.addObject(user);
        return model;  
    }
    
    
    /**
     *   
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getUserInfo")  
    public ModelAndView getUserInfo(HttpServletRequest request){ 
    	String userId = request.getParameter("id");
        User user = this.userService.getUserById(Integer.parseInt(userId)); 
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
    public String login(HttpServletRequest request,Model model){  
        String username = request.getParameter("username");  
        String password = request.getParameter("password"); 
        logger.info("login   username="+username+"   password="+password);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        String hello = userService.sayHello("hejingyuan");  
        logger.info("result="+hello);  
        return JsonUtils.bean2json(user);  
    }
    
    
    /**
     * 
     * @param request
     * @param model
     * @return
     */
    @ResponseBody  
    @RequestMapping("/login1")  
    public String login1(@RequestBody Map<String,String> map,Model model){  
        String username = (String) map.get("username");  
        String password = (String) map.get("password"); 
        logger.info("login1  username="+username+"   password="+password);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return JsonUtils.bean2json(user);  
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
        List<User> users = this.userService.getAllUser(); 
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
        int delUserById = this.userService.delUserById(Integer.parseInt(userId));
        logger.info(" delUserById="+delUserById);
        List<User> users = this.userService.getAllUser(); 
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
        int i  = this.userService.updateUser(user); 
        List<User> users = this.userService.getAllUser(); 
        model.addAttribute("users", users);  
        model.addAttribute("update", i);  
        return "redirect:userList";   
    }  
    
    
    @RequestMapping("/upload"   )  
    public String addUser(@RequestParam("file") CommonsMultipartFile[] files,
    		HttpServletRequest request){  
          
        for(int i = 0;i<files.length;i++){  
            System.out.println("fileName-->" + files[i].getOriginalFilename()+"     file-size--->"+files[i].getSize());  
            FileUtil.saveImage(files, i);  
        }  
        return "/success";  
    }


	
    
    @RequestMapping("/upload2"  )  
    public String upload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        FileUtil.saveImage(request, multipartResolver);  
        return "/success";  
    }
}  