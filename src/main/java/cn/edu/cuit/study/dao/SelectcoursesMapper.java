package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.Selectcourses;
import cn.edu.cuit.study.entity.SelectcoursesExample;
import cn.edu.cuit.study.entity.SelectcoursesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectcoursesMapper {
    long countByExample(SelectcoursesExample example);

    int deleteByPrimaryKey(SelectcoursesKey key);

    int insert(Selectcourses record);

    int insertSelective(Selectcourses record);

    List<Selectcourses> selectByExample(SelectcoursesExample example);

    Selectcourses selectByPrimaryKey(SelectcoursesKey key);

    int updateByExampleSelective(@Param("record") Selectcourses record, @Param("example") SelectcoursesExample example);

    int updateByExample(@Param("record") Selectcourses record, @Param("example") SelectcoursesExample example);

    int updateByPrimaryKeySelective(Selectcourses record);

    int updateByPrimaryKey(Selectcourses record);
}