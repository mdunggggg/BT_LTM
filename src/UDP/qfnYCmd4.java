package UDP;

import java.io.IOException;
import java.net.*;

public class qfnYCmd4 {
    public static void main(String[] args) throws IOException {
        String host = "203.162.10.109";
        InetAddress inetAddress = InetAddress.getByName(host);
        int port = 2207;
        String MSV = "B21DCCN268";
        String code = "qfnYCmd4";
        String auth = ";" + MSV + ";" + code;
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket(auth.getBytes(), auth.length(), inetAddress, port);
        datagramSocket.send(datagramPacket);

        byte[] data = new byte[2024];
        datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);
        String quest = new String(datagramPacket.getData()).trim();
        System.out.println(quest);

        String[] arrays = quest.split("[;,]");
        String requestID = arrays[0];
        int n = Integer.parseInt(arrays[1]);
        int[] dd = new int[n + 5];
        for(int i = 2 ; i < arrays.length ; ++i){
            int x = Integer.parseInt(arrays[i]);
            dd[x] = 1;
        }
        String ans = "";
        for(int i = 1 ; i <= n ; ++i){
            if(dd[i] == 0){
                if(ans.isEmpty()) ans += i;
                else ans += "," + i;
            }
        }
        ans = requestID + ";" + ans;
        System.out.println(ans);
        datagramPacket = new DatagramPacket(ans.getBytes(), ans.length(), inetAddress, port);
        datagramSocket.send(datagramPacket);


    }
}
