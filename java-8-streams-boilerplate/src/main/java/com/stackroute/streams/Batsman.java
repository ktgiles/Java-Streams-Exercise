package com.stackroute.streams;


import java.util.Locale;



public class Batsman {
    String name;
    int matchesPlayed;
    int totalRuns;
    int highestScore;
    Country country;
    String countryCode;
    String countryName;

    public Batsman() {

    }

    public Batsman (String name, int matchesPlayed, int totalRuns, int highestScore, Country country){
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.totalRuns = totalRuns;
        this.highestScore = highestScore;
        this.country = country;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name;
    }
}