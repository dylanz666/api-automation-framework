package com.github.dylanz666.controller;

import com.github.dylanz666.domain.AgentConfig;
import com.github.dylanz666.service.AgentConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author : dylanz
 * @since : 09/14/2020
 */
@RestController
public class AgentConfigController {
    @Autowired
    private AgentConfigService agentConfigService;

    @GetMapping("/agent/config/{id}")
    @ResponseBody
    public Optional<AgentConfig> getAgentConfigById(@PathVariable(name = "id") String id) {
        return agentConfigService.findById(id);
    }
}
