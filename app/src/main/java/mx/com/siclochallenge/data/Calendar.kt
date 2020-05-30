/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.data

class Calendar {

    companion object {

        @Volatile private var INSTANCE: Calendar? = null

        fun getInstance(): Calendar =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Calendar().also { INSTANCE = it }
            }
    }

    var mClasses : MutableList<CalendarItinerary> = mutableListOf()
}