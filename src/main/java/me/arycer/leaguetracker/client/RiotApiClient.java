package me.arycer.leaguetracker.client;

import me.arycer.leaguetracker.config.ApiKeyLoader;
import me.arycer.leaguetracker.dto.leaguetracker.Region;
import me.arycer.leaguetracker.dto.riot.ddragon.VersionsDTO;
import me.arycer.leaguetracker.dto.riot.league.LeagueEntryDTO;
import me.arycer.leaguetracker.dto.riot.account.RiotAccountDto;
import me.arycer.leaguetracker.dto.riot.account.SummonerDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RiotApiClient {
    private final RestTemplate restTemplate;

    public RiotApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SummonerDto fetchSummonerByPuuid(Region region, String puuid) {
        String url = "https://%s.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/%s?api_key=%s"
                .formatted(region.getApiName(), puuid, ApiKeyLoader.getApiKey());
        return restTemplate.getForObject(url, SummonerDto.class);
    }

    public RiotAccountDto fetchRiotAccount(Region region, String accountName, String tagline) {
        String url = "https://%s.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s?api_key=%s".formatted(
                region.getPolicy().toString().toLowerCase(), accountName, tagline, ApiKeyLoader.getApiKey());
        return restTemplate.getForObject(url, RiotAccountDto.class);
    }

    public LeagueEntryDTO[] fetchLeagueEntries(Region region, String encryptedSummonerId) {
        String url = "https://%s.api.riotgames.com/lol/league/v4/entries/by-summoner/%s?api_key=%s"
                .formatted(region.getApiName(), encryptedSummonerId, ApiKeyLoader.getApiKey());
        return restTemplate.getForObject(url, LeagueEntryDTO[].class);
    }

    public VersionsDTO fetchVersions() {
        String url = "https://ddragon.leagueoflegends.com/api/versions.json";
        String[] versions = restTemplate.getForObject(url, String[].class);
        VersionsDTO versionsDTO = new VersionsDTO();
        versionsDTO.setVersions(versions);
        return versionsDTO;
    }
}