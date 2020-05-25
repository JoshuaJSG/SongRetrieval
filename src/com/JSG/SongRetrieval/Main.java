package com.JSG.SongRetrieval;

import com.JSG.SongRetrieval.Controllers.FetchDataController;

public class Main {
    public static void main(String[] args) throws Exception {

        FetchDataController fdc = new FetchDataController();
        String url = fdc.searchArtistbyName(909253);
        System.out.println(url);
    }
}
