import java.util.*;
public class MajorityElement{
        
    public static int majorityBrut(int arr[]) {
        int maxCount = 0;
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            int count = 0; 
            for(int j = 0; j < arr.length; j++) {
                
                if(arr[i] == arr[j]) {
                    count++;
                }
            }
            if(count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
        if(maxCount > arr.length / 2) {
            return arr[index];
        } else {
            return -1;
        }
    }
    
    public static int majorityBetter(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int count = map.get(arr[i]) + 1;
                if(count > arr.length / 2) {
                    return arr[i];
                } else {
                    map.put(arr[i], count);
                }
            } else {
                map.put(arr[i], 1);
            }
        }
        return -1;
    }
    
    //one assumption that majority element always exists
    public static int majorityOptimal(int arr[]) {
        int candidate = 0;
        int count = 0;
        for(int num: arr) {
            if(count == 0) {
                candidate = num;
            } 
            if(num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
    
     public static void main(String []args){
        int arr[] = {7,7,3,5,5,5,6,5,5,7,3,5,5,5};
        System.out.println("Majority element is"+majorityBrut(arr));
        System.out.println("Majority element is"+majorityBetter(arr));
        System.out.println("Majority element is"+majorityOptimal(arr));
     }
}
