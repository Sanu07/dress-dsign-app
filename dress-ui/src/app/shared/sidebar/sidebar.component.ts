import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  @Output() closeSidenav = new EventEmitter<void>();
  
  constructor() { }

  ngOnInit() {
  }

  onClose() {
    this.closeSidenav.emit();
  }
}
