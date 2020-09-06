import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Cocktail } from '../models/cocktail.model';
import { Ingredient } from '../models/ingredient.model';
import { CocktailEditComponent } from 'src/app/cocktail-container/cocktail-edit/cocktail-edit.component';
import { HttpClient } from '@angular/common/http';
import { filter, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CocktailService {

  public cocktails: BehaviorSubject<Cocktail[]> = new BehaviorSubject(null);

  getCocktail(index: number): Observable<Cocktail> {
    return this.cocktails.pipe(
      filter(cocktails => cocktails != null ),
      map(cocktails => cocktails[index])
    );
  }

  addCocktail(cocktail: Cocktail): void {

    const cocktails = this.cocktails.value.slice();
    cocktails.push(new Cocktail(cocktail.name,
      cocktail.img,
      cocktail.desc,
      cocktail.ingredients.map(ingredient => new Ingredient(ingredient.name, ingredient.quantity))
      )
    );

    this.http.put<Cocktail[]>('https://cocktails-angular-36eae.firebaseio.com/cocktails.json', cocktails)
      // tslint:disable-next-line: no-shadowed-variable
      .subscribe(cocktails => {
        this.cocktails.next(cocktails);
      });
  }

  editCocktail(editCocktail: Cocktail) {
    const cocktails = this.cocktails.value;
    let index = cocktails.findIndex(c => c.name === editCocktail.name);
    cocktails[index] = editCocktail;
    this.http.put<Cocktail[]>('https://cocktails-angular-36eae.firebaseio.com/cocktails.json', this.cocktails.value)
      // tslint:disable-next-line: no-shadowed-variable
      .subscribe(cocktails => {
        this.cocktails.next(cocktails);
      });
  }

  // public cocktail: BehaviorSubject<Cocktail> = new BehaviorSubject(this.cocktails.value[0]);

  // selectCocktail(index: number): void {
  //   this.cocktail.next(this.cocktails.value[index]);
  // }

  constructor(private http: HttpClient) {
    this.http.get<Cocktail[]>('https://cocktails-angular-36eae.firebaseio.com/cocktails.json').subscribe(cocktails => {
      this.cocktails.next(cocktails);
    });
  }
}
