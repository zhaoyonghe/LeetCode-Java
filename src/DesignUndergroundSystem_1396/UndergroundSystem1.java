package DesignUndergroundSystem_1396;

import javafx.util.Pair;

import java.util.HashMap;
/**
 * Constructor Time Complexity: O(1)
 * checkIn() Time Complexity: O(1)
 * checkOut() Time Complexity: O(1)
 * getAverageTime() Time Complexity: O(1)
 * Runtime: 139ms
 * Rank: 81.07%
 */
public class UndergroundSystem1 {
    // Important constraints:
    // 1. You may assume all calls to the checkIn and checkOut methods are consistent.
    //    If a customer checks in at time t1 then checks out at time t2, then t1 < t2.
    //    All events happen in chronological order.
    //    There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
    //    (inputs and calls all valid and well-formed)
    HashMap<Pair<String, String>, Pair<Integer, Integer>> averageInfo;
    HashMap<Integer, Pair<String, Integer>> checkedIn;

    public UndergroundSystem1() {
        averageInfo = new HashMap<>();
        checkedIn = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkedIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String endStation, int endTime) {
        Pair<String, Integer> startInfo = checkedIn.get(id);
        checkedIn.remove(id);

        String startStation = startInfo.getKey();
        int startTime = startInfo.getValue();

        Pair<String, String> trip = new Pair<>(startStation, endStation);

        averageInfo.compute(trip, (t, info) -> info == null ? new Pair<>(endTime - startTime, 1) : new Pair<>(info.getKey() + endTime - startTime, info.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        // assumed that it contains something
        Pair<Integer, Integer> tripdata = averageInfo.get(new Pair<>(startStation, endStation));
        return (((double) tripdata.getKey()) / tripdata.getValue());
    }
}