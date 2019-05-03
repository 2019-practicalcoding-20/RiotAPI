package org.cnu.realcoding.riotpractice.controller;


import org.cnu.realcoding.riotpractice.domain.LeaguePositionDTO;
import org.cnu.realcoding.riotpractice.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/riot-practice

@RestController
@RequestMapping("/riot-practice")
public class SummonerController {
    @Autowired
    private SummonerService summonerService;

    @GetMapping("/league-position/{summonerName}")
    public List<LeaguePositionDTO> getLeaguePositionDTO(@PathVariable String summonerName) {
        return summonerService.getLeaguePositionDTO(summonerName);
    }

}
