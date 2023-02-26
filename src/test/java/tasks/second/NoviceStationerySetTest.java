package tasks.second;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Вы спросите, почему я написал тесты используя 4 junit, а не 5-й, а я вам отвечу:
 * Мужик в автомастерской.
 * Ставит на Запорожец сигнализацию.
 * Другой на Мерседесе, спрашивает.
 * — Зачем, боитесь что угонят?
 * Это у вaс угоняют, a ко мне по ночам срать ходят.
 */

public class NoviceStationerySetTest {

    @Test
    public void testGetItems() {
        NoviceStationerySet set = new NoviceStationerySet();
        assertEquals(3, set.getItems().size());

        Stationery item1 = set.getItems().get(0);
        assertTrue(item1 instanceof Pen);
        assertEquals("Ballpoint pen", item1.getName());
        assertEquals(1.0, item1.getPrice(), 0.01);
        assertEquals("Blue", ((Pen)item1).getColor());

        Stationery item2 = set.getItems().get(1);
        assertTrue(item2 instanceof Notebook);
        assertEquals("Notebook", item2.getName());
        assertEquals(2.5, item2.getPrice(), 0.01);
        assertEquals(50, ((Notebook)item2).getNumberOfPages());

        Stationery item3 = set.getItems().get(2);
        assertTrue(item3 instanceof Pen);
        assertEquals("Fountain pen", item3.getName());
        assertEquals(5.0, item3.getPrice(), 0.01);
        assertEquals("Black", ((Pen)item3).getColor());
    }
}