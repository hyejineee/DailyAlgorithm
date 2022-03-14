package Programmers

fun travelRoute(tickets: Array<Array<String>>): Array<String> {

    val graph = mutableMapOf<String, MutableList<String>>()
    val check = Array(tickets.size) { false }
    val result = mutableListOf<List<String>>()

    tickets.forEach { it ->
        val (s, e) = it
        graph[s]?.add(e) ?: run { graph[s] = mutableListOf(e) }
    }

    dfs("ICN", mutableListOf("ICN"), graph, result, check, tickets)
    result.sortBy { it.joinToString("") }

    return result.first().toTypedArray()
}

private fun dfs(
    departure: String,
    visited: MutableList<String>,
    g: MutableMap<String, MutableList<String>>,
    result: MutableList<List<String>>,
    check: Array<Boolean>,
    tickets: Array<Array<String>>
) {

    if (check.all { it }) {
        result.add(visited.toList())
        return
    }

    g[departure]?.forEach {

        val ticketIndex = findTicketIndex(tickets, arrayOf(departure, it), check)

        if(ticketIndex == -1) return@forEach

        val newCheck = check.copyOf()
        newCheck[ticketIndex] = true

        visited.add(it)
        dfs(it, visited, g, result, newCheck, tickets)
        visited.removeAt(visited.size - 1)
    }
}

private fun findTicketIndex(tickets: Array<Array<String>>, ticket: Array<String>, check: Array<Boolean>): Int {
    for (i in tickets.indices) {
        if (tickets[i].contentEquals(ticket) && check[i].not()) {
            return i
        }
    }
    return -1
}
