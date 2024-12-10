package me.arycer.leaguetracker.dto;

import lombok.Data;

@Data
public class RiotAccountDto {
    private String puuid;
    private String gameName;
    private String tagLine;

    public String getRiotId() {
        return "%s#%s".formatted(gameName, tagLine);
    }
}
