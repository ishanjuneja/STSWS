import React from 'react'
import {Card, CardActions, CardHeader, CardText} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import Dialog from 'material-ui/Dialog'

const TodoComponent =(props)=>(

    <Card style={{maxWidth:'20em',marginLeft:'40%',marginTop:'40px'}} 
    style={props.completed==='true'?
    {backgroundColor:'#ef5350',maxWidth:'20em',marginLeft:'40%',marginTop:'40px'}
    : {backgroundColor:'#009688',maxWidth:'20em',marginLeft:'40%',marginTop:'40px'}}>
    <CardHeader
      title={props.todoText}
      subtitle={props.completed}
      actAsExpander={true}
      showExpandableButton={true}
    />
    <CardActions>
      <FlatButton label="complete" onClick={()=>props.completeMethod(props.indexinmap,props.todoText)}/>
      <FlatButton label="delete" onClick={()=>props.deleteMethod(props.indexinmap)} />
      <FlatButton label="Edit" onClick={()=>props.editMethod(props.indexinmap)} 
      style={{backgroundColor:'#FFB300'}}
      />
      
    </CardActions>
    
    <CardText expandable={true}>
      {props.completed}
    </CardText>
  </Card>

);

export default TodoComponent;

    
    


    
