import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IFeedback } from '../models/feedback';
import { HelperService } from './util.service';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService extends HelperService {

  constructor(private http: HttpClient) {
    super();
  }

  getAllFeedbacks(): Observable<IFeedback[]> {
    return this.http.get<IFeedback[]>(this.BASE_URL + 'feedbacks');
  }
}
