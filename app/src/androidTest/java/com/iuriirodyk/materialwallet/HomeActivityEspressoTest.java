package com.iuriirodyk.materialwallet;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.iuriirodyk.materialwallet.ui.activity.HomeActivity_;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 02.04.2018.
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityEspressoTest {

    @Rule
    public ActivityTestRule<HomeActivity_> mActivityRule =
            new ActivityTestRule<>(HomeActivity_.class);

    @Test
    public void ensureUserPhotoIsClickable() {
        onView(withId(R.id.iv_user_photo)).perform(click());
    }

    @Test
    public void ensureMenuIsClickable() {
        onView(withId(R.id.ib_menu)).perform(click());
    }

    @Test
    public void ensureSearchIsClickable() {
        onView(withId(R.id.ib_search)).perform(click());
    }

    @Test
    public void checkNewActivityStartedOnViewpagerItemClick() {
        onView(allOf(withId(R.id.iv_card), isDisplayed())).perform(click());
        onView(withId(R.id.card_details_root_layout)).check(matches(isDisplayed()));
    }
}
