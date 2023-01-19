package interview.learling.seraching.binarysearch;

/**
 * @author pramitk
 * @project searching
 * @date 19/01/23
 */
public class BinarySearchMain {
    public static void main(String[] args) {

        int[] input = {10, 20, 30, 40, 60, 110, 120, 130, 170};

        System.out.println(binarySearch(input, 170, input.length-1, 0));
        System.out.println(binarySearch(input, 10, input.length-1, 0));
        System.out.println(binarySearch(input, 60, input.length-1, 0));
        System.out.println(binarySearch(input, 190, input.length-1, 0));
        System.out.println(binarySearch(input, 0, input.length-1, 0));

    }

    public static boolean binarySearch(int []input, int number, int high, int low) {

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
