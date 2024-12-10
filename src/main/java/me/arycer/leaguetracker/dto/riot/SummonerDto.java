package me.arycer.leaguetracker.dto.riot;

import lombok.Data;

@Data
public class SummonerDto {
    private String id;
    private String name;
    private int profileIconId;
    private long summonerLevel;
}