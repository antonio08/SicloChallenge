/*
 * Created by Antonio Lozano on 5/27/2020.
 */

package mx.com.siclochallenge.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import mx.com.siclochallenge.R
import mx.com.siclochallenge.contract.LoginContract
import mx.com.siclochallenge.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var mViewModel: LoginViewModel

    private val mClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.signInButton -> mViewModel.userLogin(
                inputEmail.text.toString(),
                inputPassword.text.toString()
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Set view model
        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        signInButton.setOnClickListener(mClickListener)

        // Observe credential validation changes
        observeCredentialValidationResult()

        // Observe login result
        observeLoginResult()
    }

    private fun observeCredentialValidationResult() {
        mViewModel.validationResultError().observe(this, Observer { result ->
            when (result) {
                LoginContract.RESULT_VALIDATION_ERROR_INVALID_EMAIL_FORMAT -> {
                    displayMessage(
                        getString(R.string.invalid_email)
                    )
                }

                LoginContract.RESULT_VALIDATION_ERROR_EMPTY_EMAIL -> {
                    displayMessage(
                        getString(R.string.empty_email)
                    )
                }

                LoginContract.RESULT_VALIDATION_ERROR_EMPTY_PASSWORD -> {
                    displayMessage(
                        getString(R.string.empty_password)
                    )
                }
            }
        })
    }

    private fun observeLoginResult() {
        mViewModel.loginResult().observe(this, Observer { result ->
            when (result) {
                LoginContract.RESULT_USER_LOGIN_SUCCESS -> {
                    startActivity(Intent(this, CalendarActivity::class.java))
                }

                LoginContract.RESULT_USER_LOGIN_FAILED -> {
                    displayMessage(getString(R.string.login_failed))
                }
            }
        })
    }

    private fun displayMessage(message: String) {
        Snackbar.make(this.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }
}