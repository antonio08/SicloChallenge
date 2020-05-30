/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.viewmodel

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.com.siclochallenge.api.request.UserRepository
import mx.com.siclochallenge.data.Calendar
import mx.com.siclochallenge.data.CalendarItinerary
import mx.com.siclochallenge.data.DayClasses
import java.text.SimpleDateFormat
import java.util.*

class CalendarViewModel : ViewModel() {
    private var mClasses = MutableLiveData<DayClasses>()
    private val mClassesCached = MutableLiveData<Boolean>()
    private val mDayClasses = MutableLiveData<List<CalendarItinerary>>()
    private val mUserRepository = UserRepository(mClasses)

    /**
     * Gets the list of classes based on a date
     *
     * @return the list of classes based on the day provided
     */
    @Nullable
    fun fetchClasses() {
        // Call repository to fetch calendar classes
        mUserRepository.retrieveClasses()

        mClasses = mUserRepository.getClassesResult()
    }

    fun setDateToDisplay(date: Date) {
        val calendar = Calendar.getInstance()

        val dayClasses = mutableListOf<CalendarItinerary>()

        calendar.mClasses.forEach { it ->
            val calendarTime = it.mDate.time
            if (isSameDate(date, it.mDate)) {
                dayClasses.add(
                    CalendarItinerary(
                        it.mClassName,
                        it.mInstructorName,
                        it.mDate,
                        it.mTime
                    )
                )
            }
        }

        mDayClasses.value = dayClasses
    }

    /**
     * Gets the classes API response
     *
     * @return the API response
     */
    @Nullable
    fun getClassesApiResponse(): MutableLiveData<DayClasses> {
        return mClasses
    }

    /**
     * Gets the classes cached result
     *
     * @return the classes result
     */
    @Nullable
    fun getClassesCachedResult(): MutableLiveData<Boolean> {
        return mClassesCached
    }

    /**
     * Gets the classes for a day in particular
     *
     * @return the classes itinerary
     */
    @Nullable
    fun getClassesForDay(): MutableLiveData<List<CalendarItinerary>> {
        return mDayClasses
    }

    fun persistClasses(@NonNull classes: DayClasses) {
        val result = mUserRepository.classesToPo(classes)

        mClassesCached.value = result
    }

    fun classPreview() {

    }

    private fun isSameDate(date1 : Date, date2: Date): Boolean{
        val format = SimpleDateFormat.getDateInstance()
        val formattedDate1 = format.format(date1)
        val formattedDate2 = format.format(date2)
        return formattedDate1.equals(formattedDate2)
    }

}