package ii_collections

import java.util.*

fun example1(list: List<Int>) {

    // If a lambda has exactly one parameter, that parameter can be accessed as 'it'
    val positiveNumbers = list.filter { it > 0 }

    val squares = list.map { it * it }
}

fun Shop.getCitiesCustomersAreFrom(): Set<City> {
    // Return the set of cities the customers are from
//    todoCollectionTask()
    val cities = HashSet<City>()
    for (customer in this.customers){
        cities.add(customer.city)
    }
    return cities
}

fun Shop.getCustomersFrom(city: City): List<Customer> {
    // Return a list of the customers who live in the given city
//    todoCollectionTask()
    val list = ArrayList<Customer>();
    for (customer in this.customers){
        if (customer.city == city) {
            list.add(customer)
        }
    }
    return list
}



