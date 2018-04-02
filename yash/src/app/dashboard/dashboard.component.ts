import { Component, OnInit,Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { Router } from '@angular/router';
import { DashboardService } from '../dashboard.service'
import { MatTableDataSource } from '@angular/material';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  displayedColumns = ['position', 'question.category.id', 'question.questionText', 'answerButton'];
  dataSource;
  questions: object[];
  categories;
  categoryselected: string;
  animal: string;
  answer:string;
  answers:object[];
  

  constructor(private dashbaordService: DashboardService,public dialog: MatDialog) {
    this.getAllQuestions();
    this.getAllCategories();
  }

  getAllQuestions() {
    this.dashbaordService.getAll().subscribe(
      res => {
        this.questions = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        this.dataSource = new MatTableDataSource(this.questions);
      },
      err => console.log("Server Down")
    );
  }

  getAllCategories() {
    this.dashbaordService.getAllCategories().subscribe(
      res => {
        this.categories = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        console.log(this.categories);
      },
      err => console.log("server error")
    );
  }

  applyFilter(filterValue: string) {
    
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  openDialog(questionid): void {
    
    this.getAnswers(questionid);
    
    
  }
  
  getAnswers(questionid:number){
    this.dashbaordService.getAllAnswers(questionid).subscribe(
      res => {
        this.answers = JSON.parse(JSON.parse(JSON.stringify(res))._body);
        
        let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
          
          width: '450px',
          data: {
            dataKey: this.answers,
          }
        });
        //dialogRef.componentInstance.answers =this.answers ;
        dialogRef.afterClosed().subscribe(result => {
          console.log('The dialog was closed');
          this.answer = result;
        });
      },
      err => console.log("server error")
    );
  }


  ngOnInit() {
  }

}

@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: './modal.component.html',
})
export class DialogOverviewExampleDialog {

  answers:object[];
  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any) { 

      

    }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
    
    this.answers=this.data.dataKey;
    console.log(this.answers);
    
  }
}
