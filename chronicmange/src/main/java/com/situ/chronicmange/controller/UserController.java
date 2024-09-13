package com.situ.chronicmange.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.situ.chronicmange.common.ResponseBean;
import com.situ.chronicmange.entity.User;
import com.situ.chronicmange.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *用户表 前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
//登录页面
@Controller
//@RequestMapping("/chronicmange/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /*
    登录页面
     */
    @GetMapping("/login") //访问地址 localhost:9001/login
    private String login() {
        return "web/login";
    }

    /*
    登录处理
    接收参数
    判断是否登录 验证通过，进入主页,保持我们的登录状态;
    验证失败，留在当前页，提示信息
     */
    @PostMapping("/login") //访问地址
    private String dealLogin(User user, //接收参数
                             Model model, //提示信息
                             HttpSession httpSession//登录状态
    ) {
        try {
            user = userService.dealLogin(user);
            //保持登录
            httpSession.setAttribute("user", user);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "web/login";
        }
    }

    /*
    主页面
     */
    @GetMapping("/")
    private String index() {
        return "web/index";
    }

    /*
    退出
     */
    @GetMapping("/loginOut")//访问地址 localhost:9001/loginOut
    private String loginOut(HttpSession httpSession) {
        //清除登录状态
        httpSession.invalidate();
        //回到登录页
        return "login";
    }

    @GetMapping("/getData")
    @ResponseBody
    private ResponseBean getData() {
        ResponseBean<List<Map<String, Object>>> result = new ResponseBean<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map.put("name", "80岁以上");
        map.put("value", 700);
        map1.put("name", "75~80岁以");
        map1.put("value", 400);
        map2.put("name", "65~70岁");
        map2.put("value", 100);
        list.add(map);
        list.add(map1);
        list.add(map2);
        result.setCode(700);
        result.setCode(400);
        result.setCode(100);
        result.setRes(list);
        result.setRes(list);
        result.setRes(list);
        return result;
    }

    @GetMapping("/home")
    private String home() {
        return "web/home";
    }

    @GetMapping("user/modifiedPwd")
    private String modifiedPwd() {
        return "web/user/modified";
    }

    @PostMapping("user/modifiedPwd")
    @ResponseBody
    private ResponseBean<Object> modifiedPwdUser(User user,
                                                 String newPassword,
                                                 String rePassword,
                                                 HttpSession httpSession) {
        User sUser = (User) httpSession.getAttribute("user");
        user.setId(sUser.getId());
        try {
            userService.modifiedPwdUser(user, newPassword, rePassword);
            httpSession.invalidate();
            return ResponseBean.ok();
        } catch (Exception e) {
            return ResponseBean.failed(e.getMessage());
        }
    }
    /*
    账号列表页面
     */
    @GetMapping("user/list")
    private String list(){
        return "web/user/list";

    }
    /*账户列表分页操作
    * page 第几页
    * limit 每页数量
    * */
    @PostMapping("/user/listPage")
    @ResponseBody
    private ResponseBean<IPage<User>>listPage (int page, int limit){
        ResponseBean<IPage<User>> result=new ResponseBean<>();
        IPage<User> userIPage=new Page<>();
        userIPage.setCurrent(page);
        userIPage.setSize(limit);
        result.setCode(0);
        result.setRes(userService.page(userIPage));
        result.setMsg("查询成功");
        return  result;
    }
    /*
    修改页面
    当前数据返回前端
     */
    @GetMapping("user/edit")
    private String edit(int id,Model model){
        model.addAttribute("userInfo",userService.getById(id));
        return "web/user/edit";
    }
    /*
    修改操作
     */
    @PostMapping("user/edit")
    @ResponseBody
    private ResponseBean edit(User user){
     userService.updateById(user);
     return ResponseBean.ok();
    }
    /*添加账户*/
    @GetMapping("user/add")
    private String add() {
        return "web/user/add";
    }
    @PostMapping("user/add")
    @ResponseBody
    private ResponseBean<Object> add(User user,
                                     String respassword,
                                     HttpSession httpSession) {
        try {
            userService.add(user,respassword);
            return ResponseBean.ok();
        } catch (Exception e) {
            return ResponseBean.failed(e.getMessage());
        }
    }
}
