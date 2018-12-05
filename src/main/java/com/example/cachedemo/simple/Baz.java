package com.example.cachedemo.simple;

import com.example.cachedemo.data.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Baz {

  @Autowired
  private CacheManager cacheManager;

  @GetMapping("baz")
  public String hello(HttpServletRequest request) {
    String uid = "b1992490";
    Report report = getReport(uid);
    evictReport(uid);
    return uid + "のReportインスタンスは" + report.toString() + "で、cacheを削除した";
  }

  private Report getReport(String key) {
    Cache reportCache = cacheManager.getCache("report");
    return (Report) reportCache.get(key).get();
  }

  private void evictReport(String key) {
    Cache reportCache = cacheManager.getCache("report");
    reportCache.evict(key);
  }


}
