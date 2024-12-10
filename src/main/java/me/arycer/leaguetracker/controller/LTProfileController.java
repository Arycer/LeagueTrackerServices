package me.arycer.leaguetracker.controller;

import me.arycer.leaguetracker.dto.leaguetracker.LTProfileDto;
import me.arycer.leaguetracker.dto.leaguetracker.Region;
import me.arycer.leaguetracker.service.LTProfilesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class LTProfileController {

    private final LTProfilesService profilesService;

    public LTProfileController(LTProfilesService profilesService) {
        this.profilesService = profilesService;
    }

    @GetMapping("/{region}/{accountName}/{tagline}")
    public ResponseEntity<LTProfileDto> getSummonerByName(@PathVariable String region, @PathVariable String accountName, @PathVariable String tagline) {
        Region regionEnum = Region.valueOf(region.toUpperCase());
        LTProfileDto summoner = profilesService.getProfile(regionEnum, accountName, tagline);
        return ResponseEntity.ok(summoner);
    }
}