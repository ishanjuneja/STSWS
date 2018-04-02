import React, { Component } from 'react';

import './App.css';
import HeaderComponent from './HeaderComponent'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import ListComponent from './listComponent'
import AddTodoComponent from './addTodoComponent'
import DialogComponent from './dialogComponent'

class App extends Component {

  state = {

    open:false,

    todo:{todoText:'',completed:''},

    todos: [

    ],

    temptodos: []
  }

  addTodo = (todo) => {
    this.setState({
      todos: this.state.todos.concat({ todoText: todo, completed: 'false' })
    })
  }

  deleteTodo = (index) => {
    this.setState({
      temptodos: this.state.todos.splice(index,1)
    })
   
  }


  completeTodo=(index,text)=>{
    var todo={
      todoText:text,
      completed:'true'
    }
    this.setState({
      temptodos:this.state.todos.splice(index,1,todo) 
    })
  }

openDialog=(index)=>{
  this.state.todo=this.state.todos[index]
this.setState({
  open:this.state.open=true
})
}

editTodo=(todo,index)=>{
console.log(todo);
}



  render() {
    return (
      <MuiThemeProvider>
        <HeaderComponent />
        <AddTodoComponent addMethod={this.addTodo} />
        <ListComponent todos={this.state.todos} 
                       deleteMethod={this.deleteTodo}
                       completeMethod={this.completeTodo}
                       editMethod={this.openDialog} />
        <DialogComponent show={this.state.open} 
                         text={this.state.todo.todoText} 
                         completed={this.state.todo.completed}
                         editMethod={this.editTodo} />
      </MuiThemeProvider>
    );
  }
}

export default App;
