package net.runelite.client.plugins.RuneTube.src.main.java.be.droei.RuneTube.Api;

import com.google.gson.Gson;
import net.runelite.client.plugins.RuneTube.src.main.java.be.droei.RuneTube.classes.VideoData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class RuneTubeApi {
    public List<VideoData> getRecentVids(){
        List<VideoData> result = null;
        try {
            URL url = new URL("https://e3a0-109-135-40-194.ngrok-free.app"+"/LatestVids");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                Gson gson = new Gson();
                VideoData[] videoDataArray = gson.fromJson(response.toString(), VideoData[].class);
                result = Arrays.asList(videoDataArray);

                for (VideoData videoData : result) {
                    System.out.println(videoData);
                }
            } else {
                System.out.println("Error: " + responseCode);
            }
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

