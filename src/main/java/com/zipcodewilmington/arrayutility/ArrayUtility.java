package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;
    T t;

    public ArrayUtility(T[] inputArray) {
        array = inputArray;
        t = null;
    }
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] res = Arrays.copyOf(array, array.length +arrayToMerge.length);
        int count = 0;
        count += getNumberOfOccurrences(valueToEvaluate);

        for (int i = array.length; i < array.length + arrayToMerge.length; i++) {
            res[i] = arrayToMerge[i - array.length];
            if (arrayToMerge[i - array.length].equals(valueToEvaluate)) {
                count++;
            }
        }
        this.array = res;
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Map<T, Integer> counter = new HashMap<>();
        T[] res = Arrays.copyOf(array, array.length +arrayToMerge.length);
        int maxCount = 0;
        T max = null;

        for (int j = 0; j < arrayToMerge.length; j++) {
            res[array.length + j - 1] = arrayToMerge[j];
            int count = counter.getOrDefault(arrayToMerge[j], 0) + 1;
            counter.put(arrayToMerge[j], count);
            if (count > maxCount) {
                maxCount = count;
                max = arrayToMerge[j];
            }
        }

        for (int i = 0; i < array.length; i++) {
            int count = counter.getOrDefault(array[i], 0) + 1;
            counter.put(array[i], count);
            if (count > maxCount) {
                maxCount = count;
                max = array[i];
            }
        }
        return max;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;

        for (int i =0; i < array.length; i++) {
            if (array[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        List<T> res = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                res.add(array[i]);
            }
        }
        T[] resArray = Arrays.copyOf(array, res.size());

        for (int j =0; j < resArray.length; j++) {
            resArray[j] = res.get(j);
        }
        return resArray;
    }
}
