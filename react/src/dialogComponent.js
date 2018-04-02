import React from 'react';
import Dialog from 'material-ui/Dialog';
import TextField from 'material-ui/TextField';
import FlatButton from 'material-ui/FlatButton';
const DialogComponent=(props)=>{

    return (
        <Dialog
        title='Edit TODO'
        //actions={actions}
        modal={true}
        open={props.show}
        onRequestClose={this.handleClose}
      >
        <TextField id='newText' value={props.text} ></TextField>
        <br/>
        <FlatButton label="save" style={{backgroundColor:'#A5D6A7'}} 
        onClick={()=>{props.editMethod(document.getElementById('newText').value , props.indexinmap)}} 
       /> 
      </Dialog>
    );
}

export default DialogComponent;