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

public class Station {
    public final String id;
    public final String title;
    public final String description;
    public final String dj;
    public final String genre;
    public final Image image;

    public Station(String id, String title, String description, String dj, String genre, Image image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dj = dj;
        this.genre = genre;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dj='" + dj + '\'' +
                ", genre='" + genre + '\'' +
                ", image=" + image +
                '}';
    }

    public static class Image {
        public final String small;
        public final String medium;
        public final String large;

        public Image(String small, String medium, String large) {
            this.small = small;
            this.medium = medium;
            this.large = large;
        }

        @Override
        public String toString() {
            return "Image{" +
                    "small='" + small + '\'' +
                    ", medium='" + medium + '\'' +
                    ", large='" + large + '\'' +
                    '}';
        }
    }
}
