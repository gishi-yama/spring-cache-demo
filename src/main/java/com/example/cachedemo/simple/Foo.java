package com.example.cachedemo.simple;

import com.example.cachedemo.data.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Foo {

  @Autowired
  private CacheManager cacheManager;

  @GetMapping("foo")
  public String hello(HttpServletRequest request) {
    String uid = "b1992490";
    makeReport(uid);
    System.out.println(uid);
    return "key: " + uid + " でキャッシュを作成";
  }

  public void makeReport(final String uid) {
    Cache reportCache = cacheManager.getCache("report");
    reportCache.put(uid, new Report(uid));
  }
}
