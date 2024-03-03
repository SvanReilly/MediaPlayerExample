package com.ssreilly.mediaplayerexample;


public class Songs {
    private String title;
    private String link;

    private String albumName, albumCoverLink;

    private String artist;


    public Songs(String title, String link,String albumName, String albumCoverLink, String artist) {
        this.title = title;
        this.link = link;
        this.albumName = albumName;
        this.albumCoverLink = albumCoverLink;
        this.artist = artist;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumCoverLink() {
        return albumCoverLink;
    }

    public void setAlbumCoverLink(String albumCoverLink) {
        this.albumCoverLink = albumCoverLink;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


}
