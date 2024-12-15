package TCP;

import java.io.*;
import java.net.Socket;

public class QJfO3s1e {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String MSV = "B21DCCN268";
        String code = "QJfO3s1e";
        bw.write(MSV + ";" + code + "\n");
        bw.flush();

        String question = br.readLine().trim();
        System.out.println(question);

        String chuoi1 = "";
        String chuoi2 = "";
        for(int i = 0 ; i < question.length() ; ++i){
            if (KyTucDacBiet(question.charAt(i))) {
                chuoi2 += question.charAt(i);
            }
            else chuoi1 += question.charAt(i);
        }
        System.out.println(chuoi1);
        System.out.println(chuoi2);
        bw.write(chuoi1 + "\n");
        bw.flush();
        bw.write(chuoi2 + "\n");
        bw.flush();
    }

    public static boolean KyTucDacBiet(char c){
        boolean binhThuong = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
        return !binhThuong;
    }
}
