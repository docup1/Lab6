package Data;

public enum MusicGenre {
    MATH_ROCK("MATH_ROCK"),
    PUNK_ROCK("PUNK_ROCK"),
    BRIT_POP("BRIT_POP");
    private String text;
    MusicGenre(String text) {
        this.text = text;
    }
    public String Geter(){
        return text;
    }
}
