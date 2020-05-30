/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_calendar.*
import mx.com.siclochallenge.R
import mx.com.siclochallenge.data.CalendarItinerary
import mx.com.siclochallenge.ui.adapter.ClassesAdapter
import mx.com.siclochallenge.viewmodel.CalendarViewModel
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var mViewModel: CalendarViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mViewAdapter: RecyclerView.Adapter<*>
    private lateinit var mViewManager: RecyclerView.LayoutManager
    private var mClassesItinerary: MutableList<CalendarItinerary> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        initialize()

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            mViewModel.setDateToDisplay(calendar.time)

        }

        // Observe API result
        observeApiResponse()

        // Observe Classes cached result
        observeClassesCachedResult()

        // Observe classes for days elected
        observeClassesForDay()
    }

    private fun initialize() {

        progressBar.visibility = View.VISIBLE

        // Set view model
        mViewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)
        mViewModel.fetchClasses()


        mRecyclerView = findViewById(R.id.classesRecycleView)

        mViewAdapter = ClassesAdapter(mClassesItinerary)
        mViewManager = LinearLayoutManager(this)

        mRecyclerView.layoutManager = mViewManager
        mRecyclerView.adapter = mViewAdapter
    }

    private fun observeApiResponse() {
        mViewModel.getClassesApiResponse().observe(this, Observer { result ->
            if (result != null) {
                mViewModel.persistClasses(result)
            } else {
                displayMessage(getString(R.string.api_response_failure))
            }
        })
    }

    private fun observeClassesCachedResult() {
        mViewModel.getClassesCachedResult().observe(this, Observer { result ->
            if (result) {
                val currentDate = Calendar.getInstance().time
                mViewModel.setDateToDisplay(currentDate)
            } else {
                progressBar.visibility = View.GONE
                displayMessage(getString(R.string.api_response_failure))
            }
        })
    }

    private fun observeClassesForDay() {
        mViewModel.getClassesForDay().observe(this, Observer { result ->
            progressBar.visibility = View.GONE
            if (result.isNotEmpty()) {
                updateAdapter(result)
            } else {
                updateAdapter(listOf())
                displayMessage(getString(R.string.no_classes))
            }
        })
    }

    private fun updateAdapter(classesUpdated: List<CalendarItinerary>) {
        mClassesItinerary.clear()
        mClassesItinerary.addAll(classesUpdated)
        mViewAdapter.notifyDataSetChanged()
    }

    private fun displayMessage(message: String) {
        Snackbar.make(this.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }
}
