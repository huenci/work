package com.jiabiango.hr.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiabiango.hr.model.Resource;
import com.jiabiango.hr.service.ResourceService;

@Controller
@RequestMapping("/admin")
public class ResourceController {

    @Autowired
    public ResourceService resourceService;
    
    @GetMapping("/resource.html")
    public String list() {
        return "resource/resource";
    }
    
    @GetMapping("/resource")
    @ResponseBody
    public List<Resource> get() {
        return resourceService.getAll();
    }
    
    @PutMapping("/resource")
    @ResponseBody
    public Resource updateResource(@RequestBody Resource resource) {
        return resourceService.update(resource);
    }
    
    @PostMapping("/resource")
    @ResponseBody
    public Resource saveResource(@RequestBody Resource resource) {
        return resourceService.save(resource);
    }
    
    @DeleteMapping("/resource")
    @ResponseBody
    public Resource delResource(@RequestBody Resource resource) {
        return resourceService.del(resource);
    }
}
