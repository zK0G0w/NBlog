package top.naccl.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.naccl.entity.Slogan;

import java.util.List;


/**
 * @Description:
 * @Author: WainZeng
 * @Date: 2024/9/27 14:34
 */

@Mapper
@Repository
public interface SloganMapper {

    void insertSlogan(Slogan slogan);

    List<Slogan> getAllSlogans();
}
