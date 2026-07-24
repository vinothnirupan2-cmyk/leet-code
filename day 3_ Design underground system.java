class UndergroundSystem {
    // Tracks a customer currently in transit: id -> [startStation, checkInTime]
    private final Map<Integer, Pair<String, Integer>> checkIns;
    // Tracks totals per route: "start->end" -> [totalTime, tripCount]
    private final Map<String, double[]> routeStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> entry = checkIns.remove(id);
        String startStation = entry.getKey();
        int startTime = entry.getValue();

        String route = startStation + "->" + stationName;
        double[] stats = routeStats.getOrDefault(route, new double[]{0, 0});
        stats[0] += (t - startTime); // total time
        stats[1] += 1;               // trip count
        routeStats.put(route, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        double[] stats = routeStats.get(route);
        return stats[0] / stats[1];
    }
}