package HDT7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Association<String, String> palabra = new Association<String,String>(null, null);
        Factory factory = new Factory();
        Arbol arbolif = new Arbol();
        Arbol arbolie = new Arbol();
        Arbol arbolfi = new Arbol();
        Arbol arbolfe = new Arbol();
        Arbol arbolef = new Arbol();
        Arbol arbolei = new Arbol();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"));
            String linea = reader.readLine();
            while(linea != null){
                Namer namer = factory.getNamer(linea);
                //Arbol Ingles-Frances
                palabra.setLlave(namer.getPingles());
                palabra.setValor(namer.getPfrances());
                arbolif.empezar(palabra);
                //Arbol Ingles-Espanol
                palabra.setLlave(namer.getPingles());
                palabra.setValor(namer.getPespanol());
                arbolie.empezar(palabra);
                //Arbol Frances-Ingles
                palabra.setLlave(namer.getPfrances());
                palabra.setValor(namer.getPingles());
                arbolfi.empezar(palabra);
                //Arbol Frances-Espanol
                palabra.setLlave(namer.getPfrances());
                palabra.setValor(namer.getPespanol());
                arbolfe.empezar(palabra);
                //Arbol Espanol-Ingles
                palabra.setLlave(namer.getPespanol());
                palabra.setValor(namer.getPingles());
                arbolei.empezar(palabra);
                //Arbol Espanol-Frances
                palabra.setLlave(namer.getPespanol());
                palabra.setValor(namer.getPfrances());
                arbolef.empezar(palabra);
            }
        } catch (IOException e) {
            System.out.println("No se ha encontrado la direccion del archivo.");
        }
    }
}

