package interview.learling.seraching.binarysearch;

/**
 * @author pramitk
 * @project searching
 * @date 19/01/23
 */
public class BinarySearch {

    public boolean binarySearch(int []input, int number, int high, int low) {

        if (low > high) return false;

        else {
            int mid = (high + low) / 2;

            if (input[mid] == number) return true;

            else if (number > input[mid]) return binarySearch(input, number, high, mid+1);

            else if (number < input[mid]) return binarySearch(input, number, mid -1, low);

        }

        return false;
    }
}
