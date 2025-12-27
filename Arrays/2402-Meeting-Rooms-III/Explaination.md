# Meeting Rooms III (LeetCode)

## Problem Statement

You are given:

* An integer **n** representing the number of rooms (0 to n−1)
* A 2D array **meetings**, where `meetings[i] = [start_i, end_i)`

Rules:

1. Each meeting is assigned to the **lowest-numbered unused room**.
2. If no room is free, the meeting is **delayed** until a room becomes free.
3. A delayed meeting keeps the **same duration**.
4. When multiple meetings are waiting, the one with the **earlier original start time** gets priority.

Return the room number that hosted the **most meetings**. If there is a tie, return the **lowest room number**.

---

## Key Idea

Simulate the meeting allocation **in chronological order** while tracking:

* When each room becomes free
* How many meetings each room hosts

---

## Approach Overview

1. Sort meetings by start time
2. Track room availability using arrays
3. Assign meetings greedily
4. Delay meetings if needed
5. Count room usage and return the most-used room

---

## Java Solution

```java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] count = new int[n];       // meetings handled per room
        long[] timer = new long[n];     // when each room becomes free

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
```

---

## Step-by-Step Explanation

### 1. Sorting Meetings

Meetings are sorted by start time to ensure that earlier meetings are processed first.

### 2. Data Structures

* `timer[i]`: next free time of room `i`
* `count[i]`: number of meetings handled by room `i`

### 3. Room Allocation Logic

For each meeting:

* If a room is free (`timer[i] <= start`), assign the meeting to the **lowest-numbered room**.
* Otherwise, delay the meeting until the **earliest finishing room** becomes available.

### 4. Delay Handling

If delayed, the meeting starts when the room becomes free and ends after the same duration.

### 5. Final Answer

Return the room with the highest meeting count. Ties are resolved by choosing the lowest room index.

---

## Example

**Input:**

```
n = 2
meetings = [[0,10],[1,5],[2,7],[3,4]]
```

**Output:**

```
0
```

Both rooms host 2 meetings, so room 0 is returned.

---

## Time & Space Complexity

* **Time:** O(m log m + n × m)
* **Space:** O(n)

Where `m` is the number of meetings and `n ≤ 100`.

---

## Notes

* This is a simulation-based solution.
* Can be optimized using priority queues to achieve O(m log n).

---

## Summary

This solution simulates real-time meeting allocation while strictly following problem constraints. It prioritizes lower room numbers, correctly delays meetings, and tracks usage to identify the most booked room.
