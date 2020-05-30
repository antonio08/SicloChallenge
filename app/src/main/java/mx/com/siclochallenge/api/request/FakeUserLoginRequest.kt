/*
 * Created by Antonio Lozano on 5/28/2020.
 */
package mx.com.siclochallenge.api.request

import mx.com.siclochallenge.contract.LoginContract

/**
 * This call works only as a fake call to validate user credentials
 */
class FakeUserLoginRequest(email: String, password: String) {

    /**
     * Starts the process to validate user credentials
     * @return {@code LoginContract.RESULT_USER_LOGIN_SUCCESS}
     */
    fun validateUser(): Int {
        return LoginContract.RESULT_USER_LOGIN_SUCCESS
    }
}

