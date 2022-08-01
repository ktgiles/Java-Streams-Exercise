package com.stackroute.streams;
import java.util.*;
import java.util.stream.Collectors;


public class BatsmanService {

    public Optional<Batsman> getBatsman(List<Batsman> batsmanList, String name, String code) throws CountryNotFoundException {
        Optional<Batsman> batsmen = Optional.empty();
        if (batsmanList != null && name != null && code != null) {
            long checkCode = batsmanList.stream().filter(b -> b.getCountry().getCountryCode().equalsIgnoreCase(code)).count();
            long checkBatsman = batsmanList.stream().filter(n -> n.getName().equalsIgnoreCase(name)).count();
            if (checkCode == 0) {
                throw new CountryNotFoundException();
            }
            if (checkBatsman == 0) {
                //don't change batsmen
            } else {
                batsmen = batsmanList.stream()
                        .filter(b -> b.getName().equalsIgnoreCase(name))
                        .filter(co -> co.getCountry().getCountryCode().equalsIgnoreCase(code))
                        .findFirst();
            }
        }
        return batsmen;
    }

    public String getBatsmanNamesForCountry(List<Batsman> batsmanList, String code) {
        String result = null;
        if ((batsmanList != null && code != null) && batsmanList.size() > 0) {
            result = batsmanList.stream()
                    .filter(co -> co.getCountry().getCountryCode().equalsIgnoreCase(code))
                    .map(String::valueOf)
                    .sorted()
                    .collect(Collectors.joining(",", "[", "]"));
        }
        return result;
    }

    public Map<String, Integer> getPlayerNameWithTotalRuns(List<Batsman> batsmanList) {
        Map<String, Integer> result = Collections.emptyMap();
        if (batsmanList != null && batsmanList.size() > 0) {
            result = batsmanList.stream()
                    .collect(Collectors.toMap(
                            Batsman::getName,
                            Batsman::getTotalRuns));
        }
        return result;
    }

    public Integer getHighestRunsScoredByBatsman(List<Batsman> batsmanList, String country) {
        int result = 0;
        if (batsmanList != null && batsmanList.size() > 0) {
            Batsman highest = batsmanList.stream()
                    .filter(co -> co.getCountry().getName().equalsIgnoreCase(country))
                    .max(Comparator.comparing(Batsman::getHighestScore))
                    .get();
            result = highest.getHighestScore();
        }
        return result;
    }

    public Optional<List<String>> getPlayerNamesByCountry(List<Batsman> batsmanList, String country){

        if (batsmanList != null && country != null && !batsmanList.isEmpty()) {
            List<String> result = batsmanList.stream() //batsmanList to stream
                    .filter(co -> co.getCountry().getName().equalsIgnoreCase(country)) //filter by country
                    .filter(batsman -> batsman.getTotalRuns() > 5000)
                    .map(Batsman::getName)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toCollection(LinkedList::new));
            if (!result.isEmpty()) {
                return Optional.of(result);
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
     }
}


//          In this problem, cricket batsman data has to searched, analyzed and extracted from given input collections, based on the criteria given below
//
//          - Following functionality needs to be implemented
//
//          - Search the batsman with the given name and country code
//          - Provide the sorted batsman names in a string for the given country code, as per expected format in provided test
//          - Provide player names and total runs Scored as a pair, for players who have played more than 50 matches
//          - Provide the highest runs scored by batsman for a given country name
//          - Provide a list of player names for a given country who have scored more than 5000 runs, in descending order
//
//          **NOTE: ALL THE METHODS SHOULD BE IMPLEMENTED USING STREAMS API ONLY**