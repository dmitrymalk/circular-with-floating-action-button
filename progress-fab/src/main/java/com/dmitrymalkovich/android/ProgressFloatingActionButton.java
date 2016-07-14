/*
 * Copyright 2016.  Dmitry Malkovich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dmitrymalkovich.android;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/**
 * ProgressFloatingActionButton.java
 * Created by: Dmitry Malkovich
 * <p/>
 * A circular loader is integrated with a floating action button.
 */
@CoordinatorLayout.DefaultBehavior(ProgressFloatingActionButton.Behavior.class)
public class ProgressFloatingActionButton extends FrameLayout {

    private ProgressBar mProgressBar;
    private FloatingActionButton mFab;

    public ProgressFloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (getChildCount() == 0 || getChildCount() > 2) {
            throw new IllegalStateException("Specify only 2 views.");
        }

        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof ProgressBar) {
                mProgressBar = (ProgressBar) view;
            } else if (view instanceof FloatingActionButton) {
                mFab = (FloatingActionButton) view;
            } else {
                throw new IllegalStateException("Specify FAB and Progress Bar" +
                        "as view's children in your layout.");
            }
        }

        if (mFab == null) {
            throw new IllegalStateException("Floating Action Button not specified");
        } else if (mProgressBar == null) {
            throw new IllegalStateException("Progress Bar not specified");
        }

        LayoutParams mFabParams = ((LayoutParams) mFab.getLayoutParams());
        LayoutParams mProgressParams = ((LayoutParams) mProgressBar.getLayoutParams());

        int additionSize = getResources().getDimensionPixelSize(R.dimen.progress_bar_size);
        mProgressBar.getLayoutParams().height = mFab.getHeight() + additionSize;
        mProgressBar.getLayoutParams().width = mFab.getWidth() + additionSize;

        mFabParams.gravity = Gravity.CENTER;
        mProgressParams.gravity = Gravity.CENTER;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mFab != null && mProgressBar != null) {
            LayoutParams mFabParams = ((LayoutParams) mFab.getLayoutParams());
            LayoutParams mProgressParams = ((LayoutParams) mProgressBar.getLayoutParams());

            int additionSize = getResources().getDimensionPixelSize(R.dimen.progress_bar_size);
            mProgressBar.getLayoutParams().height = mFab.getHeight() + additionSize;
            mProgressBar.getLayoutParams().width = mFab.getWidth() + additionSize;

            mFabParams.gravity = Gravity.CENTER;
            mProgressParams.gravity = Gravity.CENTER;
        }
    }

    /**
     * Created by: Dmitry Malkovich
     * Thanks to https://lab.getbase.com/introduction-to-coordinator-layout-on-android/
     */
    public static class Behavior extends CoordinatorLayout.Behavior<ProgressFloatingActionButton> {
        public Behavior() {
            super();
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, ProgressFloatingActionButton child,
                                       View dependency) {
            return dependency instanceof Snackbar.SnackbarLayout;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent,
                                              ProgressFloatingActionButton child, View dependency) {
            float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
            if (child.getBottom() > dependency.getTop()) {
                child.setTranslationY(translationY);
            }
            return true;
        }
    }
}
