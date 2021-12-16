import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Registrar locales
//Pedir comida


public class Rapidin {


    public static void main(String[] args) throws IOException {
        int selR = 0, selM = 0, selRep = 0, o, o2, o3, o4, selC = 0;
        List<Local> listaLocal = new ArrayList();
        List<Cliente> listaCliente = new ArrayList();
        List<Boleta> listaOrdenes = new ArrayList();
       String ANSI_PURPLE = "\u001B[35m";
        File file = new File("Boletas.txt");
        FileWriter write = new FileWriter(file);
        String ANSI_RESET = "\u001B[0m";

        Dueño d1 = new Dueño("Esteban", 34, "est.ban@gmail.com");
        Dueño d2 = new Dueño("Ismael", 25, "ismael_38@gmail.com");
        Dueño d3 = new Dueño("Federico", 39, "fed.romero.1@hotmail.com");
        Local l1 = new Local("Maddona", "Pizzería", d1, "Matta 3245", "+56932997028");
        Local l2 = new Local("Burger Express", "Hamburguesería", d2, "Aldunate 510", "+56922629032");
        Local l3 = new Local("El Cuate", "Taquería", d3, "Portales 0783", "+56920419024");
        Producto p1 = new Producto("Pizza Italiana", 10000);
        Producto p2 = new Producto("Pizza Española", 9500);
        Producto p3 = new Producto("Pizza Alemana", 12000);
        Producto p4 = new Producto("Pizza Hawaiana", 8000);
        Producto p5 = new Producto("Hamburguesa Italiana", 5000);
        Producto p6 = new Producto("Hamburguesa de queso", 3990);
        Producto p7 = new Producto("Hamburguesa Americana", 7000);
        Producto p8 = new Producto("Taco al pastor", 8000);
        Producto p9 = new Producto("Taco Italiano", 8000);
        Producto p0 = new Producto("Taco vegetariano", 8000);
        l1.productos.add(p1);
        l1.productos.add(p2);
        l1.productos.add(p3);
        l1.productos.add(p4);
        l2.productos.add(p5);
        l2.productos.add(p6);
        l2.productos.add(p7);
        l3.productos.add(p8);
        l3.productos.add(p9);
        l3.productos.add(p0);
        listaLocal.add(l1);
        listaLocal.add(l2);
        listaLocal.add(l3);


        System.out.println("Bienvenido a Rapidín :D");
        System.out.println("¿Que operación desea realizar?");
        boolean salida = true;
        Scanner teclado = new Scanner(System.in);

        while (salida) {
            try {
                System.out.println("0.- Cerrar Programa");
                System.out.println("1.- Registrar Local");
                System.out.println("2.- Realizar Pedido");
                System.out.println("3.- Check Pedido");

                int opc = teclado.nextInt();
                switch (opc) {
                    case 0:
                        System.out.println(ANSI_PURPLE+"Hasta Pronto :D"+ANSI_RESET);
                        salida = false;
                        break;
                    case 1:
                        Local l0 = new Local();
                        System.out.println("Su local fue registrado con éxito");
                        listaLocal.add(l0);
                        break;
                    case 2:

                        System.out.println("--------------------------------------------------------Ingrese sus datos--------------------------------------------------------");
                        Cliente c1 = new Cliente();
                        listaCliente.add(c1);
                        Boleta b1 = new Boleta(c1.getNombre());
                        System.out.println("¿A que local desea pedir?");
                        listaLocal.stream().map(local -> (listaLocal.indexOf(local) + 1) + " " + local.getNom_loc() + " " + local.getTipo()).forEach(System.out::println);
                        do {
                            try {
                                selR = teclado.nextInt();
                                if (selR < 1 || selR > listaLocal.size()) {
                                    System.out.println("Ingresó un dato erróneo, intente otra vez");
                                    o = 0;
                                } else {
                                    o = 1;
                                }
                            } catch (Exception e) {
                                System.err.println("Ingresó un dato erróneo, intente otra vez");
                                teclado.next();
                                o = 0;
                            }
                        } while (o == 0);

                        do {
                            int Sel;
                            do {
                                System.out.println("¿Que desea ordenar del menú?");
                                Sel = selR - 1;
                                listaLocal.get(Sel).imprimir();
                                try {
                                    selM = teclado.nextInt();
                                    if (selM < 1 || selM > listaLocal.get(Sel).productos.size()) {
                                        System.out.println("Ingresó un dato erróneo, intente otra vez");
                                        o2 = 0;
                                    } else {
                                        o2 = 1;
                                    }
                                } catch (Exception e) {
                                    System.err.println("Ingresó un dato erróneo, intente otra vez");
                                    teclado.next();
                                    o2 = 0;
                                }

                            } while (o2 == 0);

                            b1.agregarProducto(listaLocal.get(Sel).productos.get(selM - 1));

                            do {
                                System.out.println("Desea agregar algo más al pedido?\n(1)Si\n(2)No");
                                try {
                                    selRep = teclado.nextInt();
                                    if (selRep < 1 || selRep > 2) {
                                        System.out.println("Ingresó un dato erróneo, intente otra vez");
                                        o3 = 0;
                                    } else {
                                        o3 = 1;
                                    }
                                } catch (Exception e) {
                                    System.err.println("Ingresó un dato erróneo, intente otra vez");
                                    teclado.next();
                                    o3 = 0;
                                }


                            } while (o3 == 0);

                        } while (selRep == 1);
                        System.out.println("----------------------------------------------------------------------------------------");
                        System.out.println("Detalles de su orden");
                        System.out.println("Orden a nombre de: " + c1.getNombre());
                        b1.imprimir();
                        System.out.println("----------------------------------------------------------------------------------------");
                        b1.setNombre(c1.getNombre());
                        write.write(b1.crearBoleta());
                        listaOrdenes.add(b1);
                        b1.vaciarBoleta();
                        break;
                    case 3:
                        if (listaOrdenes.size() == 0) {
                            System.err.println("No hay ordenes disponibles");
                            break;
                        }
                        System.out.println("¿Que orden desea revisar?");
                        listaOrdenes.stream().map(orden -> (listaOrdenes.indexOf(orden) + 1) + " " + orden.toString()).forEach(System.out::println);
                        do {
                            try {
                                selC = teclado.nextInt();
                                if (selC < 1 || selC > listaOrdenes.size()) {
                                    System.out.println("Ingresó un dato erróneo, intente otra vez");
                                    o4 = 0;
                                } else {
                                    o4 = 1;
                                }
                            } catch (Exception e) {
                                System.err.println("Ingresó un dato erróneo, intente otra vez");
                                teclado.next();
                                o4 = 0;
                            }
                        } while (o4 == 0);

                        long initialTime = System.currentTimeMillis();
                        int tiempo = (int) (Math.random() * 10) + 2;
                        System.out.println(ANSI_PURPLE+listaOrdenes.get(selC - 1).getNombre() + ANSI_RESET+ " tu pedido llega en " + tiempo + "min aprox");
                        Hilo hilo1 = new Hilo(listaOrdenes.get(selC - 1).getNombre(),tiempo, initialTime);
                        hilo1.start();
                        listaOrdenes.remove(selC-1);
                        break;
                    default:
                        System.err.println("Ingrese un numero valido");

                }
            } catch (Exception e) {
                System.err.println("Ingresó un dato erróneo, intente otra vez");
                teclado.next();
            }

        }
        write.close();
    }
}

