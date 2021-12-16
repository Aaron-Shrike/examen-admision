
package cap_logica;

import java.util.Scanner;

/**
 *
 * @author Sh
 */
public class Postulante implements Comparable<Postulante>{
    private String dniPostulante;
    private int correctasRmRv; //1.333210
    private int correctasCb;//0.887989
    private int correctasCg;//0.956979
    private int incorrectasRmRv; //0.266523
    private int incorrectasCb;//0.177698
    private int incorrectasCg;//0.241043
    private double subPuntajeRmRv;
    private double subPuntajeCb;
    private double subPuntajeCg;
    private Double puntajeFinal;

    
    public String getDniPostulante() {
        return dniPostulante;
    }

    public void setDniPostulante(String dniPostulante) {
        this.dniPostulante = dniPostulante;
    }

    public int getCorrectasRmRv() {
        return correctasRmRv;
    }

    public void setCorrectasRmRv(int correctasRmRv) {
        this.correctasRmRv = correctasRmRv;
    }

    public int getCorrectasCb() {
        return correctasCb;
    }

    public void setCorrectasCb(int correctasCb) {
        this.correctasCb = correctasCb;
    }

    public int getCorrectasCg() {
        return correctasCg;
    }

    public void setCorrectasCg(int correctasCg) {
        this.correctasCg = correctasCg;
    }

    public int getIncorrectasRmRv() {
        return incorrectasRmRv;
    }

    public void setIncorrectasRmRv(int incorrectasRmRv) {
        this.incorrectasRmRv = incorrectasRmRv;
    }

    public int getIncorrectasCb() {
        return incorrectasCb;
    }

    public void setIncorrectasCb(int incorrectasCb) {
        this.incorrectasCb = incorrectasCb;
    }

    public int getIncorrectasCg() {
        return incorrectasCg;
    }

    public void setIncorrectasCg(int incorrectasCg) {
        this.incorrectasCg = incorrectasCg;
    }

    public double getSubPuntajeRmRv() {
        return subPuntajeRmRv;
    }

    public void setSubPuntajeRmRv(double subPuntajeRmRv) {
        this.subPuntajeRmRv = subPuntajeRmRv;
    }

    public double getSubPuntajeCb() {
        return subPuntajeCb;
    }

    public void setSubPuntajeCb(double subPuntajeCb) {
        this.subPuntajeCb = subPuntajeCb;
    }

    public double getSubPuntajeCg() {
        return subPuntajeCg;
    }

    public void setSubPuntajeCg(double subPuntajeCg) {
        this.subPuntajeCg = subPuntajeCg;
    }

    public double getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(double puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    
    public void leer(){
        Scanner leer = new Scanner(System.in);
        
        System.out.println("");

        do{
            System.out.print("DNI de postulante(8 dígitos) : ");
            dniPostulante = leer.next();
        }while(dniPostulante.length() != 8);
        
        System.out.println("Preguntas Correctas : ");
        do{
            System.out.print("  + Raz. Matemático y Raz. Verbal[0-25] : ");
            correctasRmRv = leer.nextInt();
        }while(correctasRmRv < 0 || correctasRmRv > 25);
        
        do{
            System.out.print("  + Conocimientos Básicos[0-25] : ");
            correctasCb = leer.nextInt();
        }while(correctasCb < 0 || correctasCb > 25);
        
        do{
            System.out.print("  + Cultura General[0-50] : ");
            correctasCg= leer.nextInt();
        }while(correctasCg < 0 || correctasCg > 50);
        
        System.out.println("Preguntas Incorrectas: ");
        do{
            System.out.print("  + Raz. Matemático y Raz. Verbal[0-"+(25-correctasRmRv)+"] : ");
            incorrectasRmRv = leer.nextInt();
        }while(incorrectasRmRv < 0 || incorrectasRmRv > 25-correctasRmRv);
        
        do{
            System.out.print("  + Conocimientos Básicos[0-"+(25-correctasCb)+"] : ");
            incorrectasCb = leer.nextInt();
        }while(incorrectasCb < 0 || incorrectasCb > 25-correctasCb);
        
        do{
            System.out.print("  + Cultura General[0-"+(50-correctasCg)+"] : ");
            incorrectasCg= leer.nextInt();
        }while(incorrectasCg < 0 || incorrectasCg > 50-correctasCg);
        
        subPuntajeRmRv = correctasRmRv*1.333210 - incorrectasRmRv*0.266523;
            
        subPuntajeCb = correctasCb*0.887989 - incorrectasCb*0.177698;
                    
        subPuntajeCg = correctasCg*0.956979 - incorrectasCg*0.241043;
        
        puntajeFinal = subPuntajeRmRv + subPuntajeCb + subPuntajeCg;
    }   

    @Override
    public int compareTo(Postulante o) {
        return puntajeFinal.compareTo(o.getPuntajeFinal());
    }

}
