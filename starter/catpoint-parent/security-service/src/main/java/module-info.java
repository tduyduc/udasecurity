module com.udacity.catpoint.securitymodule {
  exports com.udacity.catpoint.security.application;
  exports com.udacity.catpoint.security.data;
  exports com.udacity.catpoint.security.service;

  requires com.udacity.catpoint.imagemodule;

  requires com.google.common;
  requires com.google.gson;
  requires java.desktop;
  requires java.prefs;
  requires miglayout;
}
