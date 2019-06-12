package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.LogExample;
import cn.edu.cuit.study.entity.LogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    long countByExample(LogExample example);

    int deleteByPrimaryKey(LogKey key);

    int insert(LogKey record);

    int insertSelective(LogKey record);

    List<LogKey> selectByExample(LogExample example);

    int updateByExampleSelective(@Param("record") LogKey record, @Param("example") LogExample example);

    int updateByExample(@Param("record") LogKey record, @Param("example") LogExample example);
}