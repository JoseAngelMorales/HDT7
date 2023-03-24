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
                System.out.println(namer.getPingles()+namer.getPespanol()+namer.getPfrances());
                //Arbol Ingles-Frances
                palabra.setLlave(namer.getPingles());
                palabra.setValor(namer.getPfrances());
                arbolif.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Ingles-Espanol
                palabra.setLlave(namer.getPingles());
                palabra.setValor(namer.getPespanol());
                arbolie.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Frances-Ingles
                palabra.setLlave(namer.getPfrances());
                palabra.setValor(namer.getPingles());
                arbolfi.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Frances-Espanol
                palabra.setLlave(namer.getPfrances());
                palabra.setValor(namer.getPespanol());
                arbolfe.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Espanol-Ingles
                palabra.setLlave(namer.getPespanol());
                palabra.setValor(namer.getPingles());
                arbolei.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Espanol-Frances
                palabra.setLlave(namer.getPespanol());
                palabra.setValor(namer.getPfrances());
                arbolef.empezar(palabra);
                palabra = new Association<String,String>(null, null);

                linea = reader.readLine();
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
                    String menu2 = "A que idioma desea traducir:\n1. Espanol\n2. Frances\n3. Cambiar idioma de traduccion";
                    int opcion2 = 1;
                    System.out.println(menu2);
                    opcion2 = teclado.nextInt();
                    while(opcion2 >= 1 && opcion2 < 4){
                        switch(opcion2){
                            case 1:{

                            }
                            case 2:{

                            }
                        }
                    }
                }
                case 2:{
                    String menu3 = "A que idioma desea traducir:\n1. Ingles\n2. Frances\n3. Cambiar idioma de traduccion";
                    int opcion3 = 1;
                    System.out.println(menu3);
                    opcion3 = teclado.nextInt();
                    while(opcion3 >= 1 && opcion3 < 4){
                        switch(opcion3){
                            case 1:{
                                ArbolNodo rootie = null;
                                Association<String, String> trad = new Association<String,String>(null, null);
                                String queso = "cheese";
                                String traducido;
                                trad.setLlave(queso);
                                rootie = arbolie.buscarPrimerNodo(rootie);
                                traducido = arbolie.buscar(rootie, trad);
                                System.out.println(traducido);
                            }
                            case 2:{
                                
                            }
                        }
                    }
                }
                case 3:{
                    String menu4 = "A que idioma desea traducir:\n1. Espanol\n2. Ingles\n3. Cambiar idioma de traduccion";
                    int opcion4 = 1;
                    System.out.println(menu4);
                    opcion4 = teclado.nextInt();
                    while(opcion4 >= 1 && opcion4 < 4){
                        switch(opcion4){
                            case 1:{

                            }
                            case 2:{
                                
                            }
                        }
                    }
                }
                case 4:{

                }
            }
        }    
    }
}

