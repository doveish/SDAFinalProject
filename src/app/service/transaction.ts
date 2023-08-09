import { Account } from "./account";

export class Transaction{
    amount: number;
    transactionType: string;
    account: Account;
    transactionDate: Date;
}