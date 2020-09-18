import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Cocktail } from '../models/cocktail.model';
import { Ingredient } from '../models/ingredient.model';
import { CocktailEditComponent } from 'src/app/cocktail-container/cocktail-edit/cocktail-edit.component';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { filter, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CocktailService {

  public cocktails: BehaviorSubject<Cocktail[]> = new BehaviorSubject([]);

  private apiPath: string = "http://localhost:8080/o/cocktails/v1.0";
  private siteId: number = 20124;

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: 'Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0'
    })
  };

  getCocktail(cocktailId: number): Observable<Cocktail> {
    return this.http.get<Cocktail>(`${this.apiPath}/cocktails/${cocktailId}`, this.httpOptions);
  }

  getFirstCocktail(): Observable<Cocktail> {
    return this.cocktails.pipe(
        filter(cocktails => cocktails != null && cocktails.length > 0),
        map(cocktails => cocktails[0])
    );
  }

  addCocktail(cocktail: Cocktail): void {
    const cocktails = this.cocktails.value.slice();

    this.http.post<Cocktail>(`${this.apiPath}/sites/${this.siteId}/cocktails`, cocktail, this.httpOptions)
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

    this.http.put<Cocktail>(`${this.apiPath}/cocktails/${editCocktail.id}`, editCocktail, this.httpOptions)
        // tslint:disable-next-line: no-shadowed-variable
      .subscribe(value => {
        this.cocktails.next(cocktails);
      });
  }

  // public cocktail: BehaviorSubject<Cocktail> = new BehaviorSubject(this.cocktails.value[0]);

  // selectCocktail(index: number): void {
  //   this.cocktail.next(this.cocktails.value[index]);
  // }

  constructor(private http: HttpClient) {
    this.http.get<{ items: Cocktail[]}>(`${this.apiPath}/sites/${this.siteId}/cocktails`, this.httpOptions).subscribe(response => {
      if(response.items) {
        this.cocktails.next(response.items);
      }

    });
  }

  deleteCocktail(id: number) {
    this.http.delete<Cocktail>(`${this.apiPath}/cocktails/${id}`, this.httpOptions)
        // tslint:disable-next-line: no-shadowed-variable
        .subscribe(value => {
          const cocktails : Cocktail[] = this.cocktails.value.slice();
          this.cocktails.next(cocktails.filter(cocktail => cocktail.id !== id));
        });
  }
}
