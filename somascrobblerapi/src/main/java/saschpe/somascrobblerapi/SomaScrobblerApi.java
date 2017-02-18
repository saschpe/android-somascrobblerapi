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

import java.io.IOException;

import retrofit2.Response;

/**
 * SomaScrobblerApi for Android.
 *
 * @link https://api.somascrobbler.com/
 */
public final class SomaScrobblerApi {
    private final SomaScrobblerApiClient client;

    /**
     /**
     * Creates a new {@link SomaScrobblerApi} instance.
     *
     * @param settings {@link Settings} provided via {@link Settings.Builder}.
     */
    public SomaScrobblerApi(final Settings settings) {
        client = new SomaScrobblerApiClient(settings.getEndpoint());
    }

    /**
     * Retrieves version information.
     *
     * @return {@link Version} instance
     * @throws IOException in case of network errors
     */
    public Version getVersion() throws IOException {
        Response<Version> response = client.getService()
                .getVersion().execute();

        if (response.isSuccessful() && response.body() != null) {
            return response.body();
        }
        return null; // TODO: Better API!
    }

    /**
     * Retrieves statistical information.
     *
     * @return {@link Stats} instance
     * @throws IOException in case of network errors
     */
    public Stats getStats() throws IOException {
        Response<Stats> response = client.getService()
                .getStats().execute();
        if (response.isSuccessful() && response.body() != null) {
            return response.body();
        }
        return null; // TODO: Better API!
    }

    /**
     * Settings for the {@link SomaScrobblerApi}.
     *
     * Use {@link Settings.Builder} to create a new instance and configure it accordingly.
     */
    public static final class Settings {
        private String endpoint;

        // Builder-exclusive.
        private Settings() {
        }

        /**
         * Returns the API endpoint URL string.
         *
         * @return Endpoint URL string
         */
        public String getEndpoint() {
            return endpoint;
        }

        /**
         * Class to create and set up a {@link Settings}.
         */
        public final static class Builder {
            private Settings settings;

            public Builder() {
                settings = new Settings();
            }

            public Builder setEndpoint(final String endpoint) {
                settings.endpoint = endpoint;
                return this;
            }

            /**
             * Returns fully configured {@link Settings} instance.
             *
             * @return {@link Settings} instance
             * @throws SettingsBuildException in case of missing or invalid options.
             */
            public Settings build() {
                if (settings.endpoint == null) {
                    throw new SettingsBuildException("API endpoint URL missing!");
                }
                return settings;
            }
        }
    }
}
