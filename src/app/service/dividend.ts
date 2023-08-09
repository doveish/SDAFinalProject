import { Stock } from "./stock";

export class Dividend{
    id: number;
    date: Date;
    stock: Stock;
    grossAmount: number;
    withholdingTax: number;
    netAmount: number;
}