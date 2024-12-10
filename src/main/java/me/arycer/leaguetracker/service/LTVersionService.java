package me.arycer.leaguetracker.service;

import me.arycer.leaguetracker.client.RiotApiClient;
import me.arycer.leaguetracker.dto.riot.ddragon.VersionsDTO;
import org.springframework.stereotype.Service;

@Service
public class LTVersionService {
    private final RiotApiClient riotApiClient;

    public LTVersionService(RiotApiClient riotApiClient) {
        this.riotApiClient = riotApiClient;
    }

    public VersionsDTO getVersions() {
        return riotApiClient.fetchVersions();
    }
}
