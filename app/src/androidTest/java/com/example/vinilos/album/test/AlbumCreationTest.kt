package com.example.vinilos.album.test


import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.vinilos.ui.main.view.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.vinylsMobile.vinylsapplication.R

@LargeTest
@RunWith(AndroidJUnit4::class)
class AlbumCreationTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun albumCreationTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.collector_button), withText("Coleccionistas"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.viewRoot),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.btn_fab_create_album), withContentDescription("Crear un nuevo album"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.txt_name_album),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout_name),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText.perform(
            scrollTo(),
            replaceText("A head full of dreams"),
            closeSoftKeyboard()
        )

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.txt_url_cover_album),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout_urlCover),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText2.perform(
            scrollTo(),
            replaceText("https://upload.wikimedia.org/wikipedia/en/3/3d/Coldplay_-_A_Head_Full_of_Dreams.png"),
            closeSoftKeyboard()
        )

        val materialAutoCompleteTextView = onView(
            allOf(
                withId(R.id.autoComplete_generos),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout_genero),
                        0
                    ),
                    0
                )
            )
        )
        materialAutoCompleteTextView.perform(scrollTo(), click())

        val materialTextView = onData(anything())
            .inAdapterView(
                childAtPosition(
                    withClassName(`is`("android.widget.PopupWindow$PopupBackgroundView")),
                    0
                )
            )
            .atPosition(2)
        materialTextView.perform(click())

        val materialAutoCompleteTextView2 = onView(
            allOf(
                withId(R.id.autoComplete_records),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout_record),
                        0
                    ),
                    0
                )
            )
        )
        materialAutoCompleteTextView2.perform(scrollTo(), click())

        val materialTextView2 = onData(anything())
            .inAdapterView(
                childAtPosition(
                    withClassName(`is`("android.widget.PopupWindow$PopupBackgroundView")),
                    0
                )
            )
            .atPosition(1)
        materialTextView2.perform(click())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.txt_description_album),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout_description),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText3.perform(
            scrollTo(),
            replaceText("A Head Full Of Dreams �en espa�ol? Una cabeza llena de sue�os� es el s�ptimo �lbum de estudio de la banda brit�nica de pop rock Coldplay. Fue lanzando comercialmente el 4 de diciembre de 2015, por las discogr�ficas Parlophone y Atlantic Records.\u200B"),
            closeSoftKeyboard()
        )

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.txt_date_album),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout_date),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText4.perform(scrollTo(), replaceText("04/12/2015"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btn_create_track_Album), withText("Crear Album"),
                childAtPosition(
                    allOf(
                        withId(R.id.constraintLayout),
                        childAtPosition(
                            withId(R.id.scrollView2),
                            0
                        )
                    ),
                    7
                )
            )
        )
        materialButton2.perform(scrollTo(), click())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.nav_graph_artist), withContentDescription("Artists"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation_view),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.nav_graph_album), withContentDescription("Albums"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation_view),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerView),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(17, click()))

        val textView = onView(
            allOf(
                withId(R.id.textContentAlbum), withText("A head full of dreams"),
                withParent(
                    allOf(
                        withId(R.id.constraintLayout),
                        withParent(IsInstanceOf.instanceOf(ScrollView::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("A head full of dreams")))

        val textView2 = onView(
            allOf(
                withId(R.id.textContentGenre), withText("Rock"),
                withParent(
                    allOf(
                        withId(R.id.constraintLayout),
                        withParent(IsInstanceOf.instanceOf(ScrollView::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Rock")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
