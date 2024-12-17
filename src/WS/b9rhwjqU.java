package WS;

import java.util.ArrayList;
import java.util.List;
import medianews.*;

public class b9rhwjqU {
    public static void main(String[] args) {
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        String studentCode = "B21DCCN268";
        String qCode = "b9rhwjqU";
        List<Integer> list =(List<Integer>) port.getData(studentCode, qCode);
        for(int i = 0 ; i < list.size(); ++i){
            System.out.println(list.get(i));
        }
        List<String> ans = new ArrayList<>();
        for(int idx = 0 ; idx < list.size(); ++idx){
            String tmp = "";
            int num = list.get(idx);
            for(int i = 2 ; i <= num ; ++i){
                if(num % i == 0){
                    while(num % i == 0){
                        num /= i;
                        if(tmp.isEmpty()) {
                            tmp += i;
                        }
                        else tmp += ", " + i;
                    }
                }
            }
            System.out.println(tmp);
            ans.add(tmp);
        }
        port.submitDataStringArray(studentCode, qCode, ans);
    }
}
