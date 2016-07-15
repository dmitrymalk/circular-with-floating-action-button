# Circular loader integrated with a floating action button.

[![Crates.io](https://img.shields.io/crates/l/rustc-serialize.svg?maxAge=2592000)]() [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-circular--with--floating--action--button-green.svg?style=true)](https://android-arsenal.com/details/1/3485) [![Bintray](https://img.shields.io/bintray/v/asciidoctor/maven/asciidoctorj.svg?maxAge=2592000)](https://bintray.com/dmitrymalkovich/maven/progress-fab/view)

Add a circular progress bar to any existing fab. Idea was to not create custom floating action button, but help to **integrate existing circular progress with existing floating action button** like described here: https://www.google.com/design/spec/components/progress-activity.html#progress-activity-types-of-indicators.

<img width="359" alt="screen shot 2016-04-17 at 20 00 03" src="https://cloud.githubusercontent.com/assets/2931932/14588785/b15cb84a-04da-11e6-9771-b0e54b6a6201.png"/>

### Sample Project

You can download the sample APK here: https://github.com/DmitryMalkovich/circular-with-floating-action-button/releases/tag/v1.6

### Usage

- Add to your project via **Gradle**
```
compile 'com.dmitrymalkovich.android:progress-fab:1.6'
```
- Add your progress bar and floating action button to ProgressFloatingActionButton in your layout

```xml
<com.dmitrymalkovich.android.ProgressFloatingActionButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="@dimen/fab_margin"
        android:clickable="true">

        <android.support.design.widget.FloatingActionButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/ic_backup_black_24dp" />

        <ProgressBar
            style="@style/Widget.AppCompat.ProgressBar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

    </com.dmitrymalkovich.android.ProgressFloatingActionButton>
```

<img width="60%" src="https://cloud.githubusercontent.com/assets/2931932/14582337/84424940-040a-11e6-9236-d362606055bb.png" />

## Contributing

Just make pull request! 

### External contributors

* [Tunous](https://github.com/Tunous)
* [ligi] (https://github.com/ligi)

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
