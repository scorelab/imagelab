import './App.css';
import './imagelab-block'
import React, { useState } from "react";
import { BlocklyWorkspace } from "react-blockly";
import { MY_TOOLBOX } from './toolboxConfiguration';
import { Navbar, Alignment, Button, Card, Elevation } from '@blueprintjs/core';
import './CustomBlockly.css';

function App() {
  const [xml, setXml] = useState("");

  const workspaceConfiguration = {
    scrollbars: true,
    trashcan: true,
    sounds: true,
    oneBasedIndex: true,
    zoom: {
      controls: true,
      wheel: false,
      startScale: 0.6,
      maxScale: 2,
      minScale: 0.4,
      scaleSpeed: 1.2,
    },
    renderer: "zelos",
}

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
              <Button className="bp4-minimal" icon="undo" />
              <Button className="bp4-minimal" icon="redo" />
              <Button className="bp4-minimal" icon="reset" />
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
          <h3>Preview <Button className="bp4-minimal" icon="download" /> </h3>
          <Card interactive={true} elevation={Elevation.ONE}>
            <p>Original Image</p>
          </Card>
          <br />
          <Card interactive={true} elevation={Elevation.ONE}>
            <p>Processed Image</p>
          </Card>
        </div>
      </div>
  </>
  )
}

export default App;