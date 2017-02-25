# SomaScrobblerApi for Android
[![Download](https://api.bintray.com/packages/saschpe/maven/android-somascrobblerapi/images/download.svg)](https://bintray.com/saschpe/maven/android-somascrobblerapi/_latestVersion)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/saschpe/android-versioninfo.svg?branch=master)](https://travis-ci.org/saschpe/android-versioninfo)
[![Methods and size](https://img.shields.io/badge/Methods and size-core: 51 | deps: 4669 | 10 KB-e91e63.svg)](http://www.methodscount.com/?lib=saschpe.android%3Asomascrobblerapi%3A1.0.6)

Android client library for [SomaScrobbler API][somascrob]. The test-suite
defaults to the official deployment at [api.somascrobbler.com][somascrob-api].

# Usage
```java
SomaScrobblerApi api = new SomaScrobblerApi(new SomaScrobblerApi.Settings.Builder()
        .setEndpoint("https://api.somascrobbler.com/")
        .build());

Version version = api.getVersion();
Stats stats = api.getStats();
Map<String, Station> stations = api.getStations();
NowPlaying nowPlaying = api.getNowPlaying("groovesalad");
```

# Download
```groovy
compile 'saschpe.android:somascrobblerapi:1.0.7'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].


# License

    Copyright 2017 Sascha Peilicke

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [somascrob]: https://github.com/maxkueng/somascrobbler-api
 [somascrob-api]: https://api.somascrobbler.com/
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
