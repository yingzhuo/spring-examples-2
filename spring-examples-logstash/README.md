# spring-examples-logstash

logstash配置文件

```
input {
  file {
    path => "/log/all.json"
    codec => "json"
    type => "logstash"
  }
}
output {
  if [type]=="logstash" {
    elasticsearch {
      hosts => [ "127.0.0.1:9200" ]
      index => "spring-examples-logstash-%{+YYYY.MM.dd}"
    }
  }
}
```
