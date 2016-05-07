package util;

/**
 *
 * @author Sourabh Bhat
 */
public class AllPossibilities {

    private final int[] limits;  // For storing limit of the numbers at each index
    private final int[] numbers; // For storing the current possibility

    public AllPossibilities(int[] limits) {
        this.limits = limits;
        // check that all limits are positive
        for (int i = 0; i < limits.length; i++) {
            if (limits[i] <= 0) {
                throw new IllegalArgumentException("Limits must be greater than zero");
            }
        }

        this.numbers = new int[limits.length];
        this.numbers[0] = -1; // So that the first returned value is [0, 0, 0 ...., 0]
    }

    private void increment(int index) throws NoMorePossibilitiesException {
        if (numbers[index] + 1 == limits[index]) { // index reached the max limit
            if (index == limits.length - 1) {      // last element reached the max limit
                throw new NoMorePossibilitiesException("No more possibilities remaining!");
            }
            numbers[index] = 0;
            increment(index + 1);
        } else { // index has not reached the max limit yet
            numbers[index] += 1;
        }
    }

    /**
     * Get the next possible combination of int's in range [0, limit)
     * @return array of next possible numbers or null if no more possibilities
     */
    public int[] getNext() {
        try {
            increment(0);
        } catch (NoMorePossibilitiesException ex) {
            return null;
        }
        return numbers;
    }
}
