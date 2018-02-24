package com.demo.service;

import com.demo.mapper.DemoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/2/16.
 */
@Service
public class DemoService{

    private final Logger log = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private DemoMapper demoMapper;

    public String test(){
        log.info("测试注入");
        return "测试注入";
    }

    public void testDb() {
        List list = demoMapper.demoSelect();
        log.info("查询到记录："+list.size());
    }

    public PageInfo testDbPage() {
        PageHelper.startPage(2, 10);
        List list = demoMapper.demoPage();
//        用PageInfo对结果进行包装
		PageInfo page = new PageInfo(list);
		System.out.println(page);
        log.info("查询到记录："+list.size());
        return page;
    }
}
