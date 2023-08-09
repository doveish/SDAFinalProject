import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContentComponent } from './content/content.component';
import { ViewAccountsComponent } from './view-accounts/view-accounts.component';
import { ViewStocksComponent } from './view-stocks/view-stocks.component';
import { ViewTradesComponent } from './view-trades/view-trades.component';
import { ViewDividendsComponent } from './view-dividends/view-dividends.component';
import { AddAccountComponent } from './add-account/add-account.component';
import { AddStockComponent } from './add-stock/add-stock.component';
import { AddTradeComponent } from './add-trade/add-trade.component';
import { AddDividendComponent } from './add-dividend/add-dividend.component';
import { ViewTransactionComponent } from './view-transaction/view-transaction.component';
import { AddTransactionComponent } from './add-transaction/add-transaction.component';
import { LoginComponent } from './login/login.component';
import { ViewCurrencyComponent } from './view-currency/view-currency.component';
import { AddCurrencyComponent } from './add-currency/add-currency.component';
import { SecurityComponent } from './security/security.component';

const routes: Routes = [
  {path: '', component: SecurityComponent},
  {path: 'home', component: ContentComponent},
  { path: 'account', component: ViewAccountsComponent },
  { path: 'stock', component: ViewStocksComponent },
  { path: 'trade', component: ViewTradesComponent },
  { path: 'dividend', component: ViewDividendsComponent },
  { path: 'add-account', component: AddAccountComponent },
  { path: 'add-stock', component: AddStockComponent },
  { path: 'add-trade', component: AddTradeComponent },
  { path: 'add-dividend', component: AddDividendComponent },
  { path: 'account/:id/createStock', component: AddStockComponent },
  { path: "stock/:id/createTrade", component: AddTradeComponent },
  { path: "stock/:id/createDividend", component: AddDividendComponent },
  { path: "transaction", component: ViewTransactionComponent },
  { path: "account/:id/createTransaction", component: AddTransactionComponent },
  { path: "account/:id/stock-list", component: ViewStocksComponent },
  { path: "stock/:id/trade-list", component: ViewTradesComponent },
  { path: "stock/:id/dividend-list", component: ViewDividendsComponent },
  {path: "account/:id/transaction-list", component: ViewTransactionComponent},
  {path: "currency", component: ViewCurrencyComponent},
  {path: "currency/add-currency", component: AddCurrencyComponent},
  {path: "currency/:id/update", component: AddCurrencyComponent},




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
