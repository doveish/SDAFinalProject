import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/AuthService';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

constructor(private router: Router,
  private authService: AuthService){}

ngOnInit(): void {
    
}

menuItems = [
  {linkId: 1, linkName: 'Home', linkUrl: 'home'},
  {linkId: 2, linkName: 'Accounts', linkUrl: 'account'},
  {linkId: 3, linkName: 'Stocks', linkUrl: 'stock'},
  {linkId: 4, linkName: 'Trades', linkUrl: 'trade'},
  {linkId: 5, linkName: 'Dividends', linkUrl: 'dividend'},
  {linkId: 6, linkName: 'Currencies', linkUrl: 'currency'},
  



];

logout(): void {
  console.log("Logout button clicked");
  this.authService.logout();
  this.router.navigate(['/']);
}

goToLink(linkUrl: string): void {
  switch (linkUrl) {
    case '':
      this.router.navigate(['/home']);
      break;
    case 'account':
      this.router.navigate(['/account']);
      break;
    case 'stock':
      this.router.navigate(['/stock']);
      break;
    case 'trade':
      this.router.navigate(['/trade']);
      break;
    case 'dividend':
      this.router.navigate(['/dividend']);
      break;
      case 'currency':
        this.router.navigate(['/currency']);
        break;
    default:
     
      break;
  }
}

}
