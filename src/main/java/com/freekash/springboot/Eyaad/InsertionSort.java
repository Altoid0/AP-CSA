package com.freekash.springboot.Eyaad;
import java.util.Arrays;
public class InsertionSort {
    public Integer[] sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public String[] sort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (key.compareTo(arr[j]) > 0) {
                    break;
                }
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public Book[] sort(Book[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Book key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (key.getTitle().compareTo(arr[j].getTitle()) > 0) {
                    break;
                }
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public int[] bsort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] selectSort(int[] arr) {

        for (int i = 0; i < arr.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public String returnSort(Integer[] arr) {
        Integer[] arrr = sort(arr);
        String answer = "";
        answer+="[";
        for (int i = 0; i < arrr.length - 1; i++) {
            answer+=arrr[i];
            answer+=", ";
        }
        answer+=arrr[arrr.length-1];
        answer+="]";
        return answer;
    }

    public String returnSort(String[] arr) {
        String[] arrr = sort(arr);
        String answer = "";
        answer+="[";
        for (int i = 0; i < arrr.length - 1; i++) {
            answer+=arrr[i];
            answer+=", ";
        }
        answer+=arrr[arrr.length-1];
        answer+="]";
        return answer;
    }


}
