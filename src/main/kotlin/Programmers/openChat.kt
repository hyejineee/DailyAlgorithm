package Programmers

fun openChatRoom(record: Array<String>): Array<String> {
    val actions = mutableListOf<Pair<String, Message>>()
    val idNicknameMap = mutableMapOf<String, String>()

    record.forEach {
        val info = it.split(" ")

        val action = when(info[0]){
            Message.Enter.name -> Message.Enter
            Message.Leave.name -> Message.Leave
            else -> Message.Change
        }

        val uid = info[1]

        if((action == Message.Enter) or (action == Message.Leave)){
            actions.add(Pair(uid, action))
        }

        var nickName:String? = null
        if(action != Message.Leave){
            nickName = info[2]
        }

        nickName?.let { nic->
            idNicknameMap[uid] = nic
        }
    }

    val result = actions.map {
        "${idNicknameMap[it.first]}${it.second.msgText}"
    }.toTypedArray()

    return result
}

private enum class Message(val msgText:String? = null){
    Enter("님이 들어왔습니다."),
    Leave("님이 나갔습니다."),
    Change()

}
