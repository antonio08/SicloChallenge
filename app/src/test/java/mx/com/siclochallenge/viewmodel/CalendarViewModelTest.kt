/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.viewmodel

import mx.com.siclochallenge.data.Classes
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

internal class CalendarViewModelTest {
    private lateinit var mViewModel: CalendarViewModel

    @BeforeEach
    fun setUp() {
        mViewModel = CalendarViewModel()
    }

    @Test
    fun givenDateWhenSelectingCalendarGetsClassesList() {
        val className = "Class Siclo"
        val classInstructor = "Instructor"
        val classTime = "08:00 AM"
        val calendar = Calendar.getInstance()
        calendar.set(2020, 5, 29)
        val date =  calendar.time
        val fakeClasses = Classes(className, classInstructor, classTime)
        val expectedDayClasses : List<Classes> = listOf(fakeClasses)

        val classes = mViewModel.getClasses(date)
        //TODO mock retorfit call

        assertEquals(expectedDayClasses, classes)

    }

    @Test
    fun givenDateWithNoClassesWhenSelectingCalendarGetsEmptyClassesList() {
        val calendar = Calendar.getInstance()
        calendar.set(2020, 5, 29)
        val date =  calendar.time

        val classes = mViewModel.getClasses(date)
        //TODO mock retorfit call

        assertNull(classes)
    }
}