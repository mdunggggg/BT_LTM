package WS;
import medianews.*;

import java.util.List;

public class B3FOS1S9Y {
    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String studentCode = "B21DCCN268";
        String qCode = "3FOS1S9Y";
        List<String> list = port.requestStringArray(studentCode, qCode);
        list.sort((o1, o2) -> {
            if(o1.length() > o2.length()) return 1;
            if(o1.length() == o2.length()) return 0;
            return -1;
        });

        port.submitCharacterStringArray(studentCode, qCode, list);
    }
}
