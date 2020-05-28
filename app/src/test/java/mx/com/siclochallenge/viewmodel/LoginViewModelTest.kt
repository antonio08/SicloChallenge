/*
 * Created by Antonio Lozano on 5/28/2020.
 */
package mx.com.siclochallenge.viewmodel

import mx.com.siclochallenge.contract.LoginContract
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.MockitoAnnotations

class LoginViewModelTest {
    private lateinit var mViewModel: LoginViewModel

    @BeforeEach
    fun setUp() {
        mViewModel = LoginViewModel()
    }

    @Test
    fun givenUserNameEmptyWhenLoginInUserThenGetsErrorEmptyPassword() {
        val userName = ""
        val password = "test"

        val result = mViewModel.validateCredentials(userName, password)

        assertEquals(LoginContract.RESULT_VALIDATION_ERROR_EMPTY_PASSWORD, result)
    }

    @Test
    fun givenPasswordEmptyWhenLoginInUserThenGetsErrorEmptyUserName() {
        val userName = "Antonio"
        val password = ""

        val result = mViewModel.validateCredentials(userName, password)

        assertEquals(LoginContract.RESULT_VALIDATION_ERROR_EMPTY_USER_NAME, result)
    }

    @Test
    fun givenValidCredentialsWhenLoginInUserThenGetsValidationSuccess() {
        val userName = "Antonio"
        val password = "test"

        val result = mViewModel.validateCredentials(userName, password)

        assertEquals(LoginContract.RESULT_VALIDATION_SUCCESS, result)
    }
}