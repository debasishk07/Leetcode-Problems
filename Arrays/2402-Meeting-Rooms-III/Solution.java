import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] count = new int[n]; // meetings handled per room
        long[] timer = new long[n]; // when each room becomes free

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            int availableRoom = -1;
            long earliestTime = Long.MAX_VALUE;
            int earliestRoom = -1;

            for (int i = 0; i < n; i++) {
                if (timer[i] < earliestTime) {
                    earliestTime = timer[i];
                    earliestRoom = i;
                }
                if (timer[i] <= start) {
                    availableRoom = i;
                    break;
                }
            }

            if (availableRoom != -1) {
                timer[availableRoom] = end;
                count[availableRoom]++;
            } else {
                timer[earliestRoom] += duration;
                count[earliestRoom]++;
            }
        }

        int maxMeetings = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxMeetings) {
                maxMeetings = count[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}