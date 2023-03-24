package HDT7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Association<String, String> palabra = new Association<String,String>(null, null);
        Factory factory = new Factory();
        Scanner teclado = new Scanner(System.in);
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

        String menu = "Bienvenido al traductor, elija una de las opciones:\n1. Traducir del ingles\n2. Traducir del espanol\n3. Traducir del frances\n4. Mostrar el idioma principal de la oracion\nCualquier otro numero para cerrar el programa";
        int opcion = 1;
        System.out.println(menu);
        opcion = teclado.nextInt();
        teclado.nextLine();
        while(opcion >= 1 && opcion < 5){
            switch(opcion){
                case 1:{
                    
                }
                case 2:{

                }
                case 3:{

                }
                case 4:{

                }
            }
        }    
    }
}

