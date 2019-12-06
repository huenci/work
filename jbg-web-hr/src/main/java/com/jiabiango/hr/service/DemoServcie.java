package com.jiabiango.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jiabiango.hr.dto.DemoQueryDto;
import com.jiabiango.hr.mapper.DemoMapper;
import com.jiabiango.hr.model.Demo;
import com.jiabiango.hr.pager.LayPageResult;
import com.jiabiango.hr.pager.PageHelper;

@Service
public class DemoServcie {
    @Autowired
    private DemoMapper demoMapper;

    public LayPageResult<Demo> query(DemoQueryDto query) {
        Page<Demo> page = PageHelper.toPage(query);
        List<Demo> list = demoMapper.query(page,query);
        page.setRecords(list);
        return PageHelper.toLayPageResult(page);
    }

    public Demo get(Integer id) {
        return demoMapper.selectByPrimaryKey(id);
    }

    public void update(Demo demo) {
        demoMapper.updateByPrimaryKeySelective(demo);
        
    }

    public void save(Demo demo) {
        demoMapper.insert(demo);
    }

}
