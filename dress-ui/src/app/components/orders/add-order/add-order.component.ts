import { Component, OnInit } from '@angular/core';
import { MatChip, MatDialog } from '@angular/material';
import { AddOrderData } from 'src/app/models/add-order.model';
import { AddOrderModalComponent } from '../modals/add-order-modal/add-order-modal.component';

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
  public measurementsData: AddOrderData[];

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
    const data = [
      {name: 'length', size: '20', amount: 1234},
      {name: 'width', size: '40', amount: 1834},
      {name: 'width', size: '40', amount: 1834},
      {name: 'width', size: '40', amount: 1834},
      {name: 'width', size: '40', amount: 1834},
      {name: 'width', size: '40', amount: 1834}
    ];
    this.measurementsData = data;
  }

  toggleSelection(chip: MatChip): void {
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

  onOpenOrder(dressType: string): void {
    const dialogRef = this.dialog.open(AddOrderModalComponent, {
      width: '750px',
      restoreFocus: false,
      data: this.measurementsData
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(dressType);
      console.log(result);
      this.measurementsData = result;
      console.log(this.measurementsData);
    });
  }
}
