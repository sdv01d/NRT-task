import java.io.*;
import java.util.*;
 
public class TripletsSum {
 
    public static int getTriplets(int n,int [] arr)
    {
        int count = 0;
 
        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    count++;
                }
                else {
                    s.add(arr[j]);
                }
            }
        }
        return count;
    }
 
    public static void main(String[] args)
    {
        int arr[] = { 0, -1, 2, -3, 1 };
        int n = arr.length;
        System.out.println(getTriplets(n,arr));
    }
}