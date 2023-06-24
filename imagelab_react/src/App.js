import './App.css';
import './imagelab-block'
import React, { useState, useEffect } from "react";
import { BlocklyWorkspace } from "react-blockly";
import { MY_TOOLBOX } from './toolboxConfiguration';
import { Navbar, Alignment, Button, Card, Elevation } from '@blueprintjs/core';
import './CustomBlockly.css';
import Blockly from "blockly";
import ImageViewer from './components/ImageViewer';
import { workspaceConfiguration } from './workspaceConfig';

function App() {
  const [xml, setXml] = useState("");
  const [imageUrl, setImageUrl] = useState(null);

  const handleUndo = () => {
    Blockly.mainWorkspace.undo(false);
  }

  const handleRedo = () => {
    Blockly.mainWorkspace.undo(true);
  }

  const handleReset = () => {
    const shouldReset = window.confirm('Are you sure you want to reset the workspace?');
    if (shouldReset) {
      Blockly.mainWorkspace.clear();
    }
  }

  //Hook to handle updating the image
  useEffect(() => {
    // Add event listener for the message
    window.addEventListener('message', handleMessage);

    // Cleanup the event listener on unmount
    return () => {
      window.removeEventListener('message', handleMessage);
    };
  }, []);

  const handleMessage = (event) => {
    if (event.data.type === 'imageSelected') {
      const imageUrl = event.data.imageUrl;
      setImageUrl(imageUrl);
    }
  };

  return (
    <>
      <Navbar>
          <Navbar.Group align={Alignment.LEFT}>
              <Navbar.Heading>ImageLab</Navbar.Heading>
              <Navbar.Divider />
              <Button className="bp4-minimal" icon="document-open" text="Open" />
              <Button className="bp4-minimal" icon="document-share" text="Save" />
              <Button className="bp4-minimal" icon="lightbulb" />
          </Navbar.Group>
          <Navbar.Group align={Alignment.RIGHT}>
              <Button className="bp4-minimal" icon="play" text="Run" />
              <Navbar.Divider />
              <Button onClick={handleUndo} className="bp4-minimal" icon="undo" />
              <Button onClick={handleRedo} className="bp4-minimal" icon="redo" />
              <Button onClick={handleReset} className="bp4-minimal" icon="reset" />
          </Navbar.Group>
      </Navbar>
      <div className='row'>
        <BlocklyWorkspace
          className="fill-height"
          toolboxConfiguration={MY_TOOLBOX} // this must be a JSON toolbox definition
          initialXml={xml}
          onXmlChange={setXml}
          workspaceConfiguration={workspaceConfiguration}
        />
        <div className='panel'>
          <h3>Preview | <Button className="bp4-minimal" icon="download" /> </h3>
          <Card elevation={Elevation.ONE}>
            <p>Original Img</p>
            <ImageViewer imageUrl={imageUrl} />
          </Card>
          <br />
          <Card elevation={Elevation.ONE}>
            <p>Processed Image</p>
            <ImageViewer />
          </Card>
        </div>
      </div>
  </>
  )
}

export default App;