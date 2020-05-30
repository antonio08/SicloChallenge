/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.api.request

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.MutableLiveData
import mx.com.siclochallenge.api.RetrofitClientInstance
import mx.com.siclochallenge.contract.IGetCalendarService
import mx.com.siclochallenge.data.Calendar
import mx.com.siclochallenge.data.CalendarItinerary
import mx.com.siclochallenge.data.Classes
import mx.com.siclochallenge.data.DayClasses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class UserRepository(@NonNull classes: MutableLiveData<DayClasses>) {
    private val mService =
        RetrofitClientInstance.getClient().create(IGetCalendarService::class.java)
    private val mClasses = classes

    /**
     * Executes API call to retrieve classes itinerary
     */
    fun retrieveClasses() {
        val call = mService.getCalendar()
        call.enqueue(object : Callback<DayClasses> {
            override fun onFailure(call: Call<DayClasses>, t: Throwable) {
                mClasses.postValue(null)
            }

            override fun onResponse(
                call: Call<DayClasses>,
                response: Response<DayClasses>
            ) {
                mClasses.postValue(response.body())
            }
        })
    }

    /**
     * Gets the classes itinerary from the API call
     *
     * @return class itinerary
     */
    @Nullable
    fun getClassesResult(): MutableLiveData<DayClasses> {
        return mClasses
    }

    fun classesToPo(dayClasses: DayClasses) : Boolean{

        try {
            dayClasses.mDayClasses.forEach{ it ->
                toPo(it.value)
            }
        }catch (ex : Exception){
            return false
        }

        return true
    }

    private fun toPo(classesList : List<Classes>){
        val calendar = Calendar.getInstance()
        SimpleDateFormat.getDateInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)

        classesList.forEach { it ->
            val date = dateFormat.parse(it.mClassDate)

            calendar.mClasses.add(CalendarItinerary(
                it.mClassName,
                it.mClassInstructor.mName,
                date,
                it.mClassTime
            ))
        }
    }


}