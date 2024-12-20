package DesignUndergroundSystem_1396;

import java.util.HashMap;

/**
 * $$ Constructor Time Complexity: O(1)
 * $$ checkIn() Time Complexity: O(1)
 * $$ checkOut() Time Complexity: O(1)
 * $$ getAverageTime() Time Complexity: O(1)
 */
public class UndergroundSystem1 {
    class Record {
        String location;
        int time;
        Record(String location, int time) {
            this.location = location;
            this.time = time;
        }
    }

    HashMap<String, int[]> averageInfo;
    HashMap<Integer, Record> checkedIn;

    public UndergroundSystem1() {
        averageInfo = new HashMap<>();
        checkedIn = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkedIn.put(id, new Record(stationName, t));
    }

    public void checkOut(int id, String endStation, int endTime) {
        Record startInfo = checkedIn.get(id);
        checkedIn.remove(id);

        String startStation = startInfo.location;
        int startTime = startInfo.time;

        String trip = String.format("%s-%s", startStation, endStation);
        if (!averageInfo.containsKey(trip)) {
            averageInfo.put(trip, new int[]{0,0});
        }
        int[] tripData = averageInfo.get(trip);
        tripData[0] += endTime - startTime;
        tripData[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] tripData = averageInfo.get(String.format("%s-%s", startStation, endStation));
        return (((double) tripData[0]) / tripData[1]);
    }
}