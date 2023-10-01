import net.sf.json.JSONObject;

public class Album {

    private String type;
    private String artist;
    private String title;
    private int publication;
    private int rating;

    public Album(JSONObject json) {
        type = json.getString("type");
        artist = json.getString("artist");
        title = json.getString("title");
        publication = json.getInt("publication");
        rating = json.getInt("rating");
    }

    public Album(String type, String artist, String title, int publication, int rating) {
        this.type = type;
        this.artist = artist;
        this.title = title;
        this.publication = publication;
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public int getPublication() {
        return publication;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return title + " de " + artist;
    }

    public JSONObject donnerJson() {
        JSONObject json = new JSONObject();
        json.accumulate("type", type);
        json.accumulate("artist", artist);
        json.accumulate("title", title);
        json.accumulate("publication", publication);
        json.accumulate("rating", rating);
        return json;
    }
}
