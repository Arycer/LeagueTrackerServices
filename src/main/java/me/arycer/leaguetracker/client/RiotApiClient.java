package me.arycer.leaguetracker.client;

import me.arycer.leaguetracker.config.ApiKeyLoader;
import me.arycer.leaguetracker.dto.riot.LeagueEntryDTO;
import me.arycer.leaguetracker.dto.riot.RiotAccountDto;
import me.arycer.leaguetracker.dto.riot.SummonerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RiotApiClient {

    private final RestTemplate restTemplate;

    public RiotApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SummonerDto fetchSummonerByPuuid(String puuid) {
        String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/%s?api_key=%s".formatted(puuid, ApiKeyLoader.getApiKey());
        return restTemplate.getForObject(url, SummonerDto.class);
    }

    public RiotAccountDto fetchRiotAccount(String accountName, String tagline) {
        String url = "https://%s.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s".formatted(
                "europe", accountName, tagline, ApiKeyLoader.getApiKey());
        return restTemplate.getForObject(url, RiotAccountDto.class);
    }

    public LeagueEntryDTO[] fetchLeagueEntries(String encryptedSummonerId) {
        String url = "https://euw1.api.riotgames.com/lol/league/v4/entries/by-summoner/%s?api_key=%s".formatted(encryptedSummonerId, ApiKeyLoader.getApiKey());
        return restTemplate.getForObject(url, LeagueEntryDTO[].class);
    }
}