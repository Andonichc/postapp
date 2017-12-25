package com.andonichc.postsapp.utils.ext

import android.view.View
import android.view.ViewGroup
import com.andonichc.postsapp.presentation.utils.ext.*
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

const val MARGIN_INT = 16
const val MARGIN_FLOAT = 16F

class ViewExtTest {
    @Test
    fun setAllMargins_sets_margins_with_Int() {
        //Given
        val params = ViewGroup.MarginLayoutParams(0, 0)

        //When
        params.setAllMargins(MARGIN_INT)

        //Then
        assertEquals(MARGIN_INT, params.leftMargin)
        assertEquals(MARGIN_INT, params.rightMargin)
        assertEquals(MARGIN_INT, params.topMargin)
        assertEquals(MARGIN_INT, params.bottomMargin)
    }

    @Test
    fun setAllMargins_sets_margins_with_Float() {
        //Given
        val params = ViewGroup.MarginLayoutParams(0, 0)

        //When
        params.setAllMargins(MARGIN_FLOAT)

        //Then
        assertEquals(MARGIN_FLOAT.toInt(), params.leftMargin)
        assertEquals(MARGIN_FLOAT.toInt(), params.rightMargin)
        assertEquals(MARGIN_FLOAT.toInt(), params.topMargin)
        assertEquals(MARGIN_FLOAT.toInt(), params.bottomMargin)
    }

    @Test
    fun visible_calls_set_visibility() {
        //Given
        val view = mock(View::class.java)

        //When
        view.visible()

        //Then
        verify(view).visibility = View.VISIBLE
    }

    @Test
    fun invisible_calls_set_visibility() {
        //Given
        val view = mock(View::class.java)

        //When
        view.invisible()

        //Then
        verify(view).visibility = View.INVISIBLE
    }

    @Test
    fun gone_calls_set_visibility() {
        //Given
        val view = mock(View::class.java)

        //When
        view.gone()

        //Then
        verify(view).visibility = View.GONE
    }
}