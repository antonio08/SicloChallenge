package mx.com.siclochallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.com.siclochallenge.R
import mx.com.siclochallenge.ui.adapter.ClassesAdapter
import mx.com.siclochallenge.viewmodel.CalendarViewModel

class CalendarActivity : AppCompatActivity() {
    private lateinit var mViewModel: CalendarViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mViewAdapter: RecyclerView.Adapter<*>
    private lateinit var  mViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        // Set view model
        mViewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)

        mRecyclerView = findViewById(R.id.classesRecycleView)

        // TODO display classes will be implemented once that the API call is set in place
        mViewAdapter = ClassesAdapter(emptyList())
        mViewManager = LinearLayoutManager(this)

        mRecyclerView.layoutManager = mViewManager
        mRecyclerView.adapter = mViewAdapter

    }
}
