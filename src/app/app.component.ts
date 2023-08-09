import { Component, OnInit } from '@angular/core';
import { Account } from './service/account';
import { AccountService } from './service/account.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public account: Account[];
  constructor(private accountService: AccountService){}
  ngOnInit(): void {
    
  }
 
}
