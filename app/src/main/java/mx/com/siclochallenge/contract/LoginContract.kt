/*
 * Created by Antonio Lozano on 5/28/2020.
 */
package mx.com.siclochallenge.contract

object LoginContract {
    val LOGIN : String
        get() = "ILoginContract.LOGIN"
    public val RESULT_VALIDATION_UNKNOWN_ERROR : Int
        get() = -1
    val RESULT_VALIDATION_SUCCESS : Int
        get() = 0
    val RESULT_VALIDATION_ERROR_EMPTY_USER_NAME : Int
        get() = 1
    val RESULT_VALIDATION_ERROR_EMPTY_PASSWORD : Int
        get() = 2
}

