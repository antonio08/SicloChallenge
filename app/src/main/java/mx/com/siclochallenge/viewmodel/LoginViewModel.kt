/*
 * Created by Antonio Lozano on 5/28/2020.
 */
package mx.com.siclochallenge.viewmodel

import androidx.lifecycle.ViewModel
import mx.com.siclochallenge.contract.LoginContract

class LoginViewModel : ViewModel() {

    /**
     * Validates the credentials submitted for the user
     * @param userName User name to validate
     * @param password password to validate
     *
     * @return the {@code RESULT_VALIDATION_SUCCESS} if the credentials match the criteria stabilised
     */
    fun validateCredentials(userName: String, password: String): Int {
        var result = LoginContract.RESULT_VALIDATION_UNKNOWN_ERROR

        return result
    }

}
