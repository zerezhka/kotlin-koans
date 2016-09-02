package ii_collections

import java.util.*

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
//    todoCollectionTask()
    val customers = HashSet<Customer>()
    this.customers.forEach { customer -> customer.orders.forEach { order -> if (order.products.contains(product)) customers.add(customer)} }
    return customers
}


fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
//    todoCollectionTask()
    this.orders.forEach { order -> if (order.isDelivered) return order.products.maxBy { it.price } }
    return null
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
//    todoCollectionTask()
    var i = 0
    this.customers.forEach { customer -> customer.orders.forEach { it.products.forEach { prod -> if (product == prod) i++} }}
    return i
}
