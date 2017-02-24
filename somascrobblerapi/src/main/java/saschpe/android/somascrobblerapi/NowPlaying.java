/*
 * Copyright 2017 Sascha Peilicke
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

package saschpe.android.somascrobblerapi;

public class NowPlaying {
    public final String stationId;
    public final long time;
    public final String artist;
    public final String title;
    public final String album;
    //public final boolean trackCorrected;
    //public final boolean artistCorrected;
    //public final boolean albumCorrected;
    //public final boolean corrected;
    public final long duration;
    //public final boolean durationEstimated;

    public NowPlaying(String stationId, long time, String artist, String title, String album, long duration) {
        this.stationId = stationId;
        this.time = time;
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "NowPlaying{" +
                "stationId='" + stationId + '\'' +
                ", time=" + time +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", duration=" + duration +
                '}';
    }
}
