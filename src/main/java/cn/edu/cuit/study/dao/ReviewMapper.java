package cn.edu.cuit.study.dao;

import cn.edu.cuit.study.entity.Review;
import cn.edu.cuit.study.entity.ReviewExample;
import cn.edu.cuit.study.entity.ReviewKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewMapper {
    long countByExample(ReviewExample example);

    int deleteByPrimaryKey(ReviewKey key);

    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(ReviewKey key);

    int updateByExampleSelective(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByExample(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
}