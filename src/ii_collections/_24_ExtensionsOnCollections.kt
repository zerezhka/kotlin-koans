package ii_collections

fun todoTask24(collection: Collection<String>) : Collection<String> {
    val  javaCode = _24_JavaCode()
    return javaCode.doSomethingStrangeWithCollection(collection)
}
/*Nothing = TODO(
    """
        Task 24.
        The function should behave the same as '_24_JavaCode.doSomethingStrangeWithCollection'
        Replace all invocations of 'todoTask24()' with the appropriate code.
    """,
        references = { c: Collection<String> -> _24_JavaCode().doSomethingStrangeWithCollection(c) }
)*/

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { s -> s.length/*todoTask24(collection)*/ }

    return groupsByLength.values.maxBy { group -> group.size/*todoTask24(group)*/ }
}

