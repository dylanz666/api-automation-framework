package com.github.dylanz666.controller;

import com.github.dylanz666.domain.ReleaseTeam;
import com.github.dylanz666.service.ReleaseTeamService;
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
public class ReleaseTeamController {
    @Autowired
    private ReleaseTeamService releaseTeamService;

    @GetMapping("/release/team/{id}")
    @ResponseBody
    public ReleaseTeam getReleaseTeam(@PathVariable(name = "id") int id) {
        return releaseTeamService.getReleaseTeamById(id);
    }
}
