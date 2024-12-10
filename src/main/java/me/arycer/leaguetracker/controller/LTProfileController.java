package me.arycer.leaguetracker.controller;

import me.arycer.leaguetracker.dto.RiotAccountDto;
import me.arycer.leaguetracker.dto.SummonerDto;
import me.arycer.leaguetracker.service.RiotAccountService;
import me.arycer.leaguetracker.service.SummonerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/riot-account")
public class RiotAccountController {

    private final RiotAccountService riotService;

    public RiotAccountController(RiotAccountService riotService) {
        this.riotService = riotService;
    }

    @GetMapping("/{accountName}/{tagline}")
    public ResponseEntity<RiotAccountDto> getSummonerByName(@PathVariable String accountName, @PathVariable String tagline) {
        RiotAccountDto summoner = riotService.getRiotAccount(accountName, tagline);
        return ResponseEntity.ok(summoner);
    }
}