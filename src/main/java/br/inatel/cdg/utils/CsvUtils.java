package br.inatel.cdg.utils;

import br.inatel.cdg.model.Games;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<Games> readGameCsv(Path csvFilePath){

        List<Games> gameList = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Games.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            gameList = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameList;
    }

}