package HDT7;

public class PFactory extends Namer{
    public PFactory(String s){

        int i = s.indexOf(",");
        pingles = s.substring(0, i).trim();
        s = s.replaceFirst(s.substring(0, i+1).trim(), "");

        i = s.indexOf(",");
        pespanol = s.substring(0, i);
        pfrances = s.replaceFirst(s.substring(0, i+1).trim(), "");
    }
}

