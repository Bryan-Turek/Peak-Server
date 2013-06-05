/*
  PEAK TCP Server
  Author: Bryan Turek
*/
package server

import (
  "net"
  "os"
  "log"
  "encoding/json"
  "io/ioutil"
)

/*
  Set configuration file location and receive buffer length
*/
const (
  CONFIG_FILE = "./config.json"
  RECV_BUF_LEN = 1024
)

/*
  Structure the configuration as TCP server settings
*/
type debugging bool
type ConfigType struct {
  Name string
  Author string
  Debug debugging
  Port string
  Version string
  Databases []Database
  Applications []string
  Locations []string
  Log string
}

/*
  Database structure for local database support
*/
type Database struct {
  Host string
  User string
  Pass string
  Type string
  Name string
}

/*
  Main function; reads configuration data and starts listening for data
*/
func main() {
  
  //read in configuration file
  var config ConfigType
  file, err := ioutil.ReadFile(CONFIG_FILE)
  if err != nil {
    log.Printf("ERROR: File could not be read: %v\n", err)
    os.Exit(1)
  }
  json.Unmarshal(file, &config)
  
  //start server
  println("Starting "+config.Name)
  listener, err := net.Listen("tcp", "0.0.0.0:" + config.Port)
  if err != nil {
    log.Printf("ERROR: listening on server, is there one already running?")
    os.Exit(1)
  }
  println("TCP server listening on port " + config.Port)
  for {
    conn, err := listener.Accept()
    if err != nil {
      log.Printf("ERROR:")
      return
    }
    go ReadData(conn)
  }
}

/*
  Reads data from TCP connection
*/
func ReadData(conn net.Conn) {
  buf := make([]byte, RECV_BUF_LEN)
  
  //receive data
	n, err := conn.Read(buf)
	if err != nil {
    log.Printf("ERROR: reading:", err.Error())
		return
	}
	println("received ", n, " bytes of data =", string(buf))
  
  //response, err := Command.execute(buf)
 
	//send reply
  _, err := conn.Write(buf)
	if err != nil {
		log.Printf("Error send reply:", err.Error())
	}else {
		println("Reply sent")
	}
}

/*
  Printing support for log data
*/
func (d debugging) Printf(format string, args ...interface{}) {
  if d {
    log.Printf(format, args...)
  }
}