import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface Health {
  status: string;
}

@Injectable({
  providedIn: 'root'
})
export class HealthService {
//  private url = 'https://jsonplaceholder.typicode.com/todos/1';

  private url = '/management/health';

  constructor(private httpClient: HttpClient) { }

  getHealthStatus(){
    return this.httpClient.get<Health>(this.url);
  }

}
