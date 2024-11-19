package org.ace58tech;

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

    public static Observable<Double> getStockPrice(String symbol) {
        return Observable.interval(1, TimeUnit.NANOSECONDS)
                .map(tick -> fetchLastestPrice(symbol))
                .filter(Objects::nonNull);

    }

    public static Double fetchLastestPrice(String symbol) {
        String url = String.format(BASE_URL, symbol, API_KEY);
        Request request = new Request.Builder().url(url).build();
        System.out.println(request);

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.isSuccessful());
            if (response.isSuccessful() && response.body() != null) {
                JSONObject jsonObject = new JSONObject(response.body().string());
                System.out.println(jsonObject.toString());
                JSONObject timeSeries = jsonObject.getJSONObject("Time Series (1min)");
                String lastPrice = timeSeries.keys().next();
                return timeSeries.getJSONObject(lastPrice).getDouble("4. close");
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}
