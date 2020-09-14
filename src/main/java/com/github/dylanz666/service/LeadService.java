package com.github.dylanz666.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.dylanz666.dao.LeadDAO;
import com.github.dylanz666.domain.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 09/11/2020
 */
@Service
@DS(value = "oracle")
public class LeadService {
    @Autowired
    private LeadDAO leadDAO;

    public Lead getLeadByLeadId(Long leadId) {
        return leadDAO.getLeadByLeadId(leadId);
    }
}