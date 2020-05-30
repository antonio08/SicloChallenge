/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.viewmodel

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.com.siclochallenge.api.request.UserRepository
import mx.com.siclochallenge.data.DayClasses
import java.util.*

class CalendarViewModel : ViewModel() {
    private var mClasses = MutableLiveData<DayClasses>()
    private val mUserRepository = UserRepository(mClasses)

    /**
     * Gets the list of classes based on a date
     *
     * @param date Date to look for classes
     * @return the list of classes based on the day provided
     */
    @Nullable
    fun fetchClasses(@NonNull date: Date) {
        // Call repository to fetch calendar classes
        mUserRepository.retrieveClasses()

        mClasses = mUserRepository.getClassesResult()
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

    fun classesToPo(@NonNull classes: DayClasses) {
        //Todo save classes itinerary
    }

    fun classPreview() {

    }

}