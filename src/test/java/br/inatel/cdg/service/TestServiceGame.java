package br.inatel.cdg.service;

import br.inatel.cdg.model.Games;
import br.inatel.cdg.model.Platform;
import br.inatel.cdg.model.Publisher;
import br.inatel.cdg.utils.CsvUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestServiceGame {

    private static List<Games> gameList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        gameList = CsvUtils.readGameCsv(caminho);
    }

    @Test
    public void testeGamesWii(){
        List<Games> WiiGames = ServiceGame.getListByPlatform(gameList, Platform.Wii);

        Assert.assertEquals(15,WiiGames.size());
    }

    @Test
    public void testeGamePC(){
        List<Games> PCGames = ServiceGame.getListByPlatform(gameList, Platform.PC);

        Assert.assertEquals(1,PCGames.size());
    }

    @Test
    public void testeGameSquareSoft(){
        List<Games> SquareSoftGames = ServiceGame.getByPuBlisher(gameList, Publisher.SquareSoft);

        Assert.assertNotEquals(0, SquareSoftGames.size());
    }

    @Test
    public void testeGameElectronicArts(){
        List<Games> ElectronicArtsGames = ServiceGame.getByPuBlisher(gameList, Publisher.ElectronicArts);

        Assert.assertEquals(5,ElectronicArtsGames.size());
    }

}
