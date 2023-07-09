import React, { useState } from 'react';
import { Icon, Button, ButtonGroup } from '@blueprintjs/core';
import { TransformWrapper, TransformComponent } from 'react-zoom-pan-pinch';

const ImageViewer = ({ imageUrl }) => {
  const [initialScale, setInitialScale] = useState(1);

  const handleImageLoad = ({ target: img }) => {
    const imageWidth = img.naturalWidth;
    const imageHeight = img.naturalHeight;

    const viewerWidth = img.parentNode.clientWidth;
    const viewerHeight = img.parentNode.clientHeight;

    const scaleX = viewerWidth / imageWidth;
    const scaleY = viewerHeight / imageHeight;

    setInitialScale(Math.max(scaleX, scaleY));
  };

  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', position: 'relative', width: '100%', height: '250px', overflow: 'hidden' }}>
      {imageUrl ? (
        <TransformWrapper
          initialScale={initialScale}
          defaultPositionX={0}
          defaultPositionY={0}
          minScale={0.1}
          limitToBounds={true}
          boundSize={{ width: 1.25, height: 1.25 }}
          boundPosition={{ x: -0.125, y: -0.125 }}
        >
          {({ zoomIn, zoomOut, resetTransform, ...rest }) => (
            <React.Fragment>
              <div className='tools' style={{ position: 'absolute', zIndex: 1, right: 0, top: 0 }}>
                <ButtonGroup>
                  <Button icon="zoom-in" onClick={() => zoomIn()} />
                  <Button icon="zoom-out" onClick={() => zoomOut()} />
                  <Button icon="zoom-to-fit" onClick={() => resetTransform()} />
                </ButtonGroup>
              </div>
              <TransformComponent>
                <img 
                  src={imageUrl} 
                  alt="Image" 
                  onLoad={handleImageLoad} 
                />
              </TransformComponent>
            </React.Fragment>
          )}
        </TransformWrapper>
      ) : (
        <Icon icon="media" size={100} />
      )}
    </div>
  );
};

export default ImageViewer;
