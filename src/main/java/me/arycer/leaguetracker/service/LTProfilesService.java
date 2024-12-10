package me.arycer.leaguetracker.service;

import me.arycer.leaguetracker.client.RiotApiClient;
import me.arycer.leaguetracker.dto.riot.RiotAccountDto;
import org.springframework.stereotype.Service;

@Service
public class RiotAccountService {

    private final RiotApiClient riotApiClient;

    public RiotAccountService(RiotApiClient riotApiClient) {
        this.riotApiClient = riotApiClient;
    }

    public RiotAccountDto getRiotAccount(String accountName, String tagline) {
        return riotApiClient.fetchRiotAccount(accountName, tagline);
    }
}