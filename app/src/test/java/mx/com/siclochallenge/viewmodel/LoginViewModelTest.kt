/*
 * Created by Antonio Lozano on 5/28/2020.
 */
package mx.com.siclochallenge.viewmodel

import mx.com.siclochallenge.contract.LoginContract
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginViewModelTest {
    private lateinit var mViewModel: LoginViewModel

    @BeforeEach
    fun setUp() {
        mViewModel = LoginViewModel()
    }

    @Test
    fun givenPasswordEmptyWhenLoginInUserThenGetsErrorEmptyPassword() {
        val email = "test@email.com"
        val password = ""

        val result = mViewModel.validateCredentials(email, password)

        assertEquals(LoginContract.RESULT_VALIDATION_ERROR_EMPTY_PASSWORD, result)
    }

    @Test
    fun givenEmailEmptyWhenLoginInUserThenGetsErrorEmptyUserName() {
        val email = ""
        val password = "Test"

        val result = mViewModel.validateCredentials(email, password)

        assertEquals(LoginContract.RESULT_VALIDATION_ERROR_EMPTY_EMAIL, result)
    }

    @Test
    fun givenInvalidEmailWhenLoginInUserThenGetsErrorInvalidEmailFormat() {
        val email = "not an email"
        val password = "Test"

        val result = mViewModel.validateCredentials(email, password)

        assertEquals(LoginContract.RESULT_VALIDATION_ERROR_INVALID_EMAIL_FORMAT, result)
    }

    @Test
    fun givenValidCredentialsWhenLoginInUserThenGetsValidationSuccess() {
        val userName = "test@email.com"
        val password = "test"

        val result = mViewModel.validateCredentials(userName, password)

        assertEquals(LoginContract.RESULT_VALIDATION_SUCCESS, result)
    }
}