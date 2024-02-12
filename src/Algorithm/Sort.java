package Algorithm;

public class Sort {
    /** 정렬 - 버블정렬 */
    public static Object[] bubbleSort(Object[] array) {
        Object[] result = array;
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result.length-(i+1); j++) {
                if((Integer)result[j] > (Integer)result[j+1]) {
                    Object temp = result[j+1];
                    result[j+1] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;
    }



    /** 정렬 - 선택정렬 */
    public static Object[] selectionSort(Object[] array) {
        Object[] result = array;
        for(int i = 0; i < result.length-1; i++) {
            int indexMin = i;
            for(int j = i + 1; j < result.length; j++) {
                if((Integer)result[j] < (Integer)result[indexMin]) {
                    indexMin = j;
                }
            }
            Object temp = result[indexMin];
            result[indexMin] = result[i];
            result[i] = temp;
        }
        return result;
    }



    /** 정렬 - 삽입정렬 */
    public static Object[] insertionSort(Object[] array) {
        Object[] result = array;
        for(int i = 1; i < result.length; i++) {
            Object value = result[i];
            int j = i - 1;
            while(j >= 0 && (Integer)result[j] > (Integer)value) {
                result[j + 1] = result[j];
                j--;
            }
            result[j + 1] = value;
        }
        return result;
    }



    /** 정렬 - 퀵정렬 */
    public static Object[] quickSort(Object[] array, int left, int right) {
        Object[] result = array;

        if(left < right) {
            int index = partition(result, left, right);

            quickSort(result, left, index-1);
            quickSort(result, index+1, right);
        }

        return result;
    }
    private static int partition(Object[] array, int left, int right) {
        int first = left;
        Integer pivot = (Integer)array[first];

        ++left;

        while(left <= right) {
            while((Integer)array[left] <= pivot && left < right) {
                ++left;
            }
            while((Integer)array[right] >= pivot && left <= right) {
                --right;
            }
            if(left < right) {
                Object temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            else break;
        }
        Object temp = array[first];
        array[first] = array[right];
        array[right] = temp;

        return right;
    }
}
