package UDP;

import java.io.IOException;
import java.net.*;

public class B3RoaXi1u {
    public static void main(String[] args) throws IOException {
        String host = "203.162.10.109";
        InetAddress inetAddress = InetAddress.getByName(host);
        int port = 2208;
        String MSV = "B21DCCN268";
        String code = "3RoaXi1u";
        String auth = ";" + MSV + ";" + code;

        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket(auth.getBytes(), auth.length(), inetAddress, port);
        datagramSocket.send(datagramPacket);

        byte[] data = new byte[2048];
        datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);
        String quest = new String(datagramPacket.getData()).trim();
        String[] arrays = quest.split(";");
        String requestID = arrays[0];
        String question = arrays[1];
        int[] dd = new int[1000];
        String ans = "";
        for(int i = 0 ; i < question.length() ; ++i){
            if(!check(question.charAt(i))) continue;
            if(dd[question.charAt(i)] == 0){
                ans += question.charAt(i);
                dd[question.charAt(i)] = 1;
            }
        }
        System.out.println(ans);
        ans = requestID + ";" + ans;
        datagramPacket = new DatagramPacket(ans.getBytes(), ans.length(), inetAddress, port);
        datagramSocket.send(datagramPacket);
    }

    public static boolean check(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
