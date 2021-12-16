//import javax.swing.*;
import java.util.Scanner;

abstract class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {
        this.nombre=preguntarNombre();
        this.edad=preguntarEdad();

    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private String preguntarNombre() {
        Scanner teclado = new Scanner(System.in);
        String nPers="";
        int val;
        do{
            System.out.println("Ingrese su nombre");
            try{
                //nPers = JOptionPane.showInputDialog("Ingrese su nombre");
                nPers = teclado.nextLine();
                val=1;
            }catch (Exception e){
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val=0;
            }

        }while(val==0);

        return nPers;
    }
    private int preguntarEdad() {
        Scanner teclado = new Scanner(System.in);
        int edPers=0;
        int val;
        do{
            System.out.println("Ingrese su edad (Debe ser mayor de 12 años para usar la aplicación)");
            try{
                edPers = teclado.nextInt();
                //edPers = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
                if (edPers<12 || edPers>99){
                    System.out.println("Ingresó un dato erróneo, intente otra vez");
                    //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                    val=0;
                }else{
                    val=1;
                }

            }catch (Exception e){
                //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val=0;
            }

        }while(val==0 );

        return edPers;
    }

    public boolean validarEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }//sacada de StackOverflow

    @Override
    public String toString() {
        return "Nombre: "+getNombre()+"\nEdad: "+getEdad();
    }
}

