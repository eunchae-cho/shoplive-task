## 프로젝트

### 📑 기술

| name | version |
|:--:|:--:|
| `Java` | 1.8 |
| `Spring boot` | 2.7.8 |
| `Dockder` | 20.10.22 |
| `Gradle` | 7.4.2 |
| `JQuery` | 3.6.3 |
| `CentOS` | 8.4.2105 |

### 빌드 환경
- application-local.yml : 로컬 환경 
  - 로컬에서 환경에 맞게 경로 수정 필요!
- application-dev.yml : docker 배포 환경
### 소스 빌드
1. gradle 경로 이동
```
... shoplive-task/task
```
2. 소스 빌드
```
$ ./gradlew clean bootjar
```
###  Docker 실행
1. docker-compose.yml 경로로 이동
```
... shoplive-task/task
```
2. 빌드하기
```
$ docker-compose build
```
3. 실행하기
```
$ docker-compose up
```

[//]: # (1. Docker CentOS Image 받기)

[//]: # (``` )

[//]: # ($ docker pull redis   )

[//]: # (```)

[//]: # ()
[//]: # (2. Docker CentOS 실행 )

[//]: # (```)

[//]: # ($ docker run -i -t --name mycentos centos /bin/bash)

[//]: # (```)

[//]: # ()
[//]: # (3. Docker Redis 실행)

[//]: # (```)

[//]: # ($ docker run --name myredis -d -p 6379:6379 redis)

[//]: # ()
[//]: # ([redis-cli로 접속 1])

[//]: # ($ docker run -it --link myredis:redis --rm redis redis-cli -h redis -p 6379)

[//]: # ()
[//]: # ([redis-cli로 접속 2])

[//]: # ($ redis-cli -p 6379)

[//]: # (```)

[//]: # (  )
[//]: # (4. CentOS에 Java 1.8 설치)

[//]: # (```)

[//]: # (# java)

[//]: # ($ yum install java-1.8.0-openjdk)

[//]: # ()
[//]: # (# javac)

[//]: # ($ yum install java-1.8.0-openjdk-devel)

[//]: # (```)
