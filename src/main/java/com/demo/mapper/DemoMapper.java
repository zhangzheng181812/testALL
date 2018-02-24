package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by admin on 2017/2/17.
 */
@Mapper
public interface DemoMapper {

    List demoSelect();

    List demoPage();
}
