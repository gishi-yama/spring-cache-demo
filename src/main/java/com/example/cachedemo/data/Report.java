package com.example.cachedemo.data;

public class Report {

  private String uid;
  private String path;
  private String sonota;

  public Report(String uid) {
    this.uid = uid;
    this.path = "";
    this.sonota = "";
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public void setSonota(String sonota) {
    this.sonota = sonota;
  }

  @Override
  public String toString() {
    return uid + "," + path + "," + sonota;
  }
}
