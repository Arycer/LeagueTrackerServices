package me.arycer.leaguetracker.dto.leaguetracker;

import lombok.Getter;

@Getter
public enum Region {
    NA("North America", Policy.AMERICAS, "na1"),
    EUW("Europe West", Policy.EUROPE, "euw1"),
    EUNE("Europe Northern-East", Policy.EUROPE, "eun1"),
    KR("Korea", Policy.ASIA, "kr"),
    BR("Brazil", Policy.AMERICAS, "br1"),
    LAN("Latin America North", Policy.AMERICAS, "la1"),
    LAS("Latin America South", Policy.AMERICAS, "la2");

    private final String descriptor;
    private final Policy policy;
    private final String apiName;

    Region(String descriptor, Policy policy, String apiName) {
        this.descriptor = descriptor;
        this.policy = policy;
        this.apiName = apiName;
    }

    public enum Policy {
        AMERICAS,
        ASIA,
        EUROPE
    }
}
