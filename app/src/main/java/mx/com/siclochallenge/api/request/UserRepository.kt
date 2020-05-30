/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.api.request

import androidx.lifecycle.MutableLiveData
import mx.com.siclochallenge.api.RetrofitClientInstance
import mx.com.siclochallenge.contract.IGetCalendarService
import mx.com.siclochallenge.data.DayClasses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(classes: MutableLiveData<DayClasses>) {
    private val mService =
        RetrofitClientInstance.getClient().create(IGetCalendarService::class.java)
    private val mClasses = classes

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

    fun getClassesResult(): MutableLiveData<DayClasses> {
        return mClasses
    }


}