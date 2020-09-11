package com.github.dylanz666.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.dylanz666.dao.ReleaseTeamDAO;
import com.github.dylanz666.domain.ReleaseTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 09/11/2020
 */
@Service
public class ReleaseTeamService {
    @Autowired
    private ReleaseTeamDAO releaseTeamDAO;

    @DS(value = "mysql")
    public ReleaseTeam getReleaseTeamById(int id) {
        return releaseTeamDAO.getReleaseTeamById(id);
    }
}
