import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.util.ArrayList;

public class ListeAlbums {

    private Album[] collection;

    public ListeAlbums(JSONObject json){
        JSONArray collection = json.getJSONArray("collection");
        this.collection = new Album[collection.size()];
        for(int i=0;i<this.collection.length;i++){
            this.collection[i] = new Album(collection.getJSONObject(i));
        }
    }

    public ListeAlbums(Album[] collection) {
        this.collection = collection;
    }

    private int donnerNombreTypeAlbum(){
        int numbreAlbum = 0;
        for(int i=0;i< collection.length;i++){
            if(collection[i].getType().equalsIgnoreCase("album")){
                numbreAlbum++;
            }
        }
        return numbreAlbum;
    }

    private int donnerNombreTypeSingle(){
        return collection.length - donnerNombreTypeAlbum();
    }

    private Album[] donnerAlbumsDepuis2003(){
        ArrayList<Album> albums = new ArrayList<>();
        for(int i=0;i< collection.length;i++){
            if(collection[i].getPublication() >= 2003){
                albums.add(collection[i]);
            }
        }
        Album[] resultat = new Album[albums.size()];
        albums.toArray(resultat);
        return resultat;
    }

    private Album[] donnerAlbumsAvecNote5(){
        ArrayList<Album> albums = new ArrayList<>();
        for(int i=0;i< collection.length;i++){
            if(collection[i].getRating() == 5){
                albums.add(collection[i]);
            }
        }
        Album[] resultat = new Album[albums.size()];
        albums.toArray(resultat);
        return resultat;
    }

    @Override
    public String toString() {
        String resultat = "- le nombre d'albums : " + donnerNombreTypeAlbum() + "\n";
        resultat += "- le nombre de singles : " + donnerNombreTypeAlbum() + "\n";
        resultat += "- la liste des albums publiés depuis 2003 :\n";
        for (Album album : donnerAlbumsDepuis2003()){
            resultat += "     " + album.toString() + "\n";
        }
        resultat += "- la liste des albums avec une note de 5 :\n";
        for (Album album : donnerAlbumsAvecNote5()){
            resultat += "     " + album.toString() + "\n";
        }
        return resultat;
    }

    public JSONObject donnerJson() {
        JSONObject resultat = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i=0; i<collection.length; i++){
            array.add(collection[i].donnerJson());
        }
        resultat.accumulate("collection", array);
        return resultat;
    }
}
