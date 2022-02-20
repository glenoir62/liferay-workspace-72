package fr.gleo.meetup.cocktail.client.api;

import fr.gleo.meetup.cocktail.client.model.PageCocktail;

import java.io.IOException;

public interface CocktailService {

    PageCocktail getSiteCocktailsPage(
            Long siteId, String filter, Integer page, Integer pageSize, String search, String sort
    ) throws IOException;
}
