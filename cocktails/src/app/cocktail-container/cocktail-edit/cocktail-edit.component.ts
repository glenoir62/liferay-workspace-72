import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { CocktailService } from 'src/app/shared/services/cocktail.service';
import { ActivatedRoute, Params } from '@angular/router';
import { Cocktail } from 'src/app/shared/models/cocktail.model';

@Component({
  selector: 'app-cocktail-edit',
  templateUrl: './cocktail-edit.component.html',
  styleUrls: ['./cocktail-edit.component.scss']
})
export class CocktailEditComponent implements OnInit {

  public cocktailFormGroup: FormGroup;
  public cocktail: Cocktail;
  private edit: boolean;

  constructor(private activatedRoute: ActivatedRoute, private fb: FormBuilder, private cocktailService: CocktailService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params: Params) => {
      if (params.get('index')) {
        this.edit = true;
        this.cocktailService
          .getCocktail(params.get('index'))
          .subscribe((cocktail: Cocktail) => {
            this.cocktail = cocktail;
            this.initForm(this.cocktail);
          });
      } else {
        this.edit = false;
        this.initForm();
      }
    });
  }

  initForm(cocktail: Cocktail = {name : '', img : '', desc: '', ingredients: []}) {

    this.cocktailFormGroup =  this.fb.group({
      name: [cocktail.name, Validators.required],
      img: [cocktail.img, Validators.required],
      desc: [cocktail.desc],
      ingredients: this.fb.array(cocktail.ingredients.map(ingredient => this.fb.group({
        name: [ingredient.name],
        quantity: [ingredient.quantity]
      })))
    });
  }

  addIngredient() {
    (<FormArray>this.cocktailFormGroup.get('ingredients')).push(this.fb.group({
      name: [''],
      quantity: ['']
    }));
  }

  createCocktail() {
    if (this.edit) {
      this.cocktailService.editCocktail(this.cocktailFormGroup.value);

    } else {
      this.cocktailService.addCocktail(this.cocktailFormGroup.value);
    }
  }
}
