package lesson_2026_04_09.homework;
import java.util.Random;

class UniversalArray {
    int size;
    int[] arrayUniv;


    UniversalArray(int size) {
        this.size = size;
        this.arrayUniv = new int[size];
    }


    void initArray() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arrayUniv[i] = rand.nextInt(21);
        }
    }

    void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(arrayUniv[i] + " ");
        }
        System.out.println();
    }


    int min() {
        int minimum = arrayUniv[0];
        for (int i = 1; i < size; i++) {
            if (arrayUniv[i] < minimum) {
                minimum = arrayUniv[i];
            }
        }
        return minimum;
    }

    int max() {
        int maximum = arrayUniv[0];
        for (int i = 1; i < size; i++) {
            if (arrayUniv[i] > maximum) {
                maximum = arrayUniv[i];
            }

        }
        return maximum;
    }

    void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arrayUniv[j] > arrayUniv[j + 1]) {
                    int temp = arrayUniv[j];
                    arrayUniv[j] = arrayUniv[j + 1];
                    arrayUniv[j + 1] = temp;
                }
            }
        }
    }

    void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minindex = i;
            for (int j = i + 1; j < size; j++) {

                if (arrayUniv[j] < arrayUniv[minindex]) {
                    minindex = j;
                }
            }
            int temp = arrayUniv[minindex];
            arrayUniv[minindex] = arrayUniv[i];
            arrayUniv[i] = temp;

        }
    }

    public void mergeSort() {
        mergeSortHelper(0, size - 1);
    }

    private void mergeSortHelper(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSortHelper(left, mid);
        mergeSortHelper(mid + 1, right);

        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arrayUniv[i] < arrayUniv[j]) {
                temp[k++] = arrayUniv[i++];
            } else {
                temp[k++] = arrayUniv[j++];
            }
        }

        while (i <= mid) temp[k++] = arrayUniv[i++];
        while (j <= right) temp[k++] = arrayUniv[j++];

        for (int p = 0; p < temp.length; p++) {
            arrayUniv[left + p] = temp[p];
        }
    }

    boolean isHere(int num) {
        for (int i = 0; i < size; i++) {
            if (arrayUniv[i] == num) return true;
        }
        return false;
    }

    int mostCommon() {
        this.mergeSort();

        int maxCount = 1;
        int currentCount = 1;
        int mostCommon = arrayUniv[0];

        for (int i = 1; i < size; i++) {
            if (arrayUniv[i] == arrayUniv[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostCommon = arrayUniv[i - 1];
                }
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            mostCommon = arrayUniv[size - 1];
        }

        return mostCommon;
    }

    void addElement(int num) {
        int[] arrayUniv1 = new int[size*2];
        for (int i = 0; i < size; i++) {
            arrayUniv1[i] = arrayUniv[i];
        }
        arrayUniv1[size++] = num;
        arrayUniv = arrayUniv1;
    }

    void deleteElement(int num) {
        for (int i = 0; i < arrayUniv.length; i++) {
            if (arrayUniv[i] == num) {
                for (int j = i + 1; j < arrayUniv.length; j++) {
                    arrayUniv[i] = arrayUniv[size + 1];
                }
                arrayUniv[size - 1] = 0;
                break;
            }
        }
    }


}




public class homework {
    public static void main(String[] args) {
        UniversalArray univArray1  = new UniversalArray(8);
        UniversalArray univArray2  = new UniversalArray(8);
        UniversalArray univArray3  = new UniversalArray(8);
        univArray1.initArray();
        univArray2.initArray();
        univArray3.initArray();
        univArray1.printArray();
        univArray1.selectionSort();
        univArray1.printArray();
        univArray2.mergeSort();
        univArray2.printArray();
        univArray3.bubbleSort();
        univArray3.printArray();
        System.out.println(univArray1.isHere(7));
        System.out.println(univArray1.max());
        System.out.println(univArray1.min());
        System.out.println(univArray1.mostCommon());
        univArray1.addElement(7);
        univArray1.printArray();
        univArray1.deleteElement(7);
        univArray1.printArray();
        UniversalArray[] ArrayList  = new UniversalArray[3];
        ArrayList[0] = univArray1;
        ArrayList[1] = univArray2;
        ArrayList[2] = univArray3;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if(ArrayList[i].max() > max){
                max = ArrayList[i].max();
            }
        }
        System.out.println(max);
    }
}

