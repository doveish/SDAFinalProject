import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ContentComponent } from './content/content.component';
import { FooterComponent } from './footer/footer.component';
import { ViewAccountsComponent } from './view-accounts/view-accounts.component';
import { ViewStocksComponent } from './view-stocks/view-stocks.component';
import { ViewTradesComponent } from './view-trades/view-trades.component';
import { ViewDividendsComponent } from './view-dividends/view-dividends.component';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AddAccountComponent } from './add-account/add-account.component';
import { AddStockComponent } from './add-stock/add-stock.component';
import { AddTradeComponent } from './add-trade/add-trade.component';
import { AddDividendComponent } from './add-dividend/add-dividend.component';
import { ViewTransactionComponent } from './view-transaction/view-transaction.component';
import { AddTransactionComponent } from './add-transaction/add-transaction.component';
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faFilm } from '@fortawesome/free-solid-svg-icons';
import { NgApexchartsModule } from 'ng-apexcharts';
import { SortByOrderPipe } from './sort-by-order.pipe';
import { LoginComponent } from './login/login.component';

import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ViewCurrencyComponent } from './view-currency/view-currency.component';
import { AddCurrencyComponent } from './add-currency/add-currency.component';
import { OrderModule } from 'ngx-order-pipe';
import { SecurityComponent } from './security/security.component';
import { AppInterceptor } from './app.interceptor';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ContentComponent,
    FooterComponent,
    ViewAccountsComponent,
    ViewStocksComponent,
    ViewTradesComponent,
    ViewDividendsComponent,
    AddAccountComponent,
    AddStockComponent,
    AddTradeComponent,
    AddDividendComponent,
    ViewTransactionComponent,
    AddTransactionComponent,
    AppComponent,
    SortByOrderPipe,
    LoginComponent,
    ViewCurrencyComponent,
    AddCurrencyComponent,
    SecurityComponent,
    
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FontAwesomeModule,
    BrowserModule,
    AppRoutingModule,
    NgApexchartsModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AppInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(library: FaIconLibrary){
    library.addIcons(faFilm);
  }
 }
