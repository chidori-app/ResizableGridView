# ResizableGridView

ResizableGridView is a library to change the number of columns by pinch in / out.

![Screen Shot](https://raw.githubusercontent.com/chidori-app/ResizableGridView/master/imgs/anime.gif)


## How To Get Started

### Installation with Gradle

```gradle
repositories {
    maven {
        url 'http://chidori-app.github.io/ResizableGridView/repository'
    }
}

dependencies {
    compile 'jp.hitting.android:resizable-gridview:0.0.1'
}
```

### Manual Installation

* Download source code.
* Add ResizableGridView.java and attrs.xml to your project.


## Requirements

Android 2.2.x or higher.


## Usage

### Set up

Define a layout of jp.hitting.android.view.ResizableGridView in layout.xml.

ResizableGridView has the following attributes.

* max_num_columns: the max number of columns (default 6)
* min_num_columns: the min number of columns (default 2)
* numColumns: the number of columns at init (default min_num_columns)


```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/black"
    tools:context="jp.hitting.android.view.sample.MainActivity" >

    <jp.hitting.android.view.ResizableGridView
        android:id="@+id/gridView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:max_num_columns="7"
        app:min_num_columns="2"
        app:numColumns="3" />

</RelativeLayout>
```


### Listener

ResizableGridView has two listener methods.

```Java
public static interface ResizableGridViewListener {
	void onPinchIn();
	void onPinchOut();
}
```


## Example

See the sample module.



## Credits

ResizableGridView was created by [IOKA Masakazu](http://www.hitting.jp) in the development of [Chidori](http://nscallop.jp/chidori/)

ResizableGridView is used in [Chidori](http://nscallop.jp/chidori/), Android application.



## Contact

Ask nscallop on Twitter ([@nscallop](https://twitter.com/nscallop))



## License

The MIT License (MIT)

Copyright (c) 2015 IOKA

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
