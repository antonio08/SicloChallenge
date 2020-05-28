/*
 * Created by Antonio Lozano on 5/27/2020.
 */

package mx.com.siclochallenge.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import mx.com.siclochallenge.R
import mx.com.siclochallenge.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Set view model
        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }
}