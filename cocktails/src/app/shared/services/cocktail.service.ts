import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {filter, map} from 'rxjs/operators';

import {CocktailService as CocktailServiceOpenApi} from '../../api/cocktails/services/cocktail.service';
import {Cocktail} from '../models/cocktail.model';


@Injectable({
    providedIn: 'root'
})
export class CocktailService {

    public cocktails: BehaviorSubject<Cocktail[]> = new BehaviorSubject([]);

    private siteId: number = 20124;

    getCocktail(cocktailId: number): Observable<Cocktail> {
        return this.cocktailServiceOpenApi.getCocktail$Json({cocktailId: cocktailId}).pipe(
            map(cocktail => cocktail as Cocktail)
        );
    }

    getFirstCocktail(): Observable<Cocktail> {
        return this.cocktails.pipe(
            filter(cocktails => cocktails != null && cocktails.length > 0),
            map(cocktails => cocktails[0])
        );
    }

    addCocktail(cocktail: Cocktail): void {
        const cocktails = this.cocktails.value.slice();

        this.cocktailServiceOpenApi.postSiteCocktail$Json$Json({
            siteId: this.siteId,
            body: cocktail
        })
        // tslint:disable-next-line: no-shadowed-variable
        .subscribe(value => {
            cocktails.push(new Cocktail(value.id, value.name,
                value.image,
                value.description
                //cocktail.ingredients.map(ingredient => new Ingredient(ingredient.name, ingredient.quantity))
                )
            );
            this.cocktails.next(cocktails);
        });
    }

    editCocktail(editCocktail: Cocktail) {
        const cocktails = this.cocktails.value;
        let index = cocktails.findIndex(c => c.id === editCocktail.id);
        cocktails[index] = editCocktail;

        this.cocktailServiceOpenApi.putCocktail$Json$Json(
            {
                cocktailId: editCocktail.id,
                body: editCocktail
            }
        ).subscribe(_value => {
            this.cocktails.next(cocktails);
        });
    }

    constructor(private http: HttpClient, private cocktailServiceOpenApi: CocktailServiceOpenApi) {
        this.cocktailServiceOpenApi.getSiteCocktailsPage$Json({siteId: this.siteId}).subscribe(pageCocktail => {
            if (pageCocktail.items) {
                this.cocktails.next(pageCocktail.items as Cocktail[]);
            }
        });
    }

    deleteCocktail(id: number) {
        this.cocktailServiceOpenApi.deleteCocktail$Json({cocktailId: id})
            .subscribe(value => {
                const cocktails: Cocktail[] = this.cocktails.value.slice();
                this.cocktails.next(cocktails.filter(cocktail => cocktail.id !== id));
            });
    }
}
