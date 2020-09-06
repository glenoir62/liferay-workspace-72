import { Component, OnInit, Input } from '@angular/core';
import { Cocktail } from '../../shared/models/cocktail.model';
import { CocktailService } from 'src/app/shared/services/cocktail.service';
import { Ingredient } from 'src/app/shared/models/ingredient.model';
import { PanierService } from 'src/app/shared/services/panier.service';
import { ActivatedRoute, Params, ParamMap } from '@angular/router';


@Component({
  selector: 'app-cocktails-details',
  templateUrl: './cocktails-details.component.html',
  styleUrls: ['./cocktails-details.component.scss']
})
export class CocktailsDetailsComponent implements OnInit {

  public cocktail: Cocktail;
  public index: number;

  constructor(private activatedRoute: ActivatedRoute, private cocktailService: CocktailService, private panierService: PanierService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params: Params) => {
      if (params.get('index')) {
        this.index = params.get('index');
      } else {
        this.index = 0;
      }
      this.cocktailService.getCocktail(this.index).subscribe(cocktails => this.cocktail = cocktails);
    });
  }


  addPanier(ingredients: Ingredient[]): void {
    this.panierService.addIngredients(ingredients);
  }

  getUrl(): string[]{
    return ['/cocktails', this.index + '', 'edit'];
  }
}
