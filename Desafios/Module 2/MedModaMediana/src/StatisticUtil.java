import java.util.Arrays;

public class StatisticUtil {

    public static int average(int[] elements) {
        int sum = 0;
        for (int element : elements){
            sum += element;
        }
        return sum / elements.length;
    }

    public static int mode(int[] elements) {
        int maxValue = 0;
        int maxCount = 0;

        for (int i = 0; i < elements.length; ++i) {
            int count = 0;
            for (int j = 0; j < elements.length; ++j) {
                if (elements[j] == elements[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = elements[i];
            }
        }

        return maxValue;
    }

    public static int median(int[] elements) {
        Arrays.sort(elements);
        int middle = elements.length/2;
        if (elements.length%2 == 1) {
            return elements[middle];
        } else {
            return (int) ((elements[middle-1] + elements[middle]) / 2.0);
        }

    }
}
