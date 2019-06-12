package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.Category;

public interface CategoryMapper {

    int deleteByPrimaryKey(Integer categoryid);

    int insert(Category record);

    int insertSelective(Category record);


    Category selectByPrimaryKey(Integer categoryid);


    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}