package service;

import com.google.gson.Gson;
import Translation.Dictionary;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BotUtil {
    public static String language;
    public static String text;

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        BotUtil.language = language;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        BotUtil.text = text;
    }

    public static final String APIKEY="dict.1.1.20201119T202847Z.1c87e3d9ddae4611.0825c36a227f02bf70aa10e1cf7c2accc1b27511";
   public static Dictionary getDic() throws IOException {
       HttpGet httpGet = new HttpGet("https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20201119T202847Z.1c87e3d9ddae4611.0825c36a227f02bf70aa10e1cf7c2accc1b27511&lang="+language+"&text="+text);
       HttpClient client = HttpClients.createDefault();
       HttpResponse response = client.execute(httpGet);

       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
       Gson gson = new Gson();
       Dictionary dictionary = gson.fromJson(bufferedReader, Dictionary.class);

       System.out.println(dictionary);
       return dictionary;
   }
}
