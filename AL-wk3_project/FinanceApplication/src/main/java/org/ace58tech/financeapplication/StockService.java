package org.ace58tech.financeapplication;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

public class StockService {
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=%s&interval=1min&apikey=%s";

    private static final OkHttpClient client = new OkHttpClient();

    public Observable<Double> getStockPriceStream(String symbol) {
        return Observable.interval(1, TimeUnit.MINUTES)
                .map(tick -> fetchLatestPrice(symbol))
                .filter(Objects::nonNull);  // Filter out nulls in case of errors
    }

    private Double fetchLatestPrice(String symbol) {
        String url = String.format(BASE_URL, symbol, API_KEY);
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                JSONObject json = new JSONObject(response.body().string());
                JSONObject timeSeries = json.getJSONObject("Time Series (1min)");
                String latestTime = timeSeries.keys().next();
                return timeSeries.getJSONObject(latestTime).getDouble("4. close");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
