package model;

public class OrderMusic {
    private long id;
    private long customerId;
    private long spotifyId;
    private long[] musics;

    public OrderMusic(long id, long customerId, long spotifyId, long[] musics) {
        this.id = id;
        this.customerId = customerId;
        this.spotifyId = spotifyId;
        this.musics = musics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(long spotifyId) {
        this.spotifyId = spotifyId;
    }

    public long[] getMusics() {
        return musics;
    }

    public void setMusics(long[] musics) {
        this.musics = musics;
    }
}
