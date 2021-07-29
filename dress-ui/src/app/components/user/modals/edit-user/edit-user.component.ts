import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { IUser } from 'src/app/models/user';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

  editUserForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<EditUserComponent>,
    @Inject(MAT_DIALOG_DATA) public data: IUser,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.editUserForm = this.fb.group({
      fullName: [this.data.fullName, Validators.required],
      email: [this.data.email, Validators.required],
      phone: [this.data.phone, Validators.required],
    });
  }

}
