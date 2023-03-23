package HDT7;

public class Factory {
    public Namer getNamer(String entry) {
           return new PFactory(entry); //regresa el valor de PFactory    
    }
}