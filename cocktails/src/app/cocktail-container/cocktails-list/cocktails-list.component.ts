import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Cocktail } from '../../shared/models/cocktail.model';
import { CocktailService } from 'src/app/shared/services/cocktail.service';
import { FilterPipe } from 'src/app/shared/pipes/filter.pipe';

@Component({
  selector: 'app-cocktails-list',
  templateUrl: './cocktails-list.component.html',
  styleUrls: ['./cocktails-list.component.scss'],
  providers: [FilterPipe]
})
export class CocktailsListComponent implements OnInit {

  public search = '';
  public cocktails: Cocktail[];
  public activeCocktail = 1;

  constructor(private cocktailService: CocktailService) { }

  ngOnInit() {
    this.cocktailService.cocktails.subscribe((cocktails: Cocktail[]) => {
      this.cocktails = cocktails;
    });
  }

  // pickCocktail(index: number): void {
  //   this.activeCocktail = index;
  //   this.cocktailService.selectCocktail(index);
  // }

}
