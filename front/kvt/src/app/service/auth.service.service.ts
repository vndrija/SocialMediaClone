import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { ApiService } from './api.service.service';
import { UserService } from './user.service.service';
import { ConfigService } from './config.service.service';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthServiceService {
  constructor(
    private apiService: ApiService,
    private userService: UserService,
    private config: ConfigService,
    private router: Router
  ) {}
  private access_token = null;
  login(user: { username: any; password: any }) {
    const loginHeaders = new HttpHeaders({
      Accept: 'application/json',
      'Content-Type': 'application/json',
    });
    const body = {
      username: user.username,
      password: user.password,
    };
    return this.apiService
      .post(this.config.login_url, JSON.stringify(body), loginHeaders)
      .pipe(
        map((res) => {
          console.log('Login success');
          this.access_token = res.accessToken;
          localStorage.setItem('jwt', res.accessToken);
        })
      );
  }
  signup(user: any) {
    const signupHeaders = new HttpHeaders({
      Accept: 'application/json',
      'Content-Type': 'application/json',
    });
    return this.apiService
      .post(this.config.signup_url, JSON.stringify(user), signupHeaders)
      .pipe(
        map(() => {
          console.log('Sign up success');
        })
      );
  }

  tokenInUse() {
    return this.access_token != undefined && this.access_token != null;
  }

  findToken() {
    return this.access_token;
  }

  logout() {
    this.router.navigate(['/login']);
    this.access_token = null;
    this.userService.currentUser = null;
  }
}
