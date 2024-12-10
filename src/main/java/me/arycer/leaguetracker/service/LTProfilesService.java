package me.arycer.leaguetracker.service;

import me.arycer.leaguetracker.client.RiotApiClient;
import me.arycer.leaguetracker.dto.leaguetracker.LTProfileDto;
import me.arycer.leaguetracker.dto.riot.LeagueEntryDTO;
import me.arycer.leaguetracker.dto.riot.RiotAccountDto;
import me.arycer.leaguetracker.dto.riot.SummonerDto;
import org.springframework.stereotype.Service;

@Service
public class LTProfilesService {

    private final RiotApiClient riotApiClient;

    public LTProfilesService(RiotApiClient riotApiClient) {
        this.riotApiClient = riotApiClient;
    }

    public LTProfileDto getProfile(String accountName, String tagline) {
        RiotAccountDto riotAccount = riotApiClient.fetchRiotAccount(accountName, tagline);
        SummonerDto summoner = riotApiClient.fetchSummonerByPuuid(riotAccount.getPuuid());

        LTProfileDto ltProfileDto = new LTProfileDto();
        ltProfileDto.setUsername(riotAccount.getGameName());
        ltProfileDto.setTagline(riotAccount.getTagLine());
        ltProfileDto.setProfileIconId(summoner.getProfileIconId());
        ltProfileDto.setLevel(summoner.getSummonerLevel());

        LeagueEntryDTO[] leagueEntries = riotApiClient.fetchLeagueEntries(summoner.getId());

        LeagueEntryDTO soloQ = null;
        for (LeagueEntryDTO leagueEntry : leagueEntries) {
            if (leagueEntry.getQueueType().equals("RANKED_SOLO_5x5")) {
                soloQ = leagueEntry;
                break;
            }
        }

        LeagueEntryDTO flexQ = null;
        for (LeagueEntryDTO leagueEntry : leagueEntries) {
            if (leagueEntry.getQueueType().equals("RANKED_FLEX_SR")) {
                flexQ = leagueEntry;
                break;
            }
        }

        if (soloQ != null) {
            ltProfileDto.setSoloRankedInfo(soloQ);
        }

        if (flexQ != null) {
            ltProfileDto.setFlexRankedInfo(flexQ);
        }

        return ltProfileDto;
    }
}