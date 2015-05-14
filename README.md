SwipeRefreshLayoutBottom Demo
================
A control for Android apps that lets a user "pull up" from the bottom of content (usually a list) to refresh or load more items. This is a mirror of Android's SwipeRefreshLayout control.

![Shutterstock Demo](https://github.com/JohannBlake/SwipeRefreshLayoutBottom/blob/master/Graphics/SwipeRefreshLayoutBottom-Demo-Screenshot.gif)


### Description

This control is a direct port of Android's SwipeRefreshLayout control but with the code modified to allow the control to be used at the bottom of containers rather than the top and refresh is initiated by pulling up as opposed to pulling down as it is with the SwipeRefreshControl.

Historically, apps use to include some means of loading more items when you reached the bottom of the list. This was either done by having a button at the bottom of the list that the user had to tap. Automatic loading is also often used where additional items get loaded as soon as the user scrolls to the end. Both solutions are out of date. The button solution looks ugly and takes up space. Auto-loading when reaching the bottom can result in a waste of network resources when the items are retrieved from a server and the user really isn't interested in loading more items.


### Installation

You can quickly run the app by installing the apk file. It's SwipeRefreshLayoutBotom-Demo-x.x.apk and located in the root directory. The code is also compiled as an aar file that you can also just use as-is. It's the file swiperefreshlayoutbottom-x.x.aar also located in the root directory.

### Acknowledgements

Special thanks to AndreyICE for porting the code from Android's original source for SwipeRefreshLayout and making the necessary modifications. AndreyICE's code can be downloaded from Bitbucket at:

https://bitbucket.org/andreyice/swiperefreshlayoutbottom

That code however was not setup as an Android Studio project which is why I imported it into an Android Studio project using Gradle for the build. I also created the control as as Android aar library. Android Studio 1.2.1.1 was used to create the project.

### MIT License

```
    The MIT License (MIT)

    Copyright (c) 2015 Johann Blake

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
```
