package be.droei.RuneTube.classes;

public class YouTubeVid {
    public String id;
    public String title;
    public String creator;

    void YoutubeVid(String title, String creator, String id){
        this.title = title;
        this.id = id;
        this.creator = creator;
    }

    String GetVideoUrl(){
        return "https://www.youtube.com/watch?v="+id;
    }

    public String GetVideoImg(){
        return "https://i.ytimg.com/vi/"+id+"/default.jpg";
    }
}

