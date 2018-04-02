import React from 'react';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';

const AddTodoComponent =(props)=>(

<div>
<TextField id="addText"
    hintText="TODO TEXT"
    style={{marginLeft:'42%',marginTop:'50px',marginRight:'10px'}}/>
<RaisedButton primary={true} style={{backgroundColor:'white'}} onClick={()=>props.addMethod(document.getElementById('addText').value)}>ADD</RaisedButton>
</div>
);

export default AddTodoComponent;