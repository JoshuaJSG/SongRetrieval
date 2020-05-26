package com.JSG.SongRetrieval;

import com.JSG.SongRetrieval.Controllers.FetchDataController;

public class Main {
    public static void main(String[] args) throws Exception {
        new FetchDataController().searchArtistbyName("J Cole");
    }
}
