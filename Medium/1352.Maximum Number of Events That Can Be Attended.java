import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by their start day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 1, i = 0, n = events.length, attended = 0;

        // Find the last day among all events
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        // Loop through each day
        while (day <= maxDay) {
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]); // add end day
                i++;
            }

            // Remove events that already expired
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }

            day++;
        }

        return attended;
    }
}
