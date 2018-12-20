Idea: 
First, we split the array into 2 subarrays; 
Second, we apply the same method to each one of those 2 subarrays, then we keep doing so, and we will end up having each 
individual number; 
Third, we swap the smaller one to the left most position for each one of the 2 subarrays in order to form the sorted subarrays. 
Finally, we compare each individual number in these 2 subarrays one by one, the smaller one will be put at the left position 
and so on. The final array after this process is the result.


public class MergeSort {
public int[] mergeSort(int[] array) {
if (array == null || array.length == 0) {
return array;
}
// use helper function to help merge process
int[] helper = new int[array.length];
mergeSort(array, helper, 0, array.length - 1);
return array;
}
private void mergeSort(int[] array, int[] helper, int left, int right) {
if (left >= right) {
return;
}
int mid = left + (right - left) / 2;
mergeSort(array, helper, left, mid);
mergeSort(array, helper, mid + 1, right);
merge(array, helper, left, mid, right);
}
private void merge(int[] array, int[] helper, int left, int mid, int right) {
// copy the array to helper array since the merge process happens in helper array.
for (int i = 0; i <= right; i++) {
helper[i] = array[i];
}
int leftIndex = left;
int rightIndex = mid + 1;
while (leftIndex <= mid && rightIndex <= right) {
if (helper[leftIndex] <= helper[rightIndex]) {
array[left++] = helper[leftIndex++];
} else {
array[left++] = helper[rightIndex++];
}
}
while (leftIndex <= mid) {
array[left++] = helper[leftIndex++];
}
}
// test the code
public static void main(String[] args) {
MergeSort solution = new MergeSort();

int[] array = null;
array = solution.mergeSort(array);
System.out.println(Arrays.toString(array));

array = new int[0];
array = solution.mergeSort(array);
System.out.println(Arrays.toString(array));

array = new int[] { 1, 2, 3, 4 };
array = solution.mergeSort(array);
System.out.println(Arrays.toString(array));

array = new int[] { 4, 3, 2, 1};
array = solution.mergeSort(array);
System.out.println(Arrays.toString(array));

array = new int[] { 2, 4, 8, 0, 3, 9 };
array = solution.mergeSort(array);
System.out.println(Arrays.toString(array));
}
}


Run Time Analysis:
The time complexity before the individual number is formed is log(n) since there are log(n) levels.
The time complexity for merging individual numbers is nlog(n).
So the total run time is O(nlogn)
