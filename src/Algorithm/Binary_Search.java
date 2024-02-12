package Algorithm;

public class Binary_Search<T> {
    /** 탐색 - 이진탐색 */
    public Object binarySearch(Object[] array, int size, Object target) {
        int left, right, mid;

        left = 0;
        right = size - 1;

        while(left <= right) {
            mid = (left + right) / 2;

            if((Integer)target == (Integer)array[mid]) return array[mid];
            else if((Integer)target > (Integer)array[mid]) left = mid + 1;
            else right = mid + 1;
        }
        return null;
    }
}
