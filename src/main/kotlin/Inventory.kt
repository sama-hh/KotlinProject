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
}
