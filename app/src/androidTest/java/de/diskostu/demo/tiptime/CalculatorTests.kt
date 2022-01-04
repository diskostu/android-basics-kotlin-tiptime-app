package de.diskostu.demo.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test

class CalculatorTests {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_tip_1_rounded() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("54.00"))
        onView(withId(R.id.option_twenty_percent)).perform(click())

        onView(withId(R.id.button_calculate)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("11.00"))))
        onView(withId(R.id.final_sum)).check(matches(withText(containsString("65.00"))))
    }

    @Test
    fun calculate_tip_1_not_rounded() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("54.00"))
        onView(withId(R.id.option_twenty_percent)).perform(click())
        onView(withId(R.id.round_up_switch)).perform(click())


        onView(withId(R.id.button_calculate)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("10.80"))))
        onView(withId(R.id.final_sum)).check(matches(withText(containsString("64.80"))))
    }

    @Test
    fun calculate_tip_2_rounded() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.option_eighteen_percent)).perform(click())

        onView(withId(R.id.button_calculate)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("9.00"))))
        onView(withId(R.id.final_sum)).check(matches(withText(containsString("59.00"))))
    }

    @Test
    fun calculate_tip_3_rounded() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.option_fifteen_percent)).perform(click())

        onView(withId(R.id.button_calculate)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("8.00"))))
        onView(withId(R.id.final_sum)).check(matches(withText(containsString("58.00"))))
    }
}