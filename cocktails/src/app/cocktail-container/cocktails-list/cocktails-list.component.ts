import { Component, OnInit} from '@angular/core';
import { Cocktail } from '../../shared/models/cocktail.model';
import { CocktailService } from 'src/app/shared/services/cocktail.service';
import { FilterPipe } from 'src/app/shared/pipes/filter.pipe';
import {StructuredContentService} from "../../api/liferay-delivery/services/structured-content.service";

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
  public banner$ ;

  constructor(private cocktailService: CocktailService, private structuredContentService : StructuredContentService) { }

  ngOnInit() {
    this.cocktailService.cocktails.subscribe((cocktails: Cocktail[]) => {
      this.cocktails = cocktails;
    });

    this.banner$ = this.structuredContentService.getStructuredContentRenderedContentTemplate({
      structuredContentId: '38113',
      templateId: '33906'
    });
  }

  // pickCocktail(index: number): void {
  //   this.activeCocktail = index;
  //   this.cocktailService.selectCocktail(index);
  // }

}
