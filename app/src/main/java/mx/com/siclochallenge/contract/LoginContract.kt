/*
 * Created by Antonio Lozano on 5/28/2020.
 */
package mx.com.siclochallenge.contract

object LoginContract {
    val LOGIN: String
        get() = "ILoginContract.LOGIN"
    val RESULT_VALIDATION_UNKNOWN_ERROR: Int
        get() = -1

    // Validation codes
    val RESULT_VALIDATION_SUCCESS: Int
        get() = 0
    val RESULT_VALIDATION_ERROR_EMPTY_EMAIL: Int
        get() = 1
    val RESULT_VALIDATION_ERROR_EMPTY_PASSWORD: Int
        get() = 2
    val RESULT_VALIDATION_ERROR_INVALID_EMAIL_FORMAT: Int
        get() = 3

    // Login result codes
    val RESULT_USER_LOGIN_SUCCESS: Int
        get() = 4
    val RESULT_USER_LOGIN_FAILED: Int
        get() = 5
}

