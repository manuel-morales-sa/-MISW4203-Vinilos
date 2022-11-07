package com.example.vinilos.album.test;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

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
public class VisitorBackButton {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void visitorBackButton() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.visitor_button), withText("Visitante"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.viewRoot),
                                        2),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textViewAlbumTitle), withText("Poeta del pueblo"),
                        withParent(allOf(withId(R.id.container),
                                withParent(withId(R.id.recyclerView)))),
                        isDisplayed()));
        textView.check(matches(withText("Poeta del pueblo")));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction textView2 = onView(
                allOf(withText("Poeta del pueblo"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.appBarLayout)))),
                        isDisplayed()));
        textView2.check(matches(withText("Poeta del pueblo")));

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navegar hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.appBarLayout),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        pressBack();

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textViewAlbumTitle), withText("Poeta del pueblo"),
                        withParent(allOf(withId(R.id.container),
                                withParent(withId(R.id.recyclerView)))),
                        isDisplayed()));
        textView3.check(matches(withText("Poeta del pueblo")));
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
