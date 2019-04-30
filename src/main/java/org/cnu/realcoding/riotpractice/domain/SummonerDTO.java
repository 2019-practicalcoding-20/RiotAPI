package org.cnu.realcoding.riotpractice.domain;

import lombok.Data;

@Data
public class SummonerDTO {
    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private String id;
    private String accountId;
    private long revisionDate;
}
