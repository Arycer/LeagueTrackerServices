package me.arycer.leaguetracker.dto.leaguetracker;

import lombok.Data;
import me.arycer.leaguetracker.dto.riot.league.LeagueEntryDTO;

@Data
public class LTProfileDto {
    private String username;
    private String tagline;
    private long level;
    private int profileIconId;
    private LeagueEntryDTO soloRankedInfo;
    private LeagueEntryDTO flexRankedInfo;
    private String gameVersion;
}
