---
layout: page
title: Applications
---

This page helps you to take the headstart to play with ImageLab. This includes prominent image processing applications you can create under this version of the project.

## 1. Image Pyramids Up and Down
Pyramid is an operation on an image where,

An input image is initially smoothed using a particular smoothing filter (ex: Gaussian, Laplacian) and then the smoothed image is subsampled.

This process is repeated multiple times.

During the pyramid operation, the smoothness of the image is increased and the resolution (size) is decreased.

There are two variation of image pyramids. That are Pyramids Up & Down.

``Pyramids Up`` - This operation will initially up sampled and then blurred the image

``Pyramids Down`` - This operation will initailly blurred and then down sampled

![Image pyramids](./../assets/image_pyramids.gif)

As in the above demo, it clearly visible that by a one iteration of pyramids up and down will reduce the image quality. It means that the operator has downgrade the image qualities.

## 2. Image Analysis with Histograms

Histograms is a graph or plot, which gives you an abtract idea about the intensity distribution of an image. It is a plot with pixel values(0-255) in X-axis and corresponding of number of pixels in the image on Y-axis.

You can apply histogram operator from the ```Histogram Operations``` operator section and make sure that to apply the operator at the end of the pipeline to clearly demostrate the chnages occuring when properties changed on each operator.

Application automatically detect whether the image is a RGB or Gray image.Based upon that it will output the histogram.

### RGB Histogram

![RGB Image](./../assets/rgb-histogram.gif)

### Gray image Histogram

![Gray Image](./../assets/gray-histogram.gif)

<br>

## 3. Find & Draw the Contours in an image

This operation despite to use contours for a particular image. in order to use contours, move to ```Contour Operations``` in the sidebar and drag and drop the ``FIND-CONTOURS`` operator to the stream. Before applying this operator we need to pre-process with image conversion(RGB-to-Gray) and Image blurring(Smoothing)

![Find Contours](./../assets/find-contours.gif)

Contours can be explained simply as a curve joining all the continuous points (along the boundary), having same color or intensity. The contours are a useful tool for shape analysis and object detection and recognition.

To get accurate results we need to use a binary image. So before finding contours, apply thresold or canny edge detection.

