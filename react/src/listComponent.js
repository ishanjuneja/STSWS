import React from 'react'
import TodoComponent from './todoComponent'

const ListComponent =(props)=>{

    return(
        
        <div>
        {props.todos.map((todo,index)=>
            <TodoComponent {...todo} 
            key={todo.todoText} 
            deleteMethod={props.deleteMethod}
            completeMethod={props.completeMethod}
            editMethod={props.editMethod}
            indexinmap={index}
            />
         )}
    </div>
    );

}

export default ListComponent;