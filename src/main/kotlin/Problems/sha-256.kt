package Problems

import java.security.MessageDigest

fun sha256(s: String): String =
    MessageDigest.getInstance("SHA-256")
        .apply {
            update(s.toByteArray())
        }
        .digest()
        .fold("", { str, it ->
            str + "%02x".format(it)
        })
