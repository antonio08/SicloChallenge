/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.data

import com.google.gson.annotations.SerializedName

class DayClasses(dayClasses: Map<String, List<Classes>>) {

    @SerializedName("calendar")
    val mDayClasses = dayClasses

}