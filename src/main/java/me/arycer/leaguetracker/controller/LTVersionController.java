package me.arycer.leaguetracker.controller;

import me.arycer.leaguetracker.dto.riot.ddragon.VersionsDTO;
import me.arycer.leaguetracker.service.LTVersionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/league_version")
public class LTVersionController {
    private final LTVersionService versionService;

    public LTVersionController(LTVersionService versionService) {
        this.versionService = versionService;
    }

    @GetMapping("")
    public ResponseEntity<VersionsDTO> getSummonerByName() {
        VersionsDTO versions = versionService.getVersions();
        return ResponseEntity.ok(versions);
    }

    @GetMapping("/latest")
    public ResponseEntity<String> getLatestVersion() {
        VersionsDTO versions = versionService.getVersions();
        return ResponseEntity.ok(versions.getVersions()[0]);
    }
}
