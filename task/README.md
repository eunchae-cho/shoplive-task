## ShopLive 프로젝트

### 📑 기술

| name | version |
|:--:|:--:|
| `Java` | 1.8 |
| `Spring boot` | 2.7.8 |
| `Dockder` | 20.10.22 |
| `Gradle` | 7.4.2 |
| `Jquery` | 3.6.3 |


### 실행 방법

1. Docker CentOS Image 받기
``` 
$ docker pull redis   
```

2. Docker CentOS 실행 
```
$ docker run -i -t --name mycentos centos /bin/bash
```

3. Docker Redis 실행
```
$ docker run --name myredis -d -p 6379:6379 redis

[redis-cli로 접속 1]
$ docker run -it --link myredis:redis --rm redis redis-cli -h redis -p 6379

[redis-cli로 접속 2]
$ redis-cli -p 6379
```
