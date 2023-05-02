module com.udacity.catpoint.imagemodule {
  requires java.desktop;
  requires org.slf4j;
  requires software.amazon.awssdk.auth;
  requires software.amazon.awssdk.core;
  requires software.amazon.awssdk.regions;
  requires software.amazon.awssdk.services.rekognition;

  exports com.udacity.catpoint.image.service;
}
