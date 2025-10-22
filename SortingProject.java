import java.util.*;

public class SortingProject {

    // Global counters
    static long comparisonCount = 0;
    static long assignmentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            int N = Integer.parseInt(parts[0]);
            char dataType = parts[1].charAt(0);
            char operation = parts[2].charAt(0);

            int[] data = generateData(N, dataType);
            comparisonCount = 0;
            assignmentCount = 0;

            switch (operation) {
                case 'P':
                    printArray(data);
                    break;
                case 'I':
                    insertionSort(Arrays.copyOf(data, data.length));
                    System.out.printf("%d %c %c %d%n", N, dataType, operation, comparisonCount);
                    break;
                case 'i':
                    int[] iSorted = insertionSort(Arrays.copyOf(data, data.length));
                    printArray(iSorted);
                    break;
                case 'Q':
                    quickSort(Arrays.copyOf(data, data.length), 0, data.length - 1);
                    System.out.printf("%d %c %c %d%n", N, dataType, operation, comparisonCount);
                    break;
                case 'q':
                    int[] qSorted = Arrays.copyOf(data, data.length);
                    quickSort(qSorted, 0, qSorted.length - 1);
                    printArray(qSorted);
                    break;
                case 'M':
                    int[] mSorted = Arrays.copyOf(data, data.length);
                    mergeSort(mSorted, 0, mSorted.length - 1, new int[mSorted.length]);
                    System.out.printf("%d %c %c %d%n", N, dataType, operation, assignmentCount);
                    break;
                case 'm':
                    int[] msSorted = Arrays.copyOf(data, data.length);
                    mergeSort(msSorted, 0, msSorted.length - 1, new int[msSorted.length]);
                    printArray(msSorted);
                    break;
                default:
                    System.err.println("Unknown operation: " + operation);
            }
        }

        scanner.close();
    }

    static int[] generateData(int N, char type) {
        int[] arr = new int[N];
        switch (type) {
            case 'A':
                for (int i = 0; i < N; i++) arr[i] = i + 1;
                break;
            case 'D':
                for (int i = 0; i < N; i++) arr[i] = N - i;
                break;
            case 'E':
                Arrays.fill(arr, 1);
                break;
            case 'R':
                Random rand = new Random();
                for (int i = 0; i < N; i++) arr[i] = rand.nextInt(N) + 1;
                break;
            case 'S':
                for (int i = 0; i < N; i++) arr[i] = i + 1;
                shuffleArray(arr);
                break;
        }
        return arr;
    }

    static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append(' ');
        System.out.println(sb.toString().trim());
    }

    static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisonCount++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            comparisonCount++;
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
            assignmentCount++;
        }
    }
}
