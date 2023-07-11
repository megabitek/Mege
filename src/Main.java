import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int[] arrayA = new int[] {1, 25, 3,2,1,84, 12, 6,3,1,2, 8};
        MergeSort (arrayA);
       Arrays.stream(arrayA).forEach(s->System.out.println(s));
    }

    private  static  void MergeSort(int[] a) {
        if (a.length<=1) return;
        {
            int mid = a.length / 2;
            int[] left = new int[mid];
            int[] right = new int[a.length - mid];

            for (int i = 0; i < mid; i++)
                left[i]= a[i];
            for (int i = mid; i < a.length; i++)
                right[i-mid]= a[i];
            MergeSort(left);
            MergeSort(right);
            Merge(a, left, right);
        }

    }
     private static void Merge(int[] targetArray, int [] array1, int[] array2) {
         int array1MinIndex = 0;
         int array2MinIndex = 0;

         int targetArrayMinIndex = 0;
         while (array1MinIndex < array1.length && array2MinIndex < array2.length) {// пока какой то из массивов не кончился
             if (array1[array1MinIndex] <= array2[array2MinIndex]) { // если левый элемент 1 массива  меньше или равен левого элемента второго массива
                 targetArray[targetArrayMinIndex] = array1[array1MinIndex]; // записываем его в результирующий массив
                 array1MinIndex++; // сдвигаем счетчик крайнего левого элемента на 1
             } else {
                 targetArray[targetArrayMinIndex] = array2[array2MinIndex]; // если меньше левый элемент второго массива добавляем его

                 array2MinIndex++; // сдивгаем счетчик крайнего левого элемента второго массива на 1
             }
             targetArrayMinIndex++; // сдвигаем счетчик результирующего элемента на 1
         }
         while (array1MinIndex<array1.length) {// если в первом массиве остались элементы записываем в результирующий массив
             targetArray[targetArrayMinIndex] = array1[array1MinIndex];
             array1MinIndex++;
             targetArrayMinIndex++;
         }
    while (array2MinIndex<array2.length) { // если во втором записываем их
        targetArray[targetArrayMinIndex] = array2[array2MinIndex];
        array2MinIndex++;
        targetArrayMinIndex++;
    }
     }}
