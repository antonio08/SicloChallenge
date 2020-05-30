/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_calendar.*
import mx.com.siclochallenge.R
import mx.com.siclochallenge.ui.adapter.ClassesAdapter
import mx.com.siclochallenge.viewmodel.CalendarViewModel
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var mViewModel: CalendarViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mViewAdapter: RecyclerView.Adapter<*>
    private lateinit var mViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        initialize()

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            mViewModel.fetchClasses(calendar.time)
        }

        observeApiResponse()
    }

    private fun initialize() {
        // Set view model
        mViewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)


        mRecyclerView = findViewById(R.id.classesRecycleView)

        // TODO display classes will be implemented once that the API call is set in place
        mViewAdapter = ClassesAdapter(emptyList())
        mViewManager = LinearLayoutManager(this)

        mRecyclerView.layoutManager = mViewManager
        mRecyclerView.adapter = mViewAdapter
    }

    private fun observeApiResponse() {
        mViewModel.getClassesApiResponse().observe(this, Observer { result ->
            if (result != null) {
                mViewModel.classesToPo(result)
            } else {
                displayMessage(getString(R.string.api_response_failure))
            }
        })
    }

    private fun displayMessage(message: String) {
        Snackbar.make(this.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }
}
