import React from 'react';
import RaisedButton from 'material-ui/RaisedButton';
import AppBar from 'material-ui/AppBar'
import IconButton from 'material-ui/IconButton';
import FontIcon from 'material-ui/FontIcon';
import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';

class HeaderComponent extends React.Component {


    state={
        menuOpen:false
    }

    buttonClicked=()=> {
       this.setState({menuOpen:true})
    }

    render() {
        return (

            <div>
                <AppBar
                    title="TODO APP"
                    onLeftIconButtonClick={this.buttonClicked}
                    iconElementRight={<IconButton>
                        <FontIcon className="material-icons">expand_more</FontIcon>
                    </IconButton>}
                />
                <Drawer
                    open={this.state.menuOpen}
                    onRequestChange={open => this.setState({ menuOpen: open })}
                    docked={false}>

                    <MenuItem onTouchTap={this.closeLeftNav} value={'/'} primaryText="Home"/>
                </Drawer>
            </div>
        );
    }

}

export default HeaderComponent;