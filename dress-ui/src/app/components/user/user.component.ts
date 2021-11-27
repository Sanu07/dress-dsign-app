import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DomSanitizer } from '@angular/platform-browser';
import { IUser } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { EditUserComponent } from './modals/edit-user/edit-user.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  public users: IUser[];
  public user: IUser = { id: '', fullName: '', email: '', phone: '', status: false, createdAt: '', updatedAt: '' };
  public profileImage: any;

  constructor(
    private userService: UserService,
    private dialog: MatDialog,
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(): void {
    this.userService.getAllUsers().subscribe((response: IUser[]) => {
      this.users = response;
      this.user = this.users[1];
      let objectURL = 'data:image/png;base64,' + this.user.file;
      this.profileImage = this.sanitizer.bypassSecurityTrustResourceUrl(objectURL);
      console.log(this.user);
    });
  }

  onEditUserModal() {
    const dialogRef = this.dialog.open(EditUserComponent, {
      width: '270px',
      restoreFocus: false,
      data: this.user
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result != undefined) {
        const updatedUser: IUser = Object.assign({}, this.user);
        updatedUser.fullName = result.fullName;
        updatedUser.email = result.email;
        updatedUser.phone = result.phone;
        this.userService.updateUserDetails(updatedUser).subscribe((response: IUser) => {
          this.user = response;
        });
      }
    });
  }
}
