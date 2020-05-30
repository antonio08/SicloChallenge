/*
 * Created by Antonio Lozano on 5/28/2020.
 */
package mx.com.siclochallenge.viewmodel

import androidx.annotation.NonNull
import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.com.siclochallenge.api.request.FakeUserLoginRequest
import mx.com.siclochallenge.contract.LoginContract
import org.jetbrains.annotations.NotNull

class LoginViewModel : ViewModel() {
    private val mValidationResultError = MutableLiveData<Int>()
    private val mLoginResult = MutableLiveData<Int>()

    /**
     * Proceeds with the user login
     * @param email User name to validate
     * @param password password to validate
     */
    fun userLogin(@NonNull email: String, @NonNull password: String) {
        val validationResult = validateCredentials(email, password)

        if (validationResult == LoginContract.RESULT_VALIDATION_SUCCESS) {
            proceedToLogin(email, password)
        } else {
            mValidationResultError.value = validationResult
        }
    }

    /**
     * Validates the credentials submitted for the user
     * @param email User name to validate
     * @param password password to validate
     *
     * @return the {@code RESULT_VALIDATION_SUCCESS} if the credentials match the criteria stabilised
     */
    fun validateCredentials(@NonNull email: String, @NotNull password: String): Int {

        if (email.isEmpty()) {
            return LoginContract.RESULT_VALIDATION_ERROR_EMPTY_EMAIL
        }

        if (password.isEmpty()) {
            return LoginContract.RESULT_VALIDATION_ERROR_EMPTY_PASSWORD
        }

        val emailPattern = PatternsCompat.EMAIL_ADDRESS
        if (!emailPattern.matcher(email).matches()) {
            return LoginContract.RESULT_VALIDATION_ERROR_INVALID_EMAIL_FORMAT
        }

        return LoginContract.RESULT_VALIDATION_SUCCESS
    }

    /**
     * Notifies the UI if the credential validation failed and why
     *
     * @return the result error of the credentials validation
     */
    @NonNull
    fun validationResultError(): MutableLiveData<Int> {
        return mValidationResultError
    }

    /**
     * Notifies the UI the login result
     *
     * @return the result of the login process
     */
    @NonNull
    fun loginResult(): MutableLiveData<Int> {
        return mLoginResult
    }

    private fun proceedToLogin(@NonNull email: String, @NonNull password: String) {
        // Create the request
        val fakeUserLoginRequest =
            FakeUserLoginRequest(
                email,
                password
            )
        val loginResult = fakeUserLoginRequest.validateUser()

        mLoginResult.value = loginResult

    }

}
