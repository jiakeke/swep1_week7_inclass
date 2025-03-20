import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @org.junit.jupiter.api.Test
    void calculatePrice() {
        assertEquals(0, ShoppingCart.calculatePrice(0, 0));
        assertEquals(0, ShoppingCart.calculatePrice(0, 1));
        assertEquals(0, ShoppingCart.calculatePrice(1, 0));
        assertEquals(1, ShoppingCart.calculatePrice(1, 1));
        assertEquals(2, ShoppingCart.calculatePrice(1, 2));
        assertEquals(2, ShoppingCart.calculatePrice(2, 1));
        assertEquals(4, ShoppingCart.calculatePrice(2, 2));
    }
}