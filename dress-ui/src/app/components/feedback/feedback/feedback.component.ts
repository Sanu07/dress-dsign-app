import { Component, OnInit } from '@angular/core';
import { IFeedback } from 'src/app/models/feedback';
import { FeedbackService } from 'src/app/services/feedback.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  public feedbacks: IFeedback[];

  constructor(private feedbackService: FeedbackService) { }

  ngOnInit() {
    this.getAllFeedbacks();
  }

  getAllFeedbacks(): void {
    this.feedbackService.getAllFeedbacks().subscribe((response: IFeedback[]) => {
      this.feedbacks = response;
    });
  }
}
