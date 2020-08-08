package hw3.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /*
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        Map<Integer, Integer> map = new HashMap<>();
        int min = oomages.size() / 50;
        int max = (int) (oomages.size() / 2.5);

        for (Oomage o: oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            if (map.containsKey(bucketNum)) {
                map.put(bucketNum, map.get(bucketNum) + 1);
            } else {
                map.put(bucketNum, 1);
            }
        }

        for (int i: map.values()) {
            if (i > max || i < min) {
                return false;
            }
        }
        return true;
    }
}
