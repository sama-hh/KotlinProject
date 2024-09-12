fun main() {
    val inventory = Inventory()
    val apple = Product(id = "1", name = "Apple", category = "Fruit", price = 0.5, quantity = 100)
    val banana = Product(id = "2", name = "Banana", category = "Fruit", price = 0.3, quantity = 150)
    val milk = Product(id = "3", name = "Milk", category = "Dairy", price = 1.2, quantity = 50)

    inventory.addProduct(apple)
    inventory.addProduct(banana)
    inventory.addProduct(milk)

    println("Products in inventory:")
    inventory.listProducts().forEach { println(it) }
    println("Products in inventory by category 'Fruit':")
    inventory.searchProductsByCategory("Fruit").forEach { println(it) }

    inventory.updateProduct("1", "Green Apple", "Fruit", 0.6, 120)
    println("\nUpdated Products in inventory:")
    inventory.listProducts().forEach { println(it) }

    inventory.deleteProduct("1")
    println("\nProducts in inventory after deletion:")
    inventory.listProducts().forEach { println(it) }
}





