package com.JSG.SongRetrieval;

import com.JSG.SongRetrieval.Controllers.FetchDataController;

public class Main {
    public static void main(String[] args) throws Exception {

        FetchDataController fdc = new FetchDataController();
        fdc.fetchUrl("https://itunes.apple.com/lookup?id=909253&entity=album");
    }
}
