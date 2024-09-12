import java.io.File

class Inventory {
    private val products = mutableListOf<Product>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun findProductById(id: String): Product? {
        return products.find { it.id == id }
    }

    fun updateProduct(id: String, name: String, category: String, price: Double, quantity: Int) {
        val product = findProductById(id)
        if (product != null) {
            product.name = name
            product.category = category
            product.price = price
            product.quantity = quantity
        }
    }

    fun deleteProduct(id: String) {
        products.removeIf { it.id == id }
    }

    fun listProducts(): List<Product> {
        return products
    }

    fun searchProductsByCategory(category: String): List<Product> {
        return products.filter { it.category.equals(category, ignoreCase = true) }
    }

    fun calculateTotalValue(): Double {
        return products.sumOf { it.price * it.quantity }
    }

    fun exportToFile(filePath: String) {
        File(filePath).printWriter().use { out ->
            products.forEach { out.println("${it.id},${it.name},${it.category},${it.price},${it.quantity}") }
        }
    }

    fun importFromFile(filePath: String) {
        File(filePath).forEachLine { line ->
            val parts = line.split(',')
            if (parts.size == 5) {
                val product = Product(parts[0], parts[1], parts[2], parts[3].toDouble(), parts[4].toInt())
                addProduct(product)
            }
        }
    }
}
