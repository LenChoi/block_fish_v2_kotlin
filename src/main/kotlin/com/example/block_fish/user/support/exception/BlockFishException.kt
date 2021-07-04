package com.example.block_fish.user.support.exception

import java.lang.RuntimeException

class BlockFishException(val errorCode: Int, val messageKey: String? = null) :RuntimeException(messageKey){
    companion object {
        const val UNKNOWN = 1

        const val USER_NOT_FOUND = 100
        const val DUPLICATED_EMAIL = 101
        const val USER_NOT_FOUND_BY_PHONE = 102
        const val USER_NOT_FOUND_BY_EMAIL = 103
        const val TOO_MANY_AUTH_RETRY = 104
        const val TOO_MANY_LOGIN_RETRY = 104

        const val GENERATED_REPORT_NOT_FOUND = 200
        const val NOT_ENOUGH_RECORD = 201

        const val AUTHORIZE_FAIL = 400
        const val UNAUTHORIZED_USER = 403

        const val LOCKED_USER = 501
        const val LOGIN_FAIL = 502
    }
}