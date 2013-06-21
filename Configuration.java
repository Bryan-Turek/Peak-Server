public class Configuration {
  
  protected String host = "localhost"; //default host
  protected int port = 2237; //default port
  protected String serverLog = "server.log"; //default server log
  protected String errorLog = "error.log"; //default error log
  protected String authentication = "C3o8Y5x+vkFQ/ygM+vCmwQp/SNyKzToWqCZwKsdw2Lwk781E0DabovAqEbNuqgUnvFwV2ZI+K0/NE/br9PNCQw==";
  
  /*
    Load Default configuration;
  */
  public Configuration() {
	  
  }
  
  /*
    Manually specify configuration settings;
  */
  public Configuration(String h, int p, String sl, String el) {
    this.host = h;
    this.port = p;
    this.serverLog = sl;
    this.errorLog = el;
  }
  
  public void setHost(String h) { // set host
    this.host = h;
  }
  
  public void setPort(int p) {
    this.port = p;
  }
  
  public void setServerLog(String sl) {
    this.serverLog = sl;
  }
  
  public void setErrorLog(String el) {
    this.errorLog = el;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public int getPort() {
    return this.port;
  }
  
  public String getServerLog() {
    return this.serverLog;
  }
  
  public String getErrorLog() {
    return this.errorLog;
  }
  
  public String getAuthentication() {
	  return this.authentication;
  }
  
}