class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[nums1.length + nums2.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < nums1.length){
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length){
            arr[k] = nums2[j];
            j++;
            k++;
        }

        if(arr.length % 2 == 0){
            int mid = arr.length / 2;
            int prevMid = mid - 1;
            return ((double) arr[mid] + arr[prevMid]) / 2;
        }
        else return arr[arr.length / 2];
    }
}