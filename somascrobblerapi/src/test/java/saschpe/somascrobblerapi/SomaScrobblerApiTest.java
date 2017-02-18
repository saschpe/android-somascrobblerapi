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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class SomaScrobblerApiTest {
    private static final String GROOVE_SALAD_ID = "groovesalad";
    private static final String GROOVE_SALAD_TITLE = "Groove Salad";

    private SomaScrobblerApi api;

    @Before
    public void setupApi() {
        api = new SomaScrobblerApi(new SomaScrobblerApi.Settings.Builder()
                .setEndpoint(BuildConfig.TEST_ENDPOINT)
                .build());
    }

    @Test
    public void buildSettings() {
        SomaScrobblerApi.Settings settings = new SomaScrobblerApi.Settings.Builder()
                .setEndpoint(BuildConfig.TEST_ENDPOINT)
                .build();

        assertNotNull(settings.getEndpoint());
        assertEquals(BuildConfig.TEST_ENDPOINT, settings.getEndpoint());
    }

    @Test
    public void getVersion() throws IOException {
        Version version = api.getVersion();

        assertNotNull(version);
    }

    @Test
    public void getStats() throws IOException {
        Stats stats = api.getStats();

        assertNotNull(stats);
        assertTrue(stats.connections > 0);
        assertTrue(stats.uptime_ms > 0);
        assertFalse(stats.lastTrackUpdates.isEmpty());
    }

    @Test
    public void getStations() throws IOException {
        Map<String, Station> stations = api.getStations();

        assertNotNull(stations);
        assertFalse(stations.isEmpty());
    }

    @Test
    public void getNowPlaying() throws IOException {
        NowPlaying nowPlaying = api.getNowPlaying(GROOVE_SALAD_ID);

        assertNotNull(nowPlaying);
        assertEquals(GROOVE_SALAD_ID, nowPlaying.stationId);
    }
}
