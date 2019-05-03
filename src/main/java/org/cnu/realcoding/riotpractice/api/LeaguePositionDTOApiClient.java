package org.cnu.realcoding.riotpractice.api;

import org.cnu.realcoding.riotpractice.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LeaguePositionDTOApiClient {
    @Autowired
    private RestTemplate restTemplate;
    private final String apiKey = "RGAPI-504c9e37-6e3b-4913-ae19-c194c8941431";
    private final String leaguePositionUri = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key={apiKey}";

    private final ParameterizedTypeReference<List<LeaguePositionDTO>> responseType = new ParameterizedTypeReference<List<LeaguePositionDTO>>() {};

    public List<LeaguePositionDTO> getLeaguePositionDTO(String encryptedSummonerId) {
        List<LeaguePositionDTO> leaguePositionDTOList = restTemplate.exchange(leaguePositionUri, HttpMethod.GET, null, responseType, encryptedSummonerId, apiKey)
                .getBody();

        return leaguePositionDTOList;
    }
}
