package mx.com.siclochallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.com.siclochallenge.R
import mx.com.siclochallenge.ui.adapter.ClassesAdapter

class CalendarActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mViewAdapter: RecyclerView.Adapter<*>
    private lateinit var  mViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        mRecyclerView = findViewById(R.id.classesRecycleView)

        // TODO implementation to display classes will be implemented once that the API call is set in place
        mViewAdapter = ClassesAdapter(emptyList())
        mViewManager = LinearLayoutManager(this)

        mRecyclerView.layoutManager = mViewManager
        mRecyclerView.adapter = mViewAdapter

    }
}
