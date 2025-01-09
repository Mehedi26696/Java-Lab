
//Name: H.M.Mehedi Hasan
//Roll: FH-13

import java.util.Scanner;

public class CDPLAYER {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Audio a = new Audio();
        Video v = new Video();

        System.out.println("Enter the type of music you want to play or to get information about the song: \n");
        System.out.println("1. Audio\n2. Video\n");

        int type = sc.nextInt();
        String str;

        if (type == 1) {
            str = "Audio";

            System.out.println("The audio songs available are: \n");
            for (int i = 0; i < a.songs.length; i++) {
                System.out.println((i + 1) + ". " + a.songs[i].getTitle());
            }
            System.out.println();
        } else if (type == 2) {
            str = "Video";
            System.out.println("The video songs available are: \n");
            for (int i = 0; i < v.songs.length; i++) {
                System.out.println((i + 1) + ". " + v.songs[i].getTitle());
            }
            System.out.println();
        }

        else {
            System.out.println("Invalid choice\n");
            sc.close();
            return;
        }

        System.out.println("Enter Choices: \n");

        System.out.println("1. Play songs\n2. Get information about songs \n");

        int choice = sc.nextInt();
        
        if (choice == 1) {
            System.out.println("Enter the number of the song you want to play: \n");
            int n = sc.nextInt();

            if (str.equals("Audio")) {
                if (n == 1) {
                    if (a.songs[0].getTitle().contains(".mp3")) {
                        a.mp3player(str, a.songs[0]);
                    } else if (a.songs[0].getTitle().contains(".wav")) {
                        a.wavplayer(str, a.songs[0]);
                    } else if (a.songs[0].getTitle().contains(".AAC")) {
                        a.AACplayer(str, a.songs[0]);
                    }
                } else if (n == 2) {
                    if (a.songs[1].getTitle().contains(".mp3")) {
                        a.mp3player(str, a.songs[1]);
                    } else if (a.songs[1].getTitle().contains(".wav")) {
                        a.wavplayer(str, a.songs[1]);
                    } else if (a.songs[1].getTitle().contains(".AAC")) {
                        a.AACplayer(str, a.songs[1]);
                    }
                } else if (n == 3) {
                    if (a.songs[2].getTitle().contains(".mp3")) {
                        a.mp3player(str, a.songs[2]);
                    } else if (a.songs[2].getTitle().contains(".wav")) {
                        a.wavplayer(str, a.songs[2]);
                    } else if (a.songs[2].getTitle().contains(".AAC")) {
                        a.AACplayer(str, a.songs[2]);
                    }
                }

                else {
                    System.out.println("Invalid choice\n");
                }
            } else if (str.equals("Video")) {
                if (n == 1) {
                    if (v.songs[0].getTitle().contains(".mp4")) {
                        v.mp4player(str, v.songs[0]);
                    } else if (v.songs[0].getTitle().contains(".avi")) {
                        v.aviplayer(str, v.songs[0]);
                    } else if (v.songs[0].getTitle().contains(".mkv")) {
                        v.mkvplayer(str, v.songs[0]);
                    }
                } else if (n == 2) {
                    if (v.songs[1].getTitle().contains(".mp4")) {
                        v.mp4player(str, v.songs[1]);
                    } else if (v.songs[1].getTitle().contains(".avi")) {
                        v.aviplayer(str, v.songs[1]);
                    } else if (v.songs[1].getTitle().contains(".mkv")) {
                        v.mkvplayer(str, v.songs[1]);
                    }
                } else if (n == 3) {
                    if (v.songs[2].getTitle().contains(".mp4")) {
                        v.mp4player(str, v.songs[2]);
                    } else if (v.songs[2].getTitle().contains(".avi")) {
                        v.aviplayer(str, v.songs[2]);
                    } else if (v.songs[2].getTitle().contains(".mkv")) {
                        v.mkvplayer(str, v.songs[2]);
                    }
                }

                else {
                    System.out.println("Invalid choice\n");
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter the number of the song you want to get information about: \n");
            int n = sc.nextInt();

            if (str.equals("Audio")) {
                if (n == 1) {
                    a.displayInformation(a.songs[0]);
                } else if (n == 2) {
                    a.displayInformation(a.songs[1]);
                } else if (n == 3) {
                    a.displayInformation(a.songs[2]);
                }
            } else if (str.equals("Video")) {
                if (n == 1) {
                    v.displayInformation(v.songs[0]);
                } else if (n == 2) {
                    v.displayInformation(v.songs[1]);
                } else if (n == 3) {
                    v.displayInformation(v.songs[2]);
                }
            }

            else {
                System.out.println("Invalid choice\n");
            }
        }

        else {
            System.out.println("Invalid choice\n");
        }
        sc.close();
    }
}

class Song {
    private String title;
    private String artist;
    private String releaseDate;
    private boolean isPlaying;

    public Song(String title, String artist, String releaseDate) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.isPlaying = false;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
}

class Audio extends Player {

    Song[] songs = {

            new Song("Billie Jean.wav", "Michael Jackson", "1983-05-05"),
            new Song("Wavin' Flag.mp3", "K'naan", "2009-03-18"),
            new Song("Hotel California.AAC", "Eagles", "1977-06-06")
    };

}

class Video extends Player {
    Song[] songs = {
            new Song("Shape of You.mp4", "Ed Sheeran", "2017-04-04"),
            new Song("Blinding Lights.avi", "The Weeknd", "2019-05-05"),
            new Song("Bela Bose.mkv", "Anjan Dutt", "1995-06-06")
    };
}

class Player extends Screen {

    void mp3player(String file, Song song) {
        play(file, "mp3player", song);
        displayInfoPrompt(song);
    }

    void wavplayer(String file, Song song) {
        play(file, "wavplayer", song);
        displayInfoPrompt(song);
    }

    void AACplayer(String file, Song song) {
        play(file, "AACplayer", song);
        displayInfoPrompt(song);
    }

    void mp4player(String file, Song song) {
        play(file, "mp4player", song);
        displayInfoPrompt(song);
    }

    void aviplayer(String file, Song song) {
        play(file, "aviplayer", song);
        displayInfoPrompt(song);
    }

    void mkvplayer(String file, Song song) {
        play(file, "mkvplayer", song);
        displayInfoPrompt(song);
    }
}

class Screen {
    void play(String file, String type, Song song) {
        System.out.println("Playing " + file + " song " + song.getTitle() + " using " + type);
        song.setPlaying(true);
    }

    void displayInfoPrompt(Song song) {
        System.out.println("Are you want to know more about the song? \n");
        System.out.println("1. Yes\n2. No\n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            displayInformation(song);
        }
        else {
            System.out.println("Invalid choice\n");
        }

        sc.close();
    }

    void displayInformation(Song song) {
        System.out.println("Title: " + song.getTitle());
        System.out.println("Artist: " + song.getArtist());
        System.out.println("Release Date: " + song.getReleaseDate());

        if (song.isPlaying()) {
            System.out.println("The song is currently playing\n");
        } else {
            System.out.println("The song is not currently playing\n");
        }
    }
}
