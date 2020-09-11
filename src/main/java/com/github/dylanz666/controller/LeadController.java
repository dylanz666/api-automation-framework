package com.github.dylanz666.controller;

import com.github.dylanz666.domain.Lead;
import com.github.dylanz666.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : dylanz
 * @since : 09/11/2020
 */
@RestController
public class LeadController {
    @Autowired
    private LeadService leadService;

    @GetMapping("/lead/{leadId}")
    @ResponseBody
    public Lead getLead(@PathVariable(name = "leadId") Long leadId) {
        return leadService.getLeadByLeadId(leadId);
    }
}
