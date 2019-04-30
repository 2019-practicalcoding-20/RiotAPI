package org.cnu.realcoding.riotpractice.api;

import org.cnu.realcoding.riotpractice.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SummonerDTOApiClient {
    @Autowired
    private RestTemplate restTemplate;
    private final String apiKey = "RGAPI-504c9e37-6e3b-4913-ae19-c194c8941431";
    private final String encryptedSummonerIdUri = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apiKey}";

    public SummonerDTO getSummonerDTO(String summonerName) {
        SummonerDTO summonerDTO = restTemplate.exchange(encryptedSummonerIdUri, HttpMethod.GET, null, SummonerDTO.class, summonerName, apiKey)
                .getBody();
        return summonerDTO;
    }
}
