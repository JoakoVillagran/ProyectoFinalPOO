import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoletaTest {
    private Boleta boleta;
    private Producto p1;

    @BeforeEach
    void setUp() {
        boleta=new Boleta();
        p1=new Producto("Pollo",500);
    }

    @AfterEach
    void tearDown() {
        boleta=null;
        p1=null;
    }
    @Test
    void agregarProducto() {
        boleta.agregarProducto(p1);
        assertEquals(boleta.boleta.isEmpty(),false);
    }
}
