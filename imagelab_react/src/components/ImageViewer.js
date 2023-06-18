import React from 'react';
import { Icon } from '@blueprintjs/core';

const ImageViewer = ({ imageUrl }) => {
  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100%' }}>
        {imageUrl ? (
          <img src={imageUrl} alt="Image" style={{ maxWidth: '100%', maxHeight: '100%' }} />
        ) : (
          <Icon icon="media" size={100} />
        )}
    </div>
  );
};

export default ImageViewer;
