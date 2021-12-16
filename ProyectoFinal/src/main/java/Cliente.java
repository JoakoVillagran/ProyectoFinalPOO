//import javax.swing.*;
import java.util.Scanner;

public class Cliente extends Persona{
    private String nro_contacto;
    private String direccion;

    public Cliente(String direccion) {
        this.direccion = direccion;
    }

    public Cliente() {
        super();
        this.nro_contacto=preguntarNro();
        this.direccion=preguntarDir();


    }
    private String preguntarNro() {
        Scanner teclado = new Scanner(System.in);
        String nroPers="";
        int val;
        do{
            System.out.println("Ingrese su número de celular +569");
            try{
                nroPers = teclado.next();
                //nroPers = JOptionPane.showInputDialog("Ingrese su número de celular +569");
                if (nroPers.length()==8){
                    val=1;
                }else{
                    //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                    System.out.println("Largo del número incorrecto, intentelo otra vez");
                    val=0;
                }
            }catch (Exception e){
                //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val=0;
            }

        }while(val==0);

        return nroPers;
    }
    private String preguntarDir() {
        Scanner teclado = new Scanner(System.in);
        String dirPers="";
        int val;
        do{
            System.out.println("Ingrese su dirección");
            try{
                dirPers = teclado.nextLine();
                //dirPers = JOptionPane.showInputDialog("Ingrese su dirección");
                val=1;
            }catch (Exception e){
                //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val=0;
            }

        }while(val==0);

        return dirPers;
    }

    @Override
    public String toString() {
        return "Datos del cliente: "+"\nNombre: " +getNombre()+"\nEdad: "+getEdad()+
                "\nFono contacto: +569"+this.nro_contacto+"\nDireccion: "+this.direccion;
    }
}