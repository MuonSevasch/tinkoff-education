package tasks.second;


import org.junit.Test;

import java.util.Random;

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
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int STRING_LENGTH = 6;
    private static final Random random = new Random();

    @Test
    public void testGetStationeryList() {
        NoviceStationerySet set = NoviceStationerySet.generateStandart();
        assertEquals(3, set.getStationeryList().size());

        Stationery item1 = set.getStationeryList().get(0);
        assertTrue(item1 instanceof Pen);
        assertEquals("Ballpoint pen", item1.getName());
        assertEquals(1.0, item1.getPrice(), 0.01);
        assertEquals("Blue", ((Pen) item1).getColor());

        Stationery item2 = set.getStationeryList().get(1);
        assertTrue(item2 instanceof Notebook);
        assertEquals("Notebook", item2.getName());
        assertEquals(2.5, item2.getPrice(), 0.01);
        assertEquals(50, ((Notebook) item2).getNumberOfPages());

        Stationery item3 = set.getStationeryList().get(2);
        assertTrue(item3 instanceof Pen);
        assertEquals("Fountain pen", item3.getName());
        assertEquals(5.0, item3.getPrice(), 0.01);
        assertEquals("Black", ((Pen) item3).getColor());
    }

    @Test
    public void testSortings() throws CloneNotSupportedException {

        var set = makeRandomSet();

        // сортировка по цене
        set.shuffleStationery();
        System.out.println("Not sorted by price: " + set.getStationeryList());
        set.sortByPrice();
        System.out.println("Sorted by price: " + set.getStationeryList());
        set.shuffleStationery();


        // сортировка по наименованию
        System.out.println("Not sorted by name: " + set.getStationeryList());
        set.sortByName();
        System.out.println("Sorted by name: " + set.getStationeryList());
        set.shuffleStationery();

        set.addStationery(new Pen("BCA", 0, "blue")); //эти две строчки специально нужны чтобы проверить последний компоратор
        set.addStationery(new Pen("ABC", 0, "blue"));
        // сортировка сначала по стоимости, потом по наименованию
        System.out.println("Not sorted by name and price: " + set.getStationeryList());
        set.sortByPriceAndName();
        System.out.println("Sorted by price and name: " + set.getStationeryList());
    }


    NoviceStationerySet makeRandomSet() throws CloneNotSupportedException {
        NoviceStationerySet set = new NoviceStationerySet();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            // генерация случайного объекта Stationery
            Stationery item = null;
            int itemType = random.nextInt(2);
            switch (itemType) {
                case 0:
                    item = new Pen(generateRandomString(), random.nextDouble() * 10 + 1, "blue");
                    break;
                case 1:
                    item = new Notebook(generateRandomString(), random.nextDouble() * 20 + 5, random.nextInt(500));
                    break;
            }


            set.addStationery(item);
        }
        return set;
    }

    private String generateRandomString() {
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        for (int i = 0; i < STRING_LENGTH; i++) {
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        }
        return sb.toString();
    }
}