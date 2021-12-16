import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DueñoTest {
    private Dueño dueno;
    @BeforeEach
    void setUp() {
        dueno=new Dueño("Raul Albiol",34,"oblak");
    }

    @AfterEach
    void tearDown() {
        dueno=null;
    }

    @Test
    void validarEmail() {
        assertTrue(dueno.validarEmail("1234")==false);

    }

}