package Problems

fun main() {

    preOrder('a', listOf('b', 'c'))

    println()
    inOrder('a', listOf('b', 'c'))

    println()
    postOrder('a', listOf('b', 'c'))

}

val tree = mapOf(
    ('a' to listOf('b', 'c')),
    ('b' to listOf('d', '.')),
    ('c' to listOf('e', 'f')),
    ('e' to listOf('.', '.')),
    ('f' to listOf('.', 'g')),
    ('d' to listOf('.', '.')),
    ('g' to listOf('.', '.')),
)

fun preOrder(current: Char, child: List<Char>) {

    print("$current ")

    if (child[0] != '.') {
        preOrder(child[0], tree[child[0]]!!)
    }

    if (child[1] != '.') {
        preOrder(child[1], tree[child[1]]!!)
    }
}

fun inOrder(current: Char, child: List<Char>) {
    if (child[0] != '.') {
        inOrder(child[0], tree[child[0]]!!)
    }

    print("$current ")

    if (child[1] != '.') {
        inOrder(child[1], tree[child[1]]!!)
    }
}

fun postOrder(current: Char, child: List<Char>) {
    if (child[0] != '.') {
        postOrder(child[0], tree[child[0]]!!)
    }

    if (child[1] != '.') {
        postOrder(child[1], tree[child[1]]!!)
    }

    print("$current ")
}