/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.data

import com.google.gson.annotations.SerializedName

class Classes(
    className: String,
    classInstructor: Instructor,
    classDate: String,
    classTime: String
) {

    @SerializedName("tipo")
    val mClassName = className

    @SerializedName("instructor")
    val mClassInstructor = classInstructor

    @SerializedName("fecha")
    val mClassDate = classDate

    @SerializedName("hour")
    val mClassTime = classTime

}