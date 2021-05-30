import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  public folders = [
    {name: 'sanu', updated: 'thurs'},
    {name: 'sanu', updated: 'thurs'}
  ];

  public notes = [
    {name: 'sanu', updated: 'thurs'},
    {name: 'sanu', updated: 'thurs'}
  ];
  constructor() { }

  ngOnInit() {
  }

}
