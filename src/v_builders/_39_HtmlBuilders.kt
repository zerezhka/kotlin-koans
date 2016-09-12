package v_builders

import util.TODO
import util.doc39
import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"

fun todoTask39(): Nothing = TODO(
    """
        Task 39.
        1) Fill the table with the proper values from products.
        2) Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can run the 'Html Demo' configuration in IntelliJ IDEA to see the rendered table.
    """,
    documentation = doc39()
)

fun renderProductTable(): String {
    return html {
        table {
            tr {
                td (getTitleColor()){
                    text("Product")
                }
                td (getTitleColor()){
                    text("Price")

                }
                td (getTitleColor()){
                    text("Popularity")
                }
            }
            val products = getProducts()
            products.forEach {  product -> tr {
                td (getCellColor(products.indexOf(product),0)){
                    text(product.description)
                }
                td (getCellColor(products.indexOf(product),1)){
                    text(product.price)
                }
                td (getCellColor(products.indexOf(product),2)){
                    text(product.popularity)
                }
            }}
        }
    }.toString()
}
