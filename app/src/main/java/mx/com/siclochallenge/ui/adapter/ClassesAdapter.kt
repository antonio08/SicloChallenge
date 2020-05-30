/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.com.siclochallenge.R
import mx.com.siclochallenge.data.CalendarItinerary


class ClassesAdapter(dataSet: List<CalendarItinerary>) :
    RecyclerView.Adapter<ClassesAdapter.ClassesViewHolder>() {
    private val mDataSet = dataSet

    class ClassesViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var mClassName: TextView = view.findViewById(R.id.className)
        var mInstructorName: TextView = view.findViewById(R.id.instructorName)
        var mClassTime: TextView = view.findViewById(R.id.classTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ClassesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.class_element, parent, false)
        return ClassesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.mClassName.text = mDataSet[position].mClassName
        holder.mInstructorName.text = mDataSet[position].mInstructorName
        holder.mClassTime.text = mDataSet[position].mTime
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

}