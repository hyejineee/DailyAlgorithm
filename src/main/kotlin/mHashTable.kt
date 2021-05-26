class mHashTable {
    private val table = MutableList(10) { "" }
    private val chainingTable = MutableList(10) { emptyList<Pair<Int, String>>() }

    fun put(key: String, value: String) {
        val hashKey = createHashAddress(getKey(key))
        table[hashKey] = value
    }

    fun putWithChaining(key: String, value: String) {
        val hashKey = getKey(key)
        val hashAddress = createHashAddress(hashKey)

        if (chainingTable[hashAddress].isEmpty()) {
            chainingTable[hashAddress] = listOf(Pair(hashKey, value))
            return
        }

        chainingTable[hashAddress] =
            chainingTable[hashAddress]
                .toMutableList()
                .apply {
                    for (i in 0..this.size) {
                        if (this[i].first == hashKey) {
                            this[i] = Pair(hashKey, value)
                            break
                        }

                        this.add(Pair(hashKey, value))
                    }
                }

    }

    fun get(key: String) = table[createHashAddress(getKey(key))]

    fun getWithChaining(key: String) =
        chainingTable[createHashAddress(getKey(key))]
            .find { it.first == getKey(key) }
            ?.second

    private fun getKey(key: String) = key.hashCode()

    private fun createHashAddress(key: Int) = key % 5


}