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

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

final class SomaScrobblerApiClient {
    private final SomaScrobblerApiService api;

    /**
     * Creates a new API client instance.
     *
     * @param endpoint API endpoint Url
     */
    SomaScrobblerApiClient(final String endpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endpoint)
                .build();

        api = retrofit.create(SomaScrobblerApiService.class);
    }

    SomaScrobblerApiService getService() {
        return api;
    }
}
