package com.github.dylanz666.dao;

import com.github.dylanz666.domain.Lead;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author : dylanz
 * @since : 09/11/2020
 */
public interface LeadDAO {
    @Select("select lead_id,email from lead where lead_id = #{leadId}")
    @Results(value = {
            @Result(property = "leadId", column = "LEAD_ID"),
            @Result(property = "email", column = "EMAIL")
    })
    Lead getLeadByLeadId(@Param("leadId") Long leadId);
}