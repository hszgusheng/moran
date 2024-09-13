package com.situ.chronicmange.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.situ.chronicmange.common.ResponseBean;
import com.situ.chronicmange.entity.Rhr;
import com.situ.chronicmange.entity.User;
import com.situ.chronicmange.service.IRhrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 档案表 前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
@Controller
//@RequestMapping("/chronicmange/rhr")
public class RhrController {
    @Autowired
    private IRhrService rhrService;
    @GetMapping("/rhr/list")
    public String list(){
        return "web/rhr/list";
    }

    @PostMapping("/rhr/listPage")
    @ResponseBody
    private ResponseBean<IPage<Rhr>>listPage (int page, int limit){
        ResponseBean<IPage<Rhr>> result=new ResponseBean<>();
        IPage<Rhr> rhrIPage=new Page<>();
        rhrIPage.setCurrent(page);
        rhrIPage.setSize(limit);
        result.setCode(0);
        result.setRes(rhrService.page(rhrIPage));
        result.setMsg("查询成功");
        return  result;
    }

    @GetMapping("rhr/add")
    private String add(){
        return "web/rhr/add";
    }
    @PostMapping("rhr/add")
    @ResponseBody
    private ResponseBean<Object> add(Rhr rhr,HttpSession httpSession){
        try {
            rhrService.add(rhr);
            return ResponseBean.ok();
        } catch (Exception e) {
            return ResponseBean.failed(e.getMessage());
        }
    }
}
