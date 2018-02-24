package com.demo.controller;

import com.demo.LogRepository;
import com.demo.SiteConfig;
import com.demo.entity.Log;
import com.demo.service.DemoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 返回json串
 * Created by admin on 2017/2/15.
 */
@RestController
public class DemoRestController {


    @Autowired
    private DemoService demoService;

    @Autowired
    private SiteConfig siteConfig;

    @Autowired
    private LogRepository logRepository;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/testRest")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/testProperties")
    public String testProperties() {
        return siteConfig.getName();
    }

    @RequestMapping("/testDb")
    public String testDb() {
        demoService.testDb();
        return "Hello World";
    }

    @RequestMapping("/testDbPage")
    public PageInfo testDbPage() {
        PageInfo p = demoService.testDbPage();
        return p;
    }

    @RequestMapping("/testJpa")
    public List<Log> test(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable =  new PageRequest(1, 10, sort);
        List<Log> log = logRepository.findById(pageable);
        System.out.println(log);
        return log;
    }

}
