data class Product(
    val id: String,
    var name: String,
    var category: String,
    var price: Double,
    var quantity: Int
) {
    override fun toString(): String {
        return "Product[id=$id, name=$name, category=$category, price=$price, quantity=$quantity]"
    }
}