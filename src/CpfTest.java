import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.Arrays;

@DisplayName("Cpf Test")
class CpfTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void generate() {
    }

    @org.junit.jupiter.api.Test
    void generateMainPart() {
    }

    @org.junit.jupiter.api.Test
    void getVerificationDigit() {

    }


    @org.junit.jupiter.api.Test
    @DisplayName("Deveria validar um CPF")
    void isValid() {
        Cpf cpf = new Cpf();
        System.out.println("CPF gerado "+cpf.CPF);
        Assertions.assertTrue(cpf.isValid());
        cpf = new Cpf("87958287100");
        System.out.println("CPF gerado "+cpf.CPF);
        Assertions.assertTrue(cpf.isValid());
        cpf = new Cpf("88358287100");
        System.out.println("CPF gerado "+cpf.CPF);
        Assertions.assertFalse(cpf.isValid());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Deveria converter String em Array de Inteiros")
    void arrToString() {
        int[] cpf = new int[]{8, 7, 9, 5, 8, 2, 8, 7, 1, 0, 0};
        Assertions.assertEquals("87958287100", Cpf.arrToString(cpf));
        System.out.println(Arrays.toString(cpf));
        System.out.println("true");
    }
}