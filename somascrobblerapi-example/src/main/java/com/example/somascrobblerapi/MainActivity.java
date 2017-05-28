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

package com.example.somascrobblerapi;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;
import java.net.SocketTimeoutException;

import saschpe.android.somascrobblerapi.SomaScrobblerApi;
import saschpe.android.somascrobblerapi.Stats;
import saschpe.android.somascrobblerapi.Version;

/**
 * Example activity that displays how to use {@link SomaScrobblerApi}
 * <p>
 * Uses an {@link AsyncTaskLoader} that retrieves server version information.
 */
public final class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<String> {
    private TextView logView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logView = (TextView) findViewById(R.id.log);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new VersionLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        logView.setText(data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        logView.setText(R.string.loader_reset);
    }

    private static final class VersionLoader extends AsyncTaskLoader<String> {
        private final SomaScrobblerApi api;

        VersionLoader(final Context context) {
            super(context);
            api = new SomaScrobblerApi(new SomaScrobblerApi.Settings.Builder()
                    .setEndpoint("http://somascrobblerapi.peilicke.de")
                    .build());
        }

        @Override
        public String loadInBackground() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Result:").append("\n");
            try {
                Version version = api.getVersion();
                if (version != null) {
                    stringBuilder
                            .append("SomaScrobblerApi version: ")
                            .append(version.version).append("\n");
                }
                Stats stats = api.getStats();
                if (stats != null) {
                    stringBuilder
                            .append("SomaScrobblerApi connections: ")
                            .append(stats.connections)
                            .append(", uptime (ms): ")
                            .append(stats.uptime_ms).append("\n");
                }
            } catch (SocketTimeoutException e) {
                stringBuilder.append(e.getMessage()).append("\n");
            } catch (IOException e) {
                stringBuilder.append(e.getMessage()).append("\n");
            }
            return stringBuilder.toString();
        }
    }
}
