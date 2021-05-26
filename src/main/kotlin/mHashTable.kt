class mHashTable {
    private val table = MutableList(10) { "" }

    /**
     *   - 데이터 삽입 메소드 만들기 : put
     *      -> key를 받아서 해쉬 키 생성
     *      -> 해쉬 키에 해당 하는 곳에 데이터 저장
     *   - 전체 데이처를 볼 수 있는 메서드 만들기 : all
     *      -> 전체 해쉬 테이블을 순회하면서 pair list로 만들어서 반환
     * */

    fun put(key: String, value: String) {
        println("$key 's key ${getKey(key)}")

        val hashKey = createHashAddress(getKey(key))
        println("$key 's hash address ${createHashAddress(getKey(key))}")
        table[hashKey] = value

        //chaining기법으로 충돌 해결하기


    }

    private fun getKey(key: String) = key.hashCode()

    private fun createHashAddress(key: Int) = key % 5

    fun get(key: String) = table[createHashAddress(getKey(key))]
}