package com.bo.mower.lawnmover.services;

import java.io.IOException;

public interface DataService {
    String getDataFromFile(String filename) throws IOException;

    String getDataFromDB() throws IOException;
}
