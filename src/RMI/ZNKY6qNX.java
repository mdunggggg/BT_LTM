package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ZNKY6qNX {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ByteService byteService = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
        String studentCode = "B21DCCN268";
        String code = "ZNKY6qNX";
        byte[] bytes = byteService.requestData(studentCode, code);
       // byte[] bytes = new byte[]{72, 101, 108, 108, 111};
        String ans = "";
        for (byte i : bytes) {
            System.out.println(convertHex(i));
            ans += convertHex(i);
        }
        System.out.println(ans);
        byteService.submitData(studentCode, code, ans.getBytes());
    }
    public static String convertHex(int num) {
        String ans = "";
        while (num > 0){
            int tmp = num % 16;
            if (tmp < 10) ans += tmp;
            else ans += (char)(tmp + 'a' - 10);
            num /= 16;
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
