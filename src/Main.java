import net.sf.json.JSONObject;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        load();
        save();
    }

    private static void load(){
        try {
            String jsonText = DataLoader.LoadTextFileWithPath("collection.json");
            JSONObject json = JSONObject.fromObject(jsonText);
            ListeAlbums albums = new ListeAlbums(json);
            System.out.println(albums);
        }catch (IOException e){

        }
    }

    private static void save(){
        try {
            Album[] albums = new Album[2];
            albums[0] = new Album("album", "Bob", "Chatons avec Bob", 2023, 1);
            albums[1] = new Album("single", "George", "Comptine Épique", 2020, 2);
            ListeAlbums liste = new ListeAlbums(albums);
            JSONObject json = liste.donnerJson();
            DataSaver.SaveTextOnFileWithPath(json.toString(5), "MesAlbum.json");
        }catch (IOException e){

        }
    }
}