package org.cnu.realcoding.riotpractice.service;

import lombok.extern.slf4j.Slf4j;
import org.cnu.realcoding.riotpractice.api.LeaguePositionDTOApiClient;
import org.cnu.realcoding.riotpractice.api.SummonerDTOApiClient;
import org.cnu.realcoding.riotpractice.domain.LeaguePositionDTO;
import org.cnu.realcoding.riotpractice.domain.SummonerDTO;
import org.cnu.realcoding.riotpractice.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@Slf4j
public class SummonerService {
    @Autowired
    private SummonerDTOApiClient summonerDTOApiClient;
    @Autowired
    private LeaguePositionDTOApiClient leaguePositionDTOApiClient;
    @Autowired
    private SummonerRepository summonerRepository;

    private String getEncryptedSummonerId(String summonerName) {
        SummonerDTO summonerDTO = summonerDTOApiClient.getSummonerDTO(summonerName);
        return summonerDTO.getId();
    }

    public List<LeaguePositionDTO> getLeaguePositionDTO(String summonerName) {
        String encryptedSummonerId = getEncryptedSummonerId(summonerName);
        List<LeaguePositionDTO> leaguePositionDTOs = leaguePositionDTOApiClient.getLeaguePositionDTO(encryptedSummonerId);
        summonerRepository.insertLeaguePositionDTOs(leaguePositionDTOs);
        log.info("LeaguePosition has inserted successfully. LeaguePosition : {}", leaguePositionDTOs);
        return leaguePositionDTOs;
    }
}
