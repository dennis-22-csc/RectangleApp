package com.mycompany.rectangleapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private View decorView;

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule=new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp(){
        activityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity activity) {
                decorView=activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    public void testThatWhenDimensionsAreTypedAndButtonIsClickedToastIsDisplayed(){
        //Type dimensions in EditTexts
        onView(withId(R.id.edittext1)).perform(typeText("5"), closeSoftKeyboard());
        onView(withId(R.id.edittext2)).perform(typeText("4"), closeSoftKeyboard());

        //Click button
        onView(withId(R.id.area_button)).perform(click());

        //Assert that toast with text 20.0 is displayed in UI
        onView(withText("20.0"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

}
