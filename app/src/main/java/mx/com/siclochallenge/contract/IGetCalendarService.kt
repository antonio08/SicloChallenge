/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.contract

import mx.com.siclochallenge.data.DayClasses
import retrofit2.Call
import retrofit2.http.GET

interface IGetCalendarService {
    @GET("/api/v2/plus/calendar/?location=603967&page_size=-1")
    fun getCalendar(): Call<DayClasses>
}