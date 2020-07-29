import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { OrdersService } from 'app/services/orders/orders.service';

@Component({
  selector: 'app-measurements',
  templateUrl: './measurements.component.html',
  styleUrls: ['./measurements.component.css']
})
export class MeasurementsComponent implements OnInit {

  public dressParams = [];

  @Output() onSaveMeasurements: EventEmitter<any> = new EventEmitter<any>();

  constructor(
    private ordersService: OrdersService
  ) { }

  ngOnInit(): void {
    this.ordersService.getDressMeasurementsParams().subscribe((res) => {
      let chunkIndex = [];
      Object.keys(res).map((key, index) => {
        chunkIndex.push({ name: key, value: res[key], measurements: '' });
        if (index % 3 === 2) {
          this.dressParams.push(chunkIndex);
          chunkIndex = [];
        }
      });
    });
  }

  onSubmit(data: any) {
    console.log(data);
    this.onSaveMeasurements.emit(data)
  }
}
