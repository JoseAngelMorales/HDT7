package HDT7;

public class PFactory extends Namer{
    public PFactory(String s){

        //Busca la primera coma y guarda desde el inicio hasta la coma para la palabra en ingles
        int i = s.indexOf(",");
        pingles = s.substring(0, i).trim();
        s = s.replaceFirst(s.substring(0, i+1).trim(), "");

        //Busca para la segunda coma y guarda desde el nuevo inicio para la palabra en ingles y el resto para frances
        i = s.indexOf(",");
        pespanol = s.substring(0, i);
        pfrances = s.replaceFirst(s.substring(0, i+1).trim(), "");
    }
}

