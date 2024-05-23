import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryBranch() {

        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100), "allItems list can't be null!");


        assertTrue(SILab2.checkCart(Collections.emptyList(), 100));


        List<Item> items3 = Arrays.asList(new Item("item1", "123456", 100, 0));
        assertTrue(SILab2.checkCart(items3, 100));


        List<Item> items4 = Arrays.asList(new Item("item1", "123456", 100, 0.1f));
        assertTrue(SILab2.checkCart(items4, 10));


        List<Item> items5 = Arrays.asList(new Item("item1", "12345a", 100, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items5, 100), "Invalid character in item barcode!");


        List<Item> items6 = Arrays.asList(new Item("item1", null, 100, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items6, 100), "No barcode!");


        List<Item> items7 = Arrays.asList(new Item("item1", "0123456", 350, 0.1f));
        assertTrue(SILab2.checkCart(items7, 35));
    }

    @Test
    void testMultipleConditions() {

        List<Item> items1 = Arrays.asList(new Item("item1", "0123456", 350, 0.1f));
        assertTrue(SILab2.checkCart(items1, 35));


        List<Item> items2 = Arrays.asList(new Item("item1", "0123456", 250, 0.1f));
        assertFalse(SILab2.checkCart(items2, 35));


        List<Item> items3 = Arrays.asList(new Item("item1", "0123456", 350, 0));
        assertFalse(SILab2.checkCart(items3, 35));


        List<Item> items4 = Arrays.asList(new Item("item1", "1123456", 350, 0.1f));
        assertFalse(SILab2.checkCart(items4, 35));


        List<Item> items5 = Arrays.asList(new Item("item1", "1123456", 250, 0));
        assertFalse(SILab2.checkCart(items5, 35));
    }
}