package com.example.vinilos.album.test;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.vinilos.ui.main.view.MainActivity;
import com.vinylsMobile.vinylsapplication.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AlbumVisitorTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void albumVisitorTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.visitor_button), withText("Visitante"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.viewRoot),
                                        2),
                                1),
                        isDisplayed()));
        SystemClock.sleep(1500);
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textViewAlbumTitle), withText("A Night at the Opera"),
                        withParent(allOf(withId(R.id.container),
                                withParent(withId(R.id.recyclerView)))),
                        isDisplayed()));
        SystemClock.sleep(1500);
        textView.check(matches(withText("A Night at the Opera")));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        SystemClock.sleep(1500);
        recyclerView.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction textView2 = onView(
                allOf(withText("A Night at the Opera"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.appBarLayout)))),
                        isDisplayed()));
        SystemClock.sleep(1500);
        textView2.check(matches(withText("A Night at the Opera")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
