import './App.css';
import './imagelab-block'
import React, { useState, useEffect } from "react";
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

  useEffect(() => {
    return () => {
      localStorage.removeItem('base64Image'); 
      localStorage.removeItem('storedImage');
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

  const handleDownload = () => {
    const imageUrl = localStorage.getItem('storedImage'); 

    if (!imageUrl) {
      window.alert('No processed image found in storage!');
      return;
    }

    const link = document.createElement('a');
    link.href = imageUrl;
    link.download = 'processed_image.jpg'; 
    
    link.click();
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
          toolboxConfiguration={MY_TOOLBOX}
          initialXml={xml}
          onXmlChange={setXml}
          workspaceConfiguration={workspaceConfiguration}
        />
        <div className='panel'>
          <h3>Preview | <Button className="bp4-minimal" icon="download" onClick={handleDownload} /> </h3>
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