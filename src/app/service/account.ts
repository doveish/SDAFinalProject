import { Stock } from "./stock";

export class Account{
   
    id: number;
    accountName: string;
    balance: number;
    currency: string;
    stocks: Stock[];
    
}