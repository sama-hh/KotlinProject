import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InventoryTest {

    @Test
    fun testAddProduct() {
        val inventory = Inventory()
        val product = Product(id = "1", name = "Apple", category = "Fruit", price = 0.5, quantity = 100)
        inventory.addProduct(product)
        assertEquals(1, inventory.listProducts().size)
        assertEquals("Apple", inventory.listProducts()[0].name)
    }

    @Test
    fun testUpdateProduct() {
        val inventory = Inventory()
        val product = Product(id = "1", name = "Apple", category = "Fruit", price = 0.5, quantity = 100)
        inventory.addProduct(product)
        inventory.updateProduct("1", "Green Apple", "Fruit", 0.6, 120)
        val updatedProduct = inventory.findProductById("1")
        assertNotNull(updatedProduct)
        assertEquals("Green Apple", updatedProduct?.name)
        assertEquals(0.6, updatedProduct?.price)
        assertEquals(120, updatedProduct?.quantity)
    }

    @Test
    fun testDeleteProduct() {
        val inventory = Inventory()
        val product = Product(id = "1", name = "Apple", category = "Fruit", price = 0.5, quantity = 100)
        inventory.addProduct(product)
        inventory.deleteProduct("1")
        assertEquals(0, inventory.listProducts().size)
    }
}
