import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokeninterceptorInterceptor } from './service/interceptors/tokeninterceptor.interceptor';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ApiService } from 'src/app/service/api.service.service';
import { AuthServiceService } from 'src/app/service/auth.service.service';
import { UserService } from 'src/app/service/user.service.service';
import { ConfigService } from 'src/app/service/config.service.service';

@NgModule({
  declarations: [AppComponent, HomeComponent, NavbarComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokeninterceptorInterceptor,
      multi: true,
    },
    AuthServiceService,
    ApiService,
    UserService,
    ConfigService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
