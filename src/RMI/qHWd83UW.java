package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class qHWd83UW {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        CharacterService characterService = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String studentCode = "B21DCCN268";
        String qCode = "qHWd83UW";

        String quest = characterService.requestCharacter(studentCode, qCode);
        int offset = quest.length() % 7;
        System.out.println(quest + " " + offset);

        String ans = "";
        for(int i = 0 ; i < quest.length() ; ++i){
            char c = quest.charAt(i);
            c = (char) ((int)c - offset);
            if(c < 'a') c = (char)((int)'z' - ((int)'a' - c));
            ans += c;
        }
        System.out.println(ans);
        characterService.submitCharacter(studentCode, qCode, ans);
    }
}
