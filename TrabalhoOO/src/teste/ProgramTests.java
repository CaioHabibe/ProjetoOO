package teste;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controller.ControleFilial;
import controller.ControleProduto;

class ProgramTests {
    private ControleFilial cf = new ControleFilial();
    private ControleProduto cp = new ControleProduto();

    @Test
    public void testSalvarFilial() {
        assertTrue(cf.salvarFilial("Brasília", "Quadra 205 Lote 01", 01235));
    }

    @Test
    public void testRemoverFilial() {
        assertTrue(cf.removerFilial(0));
    }

    @Test
    public void testSalvarRemedio() {
        assertTrue(cp.salvarRemedio("Dipirona", 30.00, "Remédio para dores de cabeça", "30 miligramas", "Metamizol", "Oral", "Remédio"));
    }
}
