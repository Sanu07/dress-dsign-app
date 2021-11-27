import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { IUser } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  signupForm: FormGroup
  profileImage: File;

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      fullName: ['', Validators.required],
      phone: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      password: ['', Validators.required],
      email: ['', Validators.email]
    });
  }

  onFileSelected(event) {
    const file: File = event.target.files[0];
    if (file) {
      // this.fileName = file.name;
      this.profileImage = file;
    }
  }

  onRegister() {
    const user: IUser = this.signupForm.value;
    // user.file = this.profileImage;
    this.userService.addUser(user, this.profileImage).subscribe((user: IUser) => {
      console.log(user);
    });
  }

}
