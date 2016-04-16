# Circular loader integrated with a floating action button.

[![GitHub license](https://img.shields.io/crates/l/rustc-serialize.svg)](https://github.com/DmitryMalkovich/circular-with-floating-action-button/blob/master/LICENSE.txt)

Progress Floating Action Button helps to integrate circular progress bar to fab with minimal effort. Also it supports all default functionality of floating action button and progress bar. Idea was to not create custom floating action button, but help to integrate circular progress to a floating action button like described here: https://www.google.com/design/spec/components/progress-activity.html#progress-activity-types-of-indicators.

<img width="60%" src="https://cloud.githubusercontent.com/assets/2931932/14582337/84424940-040a-11e6-9236-d362606055bb.png" />

### Getting Started

For using it you need to add one small file to your project: `ProgressFloatingActionButton.java`
After that you can add your fab and progress bar inside 'ProgressFloatingActionButton'. Like you see below to achieve progress bar integration with floating action button. In near future I plan to add more examples and features that helps you to work with it.

```xml
<com.dmitrymalkovich.android.progressfabsample.ProgressFloatingActionButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="@dimen/fab_margin"
        android:clickable="true"
        app:layout_anchor="@id/app_bar"
        app:layout_anchorGravity="bottom|end">

        <android.support.design.widget.FloatingActionButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/ic_backup_black_24dp"
            app:backgroundTint="@color/colorFab" />

        <ProgressBar
            style="@style/Widget.AppCompat.ProgressBar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

    </com.dmitrymalkovich.android.progressfabsample.ProgressFloatingActionButton>
```

We persist all default functionalty and flexibility, so you customize your fab as before. Happy coding!

## Sample Project

You can download the sample APK from this repo here: https://github.com/DmitryMalkovich/circular-with-floating-action-button/releases/tag/v0.1.1

## License

Copyright 2016 Dmitry Malkovich

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
