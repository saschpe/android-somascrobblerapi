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

package saschpe.somascrobblerapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit API class for SomaScrobbler-API.
 *
 * @link https://api.somascrobbler.com/
 */
interface SomaScrobblerApiService {
    @GET("api/v1/version")
    Call<Version> getVersion();

    @GET("/api/v1/stations")
    Call<List<Station>> getStations();

    @GET("/api/v1/stats")
    Call<Stats> getStats();

    @GET("/api/v1/nowplaying/{station}")
    Call<NowPlaying> getNowPlaying(@Path("station") String station);
}
