package com.example.cachedemo.simple;

import com.example.cachedemo.data.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Bar {

  @Autowired
  private CacheManager cacheManager;

  @GetMapping("bar")
  public String hello(HttpServletRequest request) {
    String uid = "b1992490";
    Report report = getReport(uid);
    report.setPath("どこか");
    report.setSonota("あれやこれや");
    putReport(uid, report);
    return "key: " + uid + " のReportに情報を追加";
  }

  private Report getReport(String key) {
    Cache reportCache = cacheManager.getCache("report");
    return (Report) reportCache.get(key).get();
  }

  public void putReport(String uid, Report report) {
    Cache reportCache = cacheManager.getCache("report");
    reportCache.put(uid, report);
  }
}
