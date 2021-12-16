
package cap_presentacion;

import cap_logica.Postulante;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sh
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Postulante> postulantes = new ArrayList<>();
        Iterator<Postulante> elemento;
        
        int op;
        
        do{
            op = menu();
             
            switch(op){
                case 1: registrarPostulante(postulantes);
                    break;
                case 2: listadoIngresantes(postulantes);
                    break;
            }
        }while(op != 3);
    }

    private static int menu() {
        Scanner leer = new Scanner(System.in);
        
        int opcion;
        
        System.out.println("\n\n\n\n");
        System.out.println("---------- MENU ---------- ");
        System.out.println("[1] Registrar Postulante");
        System.out.println("[2] Listado de Ingresantes");
        System.out.println("[3] Salir");      
        
        do{
            System.out.print("  Ingrese Opcion: ");
            opcion = leer.nextInt();
        }while(opcion < 1 || opcion > 3);
        
        return opcion;
    }

    private static void registrarPostulante(ArrayList<Postulante> auxList) {
        Postulante post = new Postulante();
        
        post.leer();
        
        auxList.add(post);
        
        System.out.println("\n * Postulante registrado exitosamente");
    }

    private static void listadoIngresantes(ArrayList<Postulante> auxList) {
        Iterator<Postulante> elemento;
        
        int num = 0;  
        
        if(!auxList.isEmpty()){
            Collections.sort(auxList, Collections.reverseOrder());
        
            System.out.println("\n\n");
            System.out.println("INGRESANTE \t\t PUNTAJE(RM y RV) \t PUNTAJE(CB) \t PUNTAJE(CG) \t\t PUNTAJE FINAL \t ESTADO");
            System.out.println("===============================================================================================================");
        
            elemento = auxList.iterator();
        
            while(elemento.hasNext()){
                Postulante p = elemento.next();
                                 
                System.out.print(p.getDniPostulante() + "\t\t" + p.getSubPuntajeRmRv() + " \t " + p.getSubPuntajeCb() 
                    + " \t " + p.getSubPuntajeCg() + "\t\t" + p.getPuntajeFinal());
                if(num != 10){
                    System.out.println("\t(Ingreso)");
                    num++;
                }else{
                    System.out.println("\t(No Ingreso)");
                }
            }
        
            System.out.println("===============================================================================================================");
        }
    }
    
}
