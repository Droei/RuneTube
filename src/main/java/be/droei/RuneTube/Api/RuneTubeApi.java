package be.droei.RuneTube.Api;

import be.droei.RuneTube.classes.VideoData;
import be.droei.RuneTube.enums.PathEnum;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RuneTubeApi {

    public List<VideoData> requestLatestVids() throws FileNotFoundException {
        List<VideoData> result = null;
        String apiUrl = System.getenv("API_URL");

        try {
            URL url = new URL(apiUrl+"/LatestVids");
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

                String filePath = PathEnum.VIDSJSON.getPath();
                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(response.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
//
//                Gson gson = new Gson();
//                VideoData[] videoDataArray = gson.fromJson(response.toString(), VideoData[].class);
//                result = Arrays.asList(videoDataArray);
//
//
//                for (VideoData videoData : result) {
//                    System.out.println(videoData);
//                }
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

