import java.util.Scanner;

public class Producto {
    protected String nombre;
    protected int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {

            this.nombre = preguntarNombre();
            this.precio = preguntarPrecio();

    }

    public String getNombre() {
        return nombre;
    }

    private String preguntarNombre() {
        Scanner teclado = new Scanner(System.in);
        String nombre = "";
        int val;
        do {
            System.out.println("Ingrese el nombre del producto");
            try {
                //nPers = JOptionPane.showInputDialog("Ingrese su nombre");
                nombre = teclado.next();
                val = 1;
            } catch (Exception e) {
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val = 0;
            }

        } while (val == 0);

        return nombre;
    }

    private int preguntarPrecio() {
        Scanner teclado = new Scanner(System.in);
        int precio = 0;
        int val;
        do {
            System.out.println("Ingrese el precio del producto");
            try {
                precio = teclado.nextInt();
                //edPers = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
                if (precio < 1) {
                    System.out.println("Ingresó un dato erróneo, intente otra vez");
                    //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                    val = 0;
                } else {
                    val = 1;
                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,"Ingresó un dato erróneo, intente otra vez");
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
                val = 0;
            }

        } while (val == 0);

        return precio;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre +" $"+ precio;
    }
}
