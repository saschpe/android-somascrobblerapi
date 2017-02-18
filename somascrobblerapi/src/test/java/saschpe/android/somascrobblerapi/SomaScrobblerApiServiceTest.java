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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class SomaScrobblerApiServiceTest {
    private static final String GROOVE_SALAD = "groovesalad";

    private SomaScrobblerApiService service;

    @Before
    public void setupClientAndApi() {
        SomaScrobblerApiClient client = new SomaScrobblerApiClient(BuildConfig.TEST_ENDPOINT);
        service = client.getService();
    }

    @Test
    public void getVersion() throws IOException {
        Call<Version> call = service.getVersion();
        assertNotNull(call);

        Response<Version> response = call.execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
    }

    @Test
    public void getStats() throws IOException {
        Call<Stats> call = service.getStats();
        assertNotNull(call);

        Response<Stats> response = call.execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
    }

    @Test
    public void getStations() throws IOException {
        Call<Map<String, Station>> call = service.getStations();
        assertNotNull(call);

        Response<Map<String, Station>> response = call.execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
    }

    @Test
    public void getNowPlaying() throws IOException {
        Call<NowPlaying> call = service.getNowPlaying(GROOVE_SALAD);
        assertNotNull(call);

        Response<NowPlaying> response = call.execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
    }
}
