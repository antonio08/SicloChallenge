/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.viewmodel

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel
import mx.com.siclochallenge.data.DayClasses
import java.util.*

class CalendarViewModel : ViewModel() {

    fun displayDayClasses(date: Date) {

    }

    /**
     * Gets the list of classes based on a date
     *
     * @param date Date to look for classes
     * @return the list of classes based on the day provided
     */
    @Nullable
    fun getClasses(@NonNull date: Date): List<DayClasses>? {
        return null
    }

    fun classPreview() {

    }

}