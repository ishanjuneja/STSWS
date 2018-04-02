import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { HttpModule } from '@angular/http';
import { routing }  from './app.routing';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule,MatIconModule,MatSelectModule,MatListModule,MatOptionModule,MatTableModule,MatFormFieldModule,MatInputModule,MatDialogModule} from '@angular/material';
import { DashboardComponent,DialogOverviewExampleDialog } from './dashboard/dashboard.component';
import { DashboardService } from './dashboard.service';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    DialogOverviewExampleDialog
  ],
  entryComponents: [DialogOverviewExampleDialog],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule, 
    MatListModule,
    MatSelectModule,
    MatOptionModule,
    MatTableModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatDialogModule,
    FormsModule,
    HttpModule
    
  ],
  providers: [DashboardService],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
