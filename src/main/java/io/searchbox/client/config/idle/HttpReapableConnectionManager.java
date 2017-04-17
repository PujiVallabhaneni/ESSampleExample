package io.searchbox.client.config.idle;

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.nio.conn.NHttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

public class HttpReapableConnectionManager implements ReapableConnectionManager {
    private final HttpClientConnectionManager httpConnectionManager;
    private final NHttpClientConnectionManager nhttpConnectionManager;

    public HttpReapableConnectionManager(HttpClientConnectionManager connectionManager, NHttpClientConnectionManager nConnectionManager) {
        if(connectionManager == null || nConnectionManager == null) throw new IllegalArgumentException();

        this.httpConnectionManager = connectionManager;
        this.nhttpConnectionManager = nConnectionManager;
    }

    @Override
    public void closeIdleConnections(long idleTimeout, TimeUnit unit) {
    	httpConnectionManager.closeIdleConnections(idleTimeout, unit);
    	 nhttpConnectionManager.closeIdleConnections(idleTimeout, unit);
    }
}
