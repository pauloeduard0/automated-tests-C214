package br.inatel.cdg.service;

import br.inatel.cdg.model.Games;
import br.inatel.cdg.model.Platform;
import br.inatel.cdg.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class ServiceGame {

    public static List<Games> getListByPlatform(List<Games> games, Platform platform){
        List<Games> gamesByPlatform = new ArrayList<>();

        games.stream().filter((game ->
                        game.getPlatform().equals(platform.name()))).
                forEach(game -> gamesByPlatform.add(game));

        return gamesByPlatform;

    }


    public static List<Games> getByPuBlisher(List<Games> games ,
                                            Publisher publisher){
        List<Games> gamesByPublisher = new ArrayList<>();

        games.stream().filter((game ->
                        game.getPublisher().replaceAll("\\s+", "").equals(publisher.name()))).
                forEach(game -> gamesByPublisher.add(game));

        return gamesByPublisher;
    }

}
