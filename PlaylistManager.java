import java.util.Arrays;
import java.util.Scanner;

public class PlaylistManager {

    //view playlist
    //add song to playlist
    //remove song to playlist

    private String[] playlist;
    private String song;

    public PlaylistManager(){
        playlist = new String[0];
    }

    private String get_Command(){
        Scanner comm = new Scanner(System.in);
        String comm_ = comm.nextLine();
        System.out.print("> ");
        return comm_;
    }
    
    private void viewPlaylist(){
        System.out.println("Playlist: " + Arrays.toString(playlist));
    }//tested

    private void addSong(String song){
        if(song.equals("")){
            System.out.println("Error: Cannot add empty song.");
            return;
        }

        String[] tmp = new String[playlist.length + 1];
        System.arraycopy(playlist, 0, tmp, 0, playlist.length);
        tmp[playlist.length] = song;
        playlist = tmp;
    } //tested


    private boolean inArray(String[] names, String name){
        for(int i = 0; i < names.length ; i++){
            if(names[i].equals(name)){
                return true;
            }
        }
        return false;
    }//tested

    private void removeSong(String song){
        String[] tmp = new String[playlist.length -1];
        if(song.equals("")){
            System.out.println("Error: Cannot remove empty song.");
            return;
        }
        if(!inArray(playlist, song)){
            System.out.println("Error: Song "+ "'"+ song+ "'" +" not found in playlist.");
            return;
        }
        for(int i = 0; i < playlist.length; i++){
            int j = 0 ;
            if(!playlist[i].equals(song)){
                tmp[j] = playlist[i];
            }
            j++;
        }
        playlist = tmp;
        }



    public static void main(String[] args) {
        PlaylistManager pm = new PlaylistManager();
        pm.viewPlaylist();
        pm.addSong("zoo wee mama");
        pm.viewPlaylist();
    }
    }