package com.andonichc.postsapp.utils.ext

import android.view.ViewGroup
import com.andonichc.postsapp.presentation.utils.ext.setAllMargins
import junit.framework.Assert.assertEquals
import org.junit.Test

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
}