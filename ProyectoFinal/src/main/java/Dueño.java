import java.util.Scanner;

public class Dueño extends Persona {
    private String email;

    public Dueño(String nombre, int edad, String email){
        super(nombre, edad);
        this.email = email;
    }

    public Dueño() {
        this.email=preguntarEmail();
    }



    private String preguntarEmail() {
        Scanner teclado = new Scanner(System.in);
        String emailD="";
        int val;
        do{
            System.out.println("Ingrese su email");
            try{
                emailD = teclado.nextLine();
                validarEmail(emailD);


                //emlPers = JOptionPane.showInputDialog("Ingrese su email");
                val=1;
            }catch (Exception e){
                //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val=0;
            }

        }while(val==0 || !validarEmail(emailD));

        return emailD;
    }
    public boolean validarEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }//sacada de StackOverflow

    @Override
    public String toString() {
        return "Nombre: "+getNombre()+"\nEdad: "+getEdad()+"\nEmail contacto: "+this.email;
    }
}
