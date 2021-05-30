import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  public isAuthorized: boolean;
  public hidden: boolean;
  public isSidenavClosed;

  @Output() sidenavToggle = new EventEmitter<void>();

  constructor(
    private authService: AuthService,
    private _snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.isAuthorized = true;
  }

  onToggleSidenav() {
    this.sidenavToggle.emit();
    this.isSidenavClosed = !this.isSidenavClosed;
  }

  toggleBadgeVisibility() {
    console.log(this.hidden);
    this.hidden = !this.hidden;
  }

  openSnackBar() {
    this._snackBar.open('Message-1', 'close');
  }
}
