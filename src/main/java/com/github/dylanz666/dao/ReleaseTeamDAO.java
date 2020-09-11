package com.github.dylanz666.dao;

import com.github.dylanz666.domain.ReleaseTeam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author : dylanz
 * @since : 09/11/2020
 */
public interface ReleaseTeamDAO {
    @Select("select * from release_team where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "department", column = "DEPARTMENT"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "updated_by", column = "UPDATED_BY"),
            @Result(property = "updated_when", column = "UPDATED_WHEN")
    })
    ReleaseTeam getReleaseTeamById(@Param("id") int id);
}
