/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        for (Interval i1 : intervals) {
            for (Interval i2 : intervals) {
                if (i1.equals(i2)) continue;
                if (
                    i1.start == i2.start || i1.end == i2.end ||
                    (i1.start > i2.start && i1.start < i2.end) ||
                    (i1.end > i2.start && i1.end < i2.end)
                ) {
                        return false;
                    }
            }
        }
        return true;
    }
}
