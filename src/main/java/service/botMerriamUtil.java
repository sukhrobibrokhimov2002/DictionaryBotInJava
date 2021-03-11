package service;

import Definition.MerriamDefinition;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class botMerriamUtil {
    public static String word;
    public static String language;
    public static List<MerriamDefinition> definitionList;

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        botMerriamUtil.language = language;
    }

    public static String getWord() {
        return word;
    }

    public static void setWord(String word) {
        botMerriamUtil.word = word;
    }
    public static List<MerriamDefinition> getMerriam() throws IOException {
        URL url=new URL("https://api.dictionaryapi.dev/api/v2/entries/"+language+"/"+word);
        URLConnection urlConnection=url.openConnection();
        BufferedReader reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        Gson gson=new Gson();
        MerriamDefinition []merriamDefinitions=gson.fromJson(reader,MerriamDefinition[].class);
            definitionList=Arrays.asList(merriamDefinitions);
            return definitionList;
    }
}
