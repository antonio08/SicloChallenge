/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.viewmodel

import mx.com.siclochallenge.api.request.UserRepository
import mx.com.siclochallenge.data.Classes
import mx.com.siclochallenge.data.Instructor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
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
        val classInstructor = Instructor(1, "Test", "http://www.fakeurl.com")
        val classTime = "08:00 AM"
        val calendar = Calendar.getInstance()
        calendar.set(2020, 5, 29)
        val date = calendar.time
        val fakeClasses = Classes(className, classInstructor, date.toString(), classTime)
        val expectedDayClasses: List<Classes> = listOf(fakeClasses)
        val mockRetrieveClasses = Mockito.mock(UserRepository::class.java)
        val mockViewModel = Mockito.mock(CalendarViewModel::class.java)
        Mockito.`when`(mockRetrieveClasses.retrieveClasses()).thenReturn(Unit)

        mViewModel.fetchClasses(date)
        val classes = mViewModel.getClassesApiResponse()


        assertEquals(expectedDayClasses, classes)

    }

    @Test
    fun givenDateWithNoClassesWhenSelectingCalendarGetsEmptyClassesList() {
        val calendar = Calendar.getInstance()
        calendar.set(2020, 5, 29)
        val date = calendar.time

        mViewModel.fetchClasses(date)
        val classes = mViewModel.getClassesApiResponse()

        assertNull(classes.value)
    }
}