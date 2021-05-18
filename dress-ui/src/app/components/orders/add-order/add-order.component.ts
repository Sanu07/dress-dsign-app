import { Component, OnInit } from '@angular/core';
import { MatChip } from '@angular/material';

const KURTI = 'Kurti';
const SALWAR = "Salwar";
const SHIRT = "Shirt";
const PANT = "Pant";

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.scss']
})
export class AddOrderComponent implements OnInit {

  public templates: string[] = [KURTI, SALWAR, SHIRT, PANT];
  public isKurti: boolean = false;
  public isSalwar: boolean = false;
  public isPant: boolean = false;
  public isShirt: boolean = false;

  constructor() { }

  ngOnInit(): void {

  }

  toggleSelection(chip: MatChip) {
    switch (chip.value.replace('check', '').trim()) {
      case KURTI: {
        this.isKurti = !this.isKurti;
        break;
      }
      case SALWAR: {
        this.isSalwar = !this.isSalwar;
        break;
      }
      case SHIRT: {
        this.isShirt = !this.isShirt;
        break;
      }
      case PANT: {
        this.isPant = !this.isPant;
        break;
      }
      default: {
        break;
      }
    }
    chip.toggleSelected();
  }
}
