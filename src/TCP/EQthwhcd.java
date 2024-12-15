package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class EQthwhcd {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String MSV = "B21DCCN268";
        String code = "EQthwhcd";
        os.write((MSV + ";" + code).getBytes());
        os.flush();

        byte[] data = new byte[2048];
        is.read(data);
        String question = new String(data).trim();
        System.out.println("Server sent: " + question);
        int n = question.length();
        String ans = "";
        for(int len = 1 ; len <= n ; len++) {
            for(int i = 0 ; i < n - len + 1 ; ++i){
                String begin = question.substring(i, i + len);
                Set<Character> set = new HashSet<>();
                for(int j = 0 ; j < len ; ++j){
                    set.add(begin.charAt(j));
                }
                if(set.size() == begin.length()) {
                    if(ans.length() < begin.length()) {
                        ans = begin;
                    }
                }
            }
        }
        ans = ans + ";" + ans.length();
        System.out.println("Client sent: " + ans);
        os.write(ans.getBytes());
        os.flush();

    }
}
