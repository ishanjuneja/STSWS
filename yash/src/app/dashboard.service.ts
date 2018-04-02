import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class DashboardService {

  constructor(private http: Http) { }

  getAll() {
    let url = "http://localhost:8080/otdfweb/questions";


    let headers = new Headers(
      {
        'Content-Type': 'application/json',
        // 'Access-Control-Allow-Credentials' : true
        'Access-Control-Allow-Origin': true
      });
    return this.http.get(url, { headers: headers, withCredentials: true });
  }

  getAllCategories() {
    let url = "http://localhost:8080/otdfweb/categories";

    let headers = new Headers(
      {
        'Content-Type': 'application/json',
        // 'Access-Control-Allow-Credentials' : true
        'Access-Control-Allow-Origin': true
      });
    return this.http.get(url, { headers: headers, withCredentials: true });
  }

  getAllAnswers(questionid:number){
    let url="http://localhost:8080/otdfweb/categories/1/questions/"+questionid;
    let headers = new Headers(
      {
        'Content-Type': 'application/json',
        // 'Access-Control-Allow-Credentials' : true
        'Access-Control-Allow-Origin': true
      });
    return this.http.get(url, { headers: headers, withCredentials: true });

  }

}
