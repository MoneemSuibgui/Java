import java.util.HashMap;
import java.util.Set;

class TestTrackList{
    public static void main(String[] args){

        // Create a trackList of type HashMap
        HashMap<String,String> trackList =new HashMap<String,String>();
        


        // Add in at least 4 songs that are stored by title
        trackList.put("Believer","First things first I'ma say all the words inside my head...");
        trackList.put("Diamonds","Shine bright like a diamond Shine bright like a diamond...");
        trackList.put("Say Don't Go","I've known it from the very start We're a shot in the darkest dark Oh no, oh no I'm unarmed...");
        trackList.put("Lollipop","Ow! Ha ha ha ha Uh-huh No homo (Young Mula, baby)");

        // Pull out one of the songs by its track title
        String favoriteSong=trackList.get("Believer");
        System.out.println("------------My favourite song --------------");
        System.out.println(favoriteSong+"\n\n");


        // Print out all the track names and lyrics in the format Track: Lyrics
        Set<String> keys = trackList.keySet();
        System.out.println("------------My all Songs with Lyrics--------------");
        for(String key :keys){
            System.out.println( key +":  "+ trackList.get(key));
        }
    }
}