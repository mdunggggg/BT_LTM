package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class B2r1XAI1W {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String MSV = "B21DCCN268";
        String code = "2r1XAI1W";
        dos.writeUTF(MSV + ";" + code);

        int a = dis.readInt();
        int b = dis.readInt();
        System.out.println(a + " " + b);

        int uoc = UC(a, b);
        int boi = a * b / uoc;
        int tong = a + b;
        int tich = a * b;
        System.out.println(uoc + " " + boi + " " + tong + " " + tich);
        dos.writeInt(uoc);
        dos.writeInt(boi);
        dos.writeInt(tong);
        dos.writeInt(tich);
    }

    public static int UC(int a, int b){
        if(b == 0) return a;
        return UC(b, a % b);
    }
}
