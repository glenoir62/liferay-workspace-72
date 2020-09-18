import { Ingredient } from './ingredient.model';

export class Cocktail {

    constructor(public id: number, public name: string, public image: string, public description: string, public ingredients?: Ingredient[]) {}
}
