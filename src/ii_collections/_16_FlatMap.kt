package ii_collections

import java.util.*

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products ordered by customer
//    todoCollectionTask()
    val products = HashSet<Product>()
    for (order in this.orders){
        products.addAll(order.products)
    }
    return products
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
//    todoCollectionTask()
    val set = HashSet<Product>()
    for (customer in this.customers){
        set.addAll(customer.orderedProducts)
    }
    return set
}
