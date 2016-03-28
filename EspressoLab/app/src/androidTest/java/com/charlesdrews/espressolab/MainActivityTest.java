package com.charlesdrews.espressolab;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by charlie on 3/28/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testIfBalanceVisible() {
        onView(withId(R.id.balance)).check(matches(isDisplayed()));
        onView(withId(R.id.balance)).check(matches(withText("Current balance: $999,999.99")));
    }

    @Test
    public void testIfDepositIncreasesBalance() {
        onView(withId(R.id.transaction_amount)).perform(typeText("0.01"));
        onView(withId(R.id.deposit_button)).perform(click());
        onView(withId(R.id.balance)).check(matches(withText("Current balance: $1,000,000.00")));
    }

    @Test
    public void testIfWithdrawDecreasesBalance() {
        onView(withId(R.id.transaction_amount)).perform(typeText("1000"));
        onView(withId(R.id.withdraw_button)).perform(click());
        onView(withId(R.id.balance)).check(matches(withText("Current balance: $998,999.99")));
    }

    @Test
    public void testIfProfileVisible() {
        onView(withId(R.id.view_profile_button)).perform(click());
        onView(withId(R.id.name)).check(matches(isDisplayed()));
        onView(withId(R.id.email_address)).check(matches(isDisplayed()));
    }
}
