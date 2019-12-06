package com.jiabiango.hr.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiabiango.hr.dto.DemoQueryDto;
import com.jiabiango.hr.model.Demo;
import com.jiabiango.hr.pager.LayPageResult;
import com.jiabiango.hr.service.DemoServcie;

@Controller
@RequestMapping("/admin")
public class AdminDemoController {
    @Autowired
    private DemoServcie demoServcie;
     
    @GetMapping("/demo.html")
    public String list() {
        return "demo/demo";
    }
    
    @GetMapping("/demo/edit.html")
    public String edit() {
        return "demo/demo_edit";
    }
    
    @GetMapping("/demo/add.html")
    public String add() {
        return "demo/demo_add";
    }
    
    @GetMapping("/demo")
    @ResponseBody
    public LayPageResult<Demo> queryDemo(DemoQueryDto query) {
        return demoServcie.query(query);
    }
    
    @GetMapping("/demo/{id}")
    @ResponseBody
    public Demo getDemo(@PathVariable("id") Integer id) {
        return demoServcie.get(id);
    }
    
    @PutMapping("/demo")
    @ResponseBody
    public void updateDemo(@RequestBody Demo demo) {
        demoServcie.update(demo);
    }
    
    @PostMapping("/demo")
    @ResponseBody
    public void saveDemo(@RequestBody Demo demo) {
        demoServcie.save(demo);
    }
}