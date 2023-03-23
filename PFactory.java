package HDT7;

public class PFactory extends Namer{
    public PFactory(String s){

        int i = s.lastIndexOf(",");
        pfrances = s.substring(i+1).trim();
        s = s.replace(s.substring(i).trim(), "");
        System.out.println(s);
        
        i = s.lastIndexOf(",");
        pespanol = s.substring(i+1).trim();
        pingles = s.replace(s.substring(i).trim(), "");
    }
}

