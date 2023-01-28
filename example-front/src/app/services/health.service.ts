import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface BuildInfos {
  name: string;
  time: string;
  version: string;
}

export interface Health {
  build: BuildInfos;
}

@Injectable({
  providedIn: 'root'
})
export class HealthService {
//  private url = 'https://jsonplaceholder.typicode.com/todos/1';

  private url = '/management/info';

  constructor(private httpClient: HttpClient) { }

  getHealthStatus(){
    return this.httpClient.get<Health>(this.url);
  }

}
