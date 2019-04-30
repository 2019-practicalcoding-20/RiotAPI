package org.cnu.realcoding.riotpractice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class LeaguePositionDTOApiClient {
    @Autowired
    private RestTemplate restTemplate;
    private final String apiKey = "RGAPI-504c9e37-6e3b-4913-ae19-c194c8941431";
    private final String leaguePositionUri = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key={apiKey}";

    public LinkedHashMap getLeaguePositionDTO(String encryptedSummonerId) {
        List<LinkedHashMap> leaguePositionDTOList = restTemplate.exchange(leaguePositionUri, HttpMethod.GET, null, List.class, encryptedSummonerId, apiKey)
                .getBody();

        return leaguePositionDTOList.get(0); //leaguePositionDTO.get(0);
    }
}
