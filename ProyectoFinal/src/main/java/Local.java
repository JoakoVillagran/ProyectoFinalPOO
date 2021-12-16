import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Local {
    private String nom_loc;
    private String tipo;
    private Dueño dueño;
    private String dir_loc;
    private String fono_loc;
    List<Producto> productos = new ArrayList<>();

    public Local(String nom_loc, String tipo, Dueño dueño, String dir_loc, String fono_loc) {
        this.nom_loc = nom_loc;
        this.tipo = tipo;
        this.dueño = dueño;
        this.dir_loc = dir_loc;
        this.fono_loc = fono_loc;
    }

    public Local() {
        System.out.println("Ingrese datos del dueño");
        this.dueño = new Dueño();
        this.nom_loc = preguntarNombre();
        this.tipo = preguntarTipo();
        this.dir_loc = preguntarDir();
        this.fono_loc = preguntarNro();
        preguntarProducto();

    }

    public String getTipo() {
        return tipo;
    }

    public String getNom_loc() {
        return nom_loc;
    }

    private String preguntarNombre() {
        Scanner teclado = new Scanner(System.in);
        String nLoc = "";
        int val;
        do {
            System.out.println("Ingrese el su nombre de su local");
            try {
                //nPers = JOptionPane.showInputDialog("Ingrese su nombre");
                nLoc = teclado.nextLine();
                val = 1;
            } catch (Exception e) {
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val = 0;
            }

        } while (val == 0);

        return nLoc;
    }

    private String preguntarTipo() {
        Scanner teclado = new Scanner(System.in);
        String tipLoc = "";
        int val;
        do {
            System.out.println("Ingrese el tipo de local\n(Pizzeria, Hamburgueseria, Bar, etc)");
            try {
                //nPers = JOptionPane.showInputDialog("Ingrese su nombre");
                tipLoc = teclado.nextLine();
                val = 1;
            } catch (Exception e) {
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val = 0;
            }

        } while (val == 0);

        return tipLoc;
    }

    private String preguntarDir() {
        Scanner teclado = new Scanner(System.in);
        String dirLoc = "";
        int val;
        do {
            System.out.println("Ingrese la dirección del local");
            try {
                dirLoc = teclado.nextLine();
                //dirPers = JOptionPane.showInputDialog("Ingrese su dirección");
                val = 1;
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val = 0;
            }

        } while (val == 0);

        return dirLoc;
    }

    private String preguntarNro() {
        Scanner teclado = new Scanner(System.in);
        String nroLoc = "";
        int val;
        do {
            System.out.println("Ingrese el número de contacto del local +569");
            try {
                nroLoc = teclado.next();
                //nroPers = JOptionPane.showInputDialog("Ingrese su número de celular +569");
                if (nroLoc.length() == 8) {
                    val = 1;
                } else {
                    //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                    System.out.println("Largo del número incorrecto, intentelo otra vez");
                    val = 0;
                }
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val = 0;
            }

        } while (val == 0);

        return nroLoc;
    }
    private void agregarProducto(Producto producto){
        productos.add(producto);
    }

    private void preguntarProducto() {
        Scanner s = new Scanner(System.in);
        int a;
        do {
            Producto p1 = new Producto();
            agregarProducto(p1);
            System.out.println("Desea agregar otro producto \n Si(1) \n No(2)");
            try {
                a = s.nextInt();
                if (a<1 || a>2){
                    System.out.println("Ingresó un dato erróneo, intente otra vez");
                    //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                    a=1;
                }else {
                    a=2;
                }
            } catch (Exception e) {
                s.next();
                a=1;
            }


        } while (a==1);

    }
    public void imprimir() {
        productos.stream().map(producto -> (productos.indexOf(producto)+1)+ " "+producto.toString()).forEach(System.out::println);
    }







    @Override
    public String toString() {
        return "Nombre: " + this.nom_loc + "\nTipo: " + this.tipo + "\nDatos del dueño: " + "\n" + this.dueño.toString() + "\nDirección: " + this.dir_loc + "\nFono contacto: +569" + this.fono_loc;
    }
}

