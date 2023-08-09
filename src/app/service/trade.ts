import { Stock } from "./stock";

export class Trade{
    id: number;
    tradeType: string;
    stock: Stock;
    date: Date;
    amount: number;
    unitPrice: number;
    commission: number;
    tradeSum: number;
    comment: string;
}