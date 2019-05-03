package org.cnu.realcoding.riotpractice.domain;

import lombok.Data;

@Data
public class LeaguePositionDTO {
    private String tier;
    private String summonerName;
    private boolean hotStreak;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String leagueName;
    private boolean inactive;
    private boolean freshBlood;
    private String position;
    private String leagueId;
    private String queueType;
    private String summonerId;
    private int leaguePoints;
    private String progress;
    private int target;
    private MiniSeriesDTO miniSeries;

    @Data
    public static class MiniSeriesDTO {
    }
}
