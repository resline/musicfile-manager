package info.mp3lib.util.cddb;


import info.mp3lib.core.Album;

public interface IDBQuery {

    public DBResult[] queryAlbum(Album album);
    
}
