import './App.css';
import './imagelab-block'
import React, { useState, useEffect, useRef } from "react";
import { BlocklyWorkspace } from "react-blockly";
import Blockly from "blockly";
import { MY_TOOLBOX } from './toolboxConfiguration';
import { Navbar, Alignment, Button, Card, Elevation } from '@blueprintjs/core';
import './CustomBlockly.css';
import ImageViewer from './components/ImageViewer';
import { workspaceConfiguration } from './workspaceConfig';
import { redo, reset, run, undo } from './utils/main';

function App() {
  const [xml, setXml] = useState("");
  const [imageUrl, setImageUrl] = useState(null);
  const [processedImage, setProcessedImage] = useState(null);

  const fileInputRef = useRef(null); // Ref for the hidden file input element

  const start = () => {
    const topBlock = Blockly.getMainWorkspace().getTopBlocks()[0];
    run(topBlock);
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
    if (event.data.type === 'imageProcessed') {
      const processedImage = event.data.canvasImageData;
      setProcessedImage(processedImage);
    }
  };

  const saveWorkspace = () => {
    const xmlText = xml;
    const element = document.createElement('a');
    const file = new Blob([xmlText], { type: 'text/plain' });
    element.href = URL.createObjectURL(file);
    element.download = 'blockly-workspace.xml';
    document.body.appendChild(element);
    element.click();
  }

  const loadWorkspace = (event) => {
    const file = event.target.files[0];
    const reader = new FileReader();
  
    reader.onload = (event) => {
      const xml = Blockly.Xml.textToDom(event.target.result);
      const workspace = Blockly.getMainWorkspace();
      Blockly.Xml.clearWorkspaceAndLoadFromXml(xml, workspace);
    };
  
    reader.readAsText(file);
  }  

  return (
    <>
      <Navbar>
          <Navbar.Group align={Alignment.LEFT}>
              <Navbar.Heading>ImageLab</Navbar.Heading>
              <Navbar.Divider />
              <Button className="bp4-minimal" icon="document-open" text="Open" onClick={() => fileInputRef.current.click()} />
              <input type="file" ref={fileInputRef} onChange={loadWorkspace} style={{ display: 'none' }}/>
              <Button className="bp4-minimal" icon="document-share" text="Save" onClick={saveWorkspace} />
              <Button className="bp4-minimal" icon="lightbulb" />
          </Navbar.Group>
          <Navbar.Group align={Alignment.RIGHT}>
              <Button onClick={start} className="bp4-minimal" icon="play" text="Run" />
              <Navbar.Divider />
              <Button onClick={undo} className="bp4-minimal" icon="undo" />
              <Button onClick={redo} className="bp4-minimal" icon="redo" />
              <Button onClick={reset} className="bp4-minimal" icon="reset" />
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
            <ImageViewer imageUrl={processedImage}/>
          </Card>
        </div>
      </div>
  </>
  )
}

export default App;