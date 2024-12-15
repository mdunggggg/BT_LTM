package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class y920FcX1 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        DataService dataService = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        String studentCode = "B21DCCN268";
        String qCode = "y920FcX1";

        String question = (String) dataService.requestData(studentCode, qCode);
//        String question = "6, 7, 6, 6, 2, 7, 8, 7, 6, 6";
        System.out.println(question);
        String[] listStrNumber = question.split("[, ]+");
        int[] nums = new int[listStrNumber.length];
        for(int i = 0 ; i < nums.length ; ++i ) {
            nums[i] = Integer.parseInt(listStrNumber[i]);
        }
        int n = nums.length - 2;
        boolean flag = true;
        while(n > 0 && nums[n] >= nums[n + 1]) {
            n--;

        }
        System.out.println(n);
        if(n == 0) {
            Arrays.sort(nums);
        }
        else {
            int j = nums.length - 1;
            while (nums[j] <= nums[n]) j--;
            System.out.println(j);
            int tmp = nums[n];
            nums[n] = nums[j];
            nums[j] = tmp;

            int l = n + 1, r = nums.length - 1;
            while (l < r){
                int tmp2 = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp2;
                l++;
                r--;
            }
        }
        for(int i = 0 ; i < nums.length; ++i){
            listStrNumber[i] = String.valueOf(nums[i]);
        }
        String ans = String.join(",", listStrNumber);
        System.out.println(ans);
        dataService.submitData(studentCode, qCode, ans);

    }
}
