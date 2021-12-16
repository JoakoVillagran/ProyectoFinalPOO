import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Boleta implements Imprimible {
    private String nombre;
    List<Producto> boleta = new ArrayList<>();

    public Boleta() {
    }

    public Boleta(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarBoleta(){
        return boleta.stream().map(producto -> producto.getNombre()+" "+producto.getPrecio()).toString();
    }

    public String totalVenta() {
        Optional<Integer> totalVenta = boleta.stream().map(Producto::getPrecio)
                .reduce(Integer::sum);
        return "Total de la venta: $" + totalVenta.get();
    }
    public void agregarProducto(Producto producto){
        boleta.add(producto);
    }
    public String crearBoleta() {
        String detalle = boleta.stream().
                collect(Collectors.groupingBy(
                        Producto::getNombre, Collectors.groupingBy(
                                Producto::getPrecio, Collectors.counting())))
                .toString();
        return "\n"+("Boleta \n "+detalle+totalVenta()).replaceAll("\\{","").replace('}','\n').replaceAll("\\,","");
    }
    public void vaciarBoleta() {
        boleta.clear();
    }
    public void imprimir(){
        System.out.println(crearBoleta());
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
