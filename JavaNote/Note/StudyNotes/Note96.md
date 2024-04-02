## 호스트 볼륨 공유하기

- `$ sudo docker run -d --name wordpressdb_hostvolume -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=wordpress -v /home/wordpress_db:/var/lib/mysql mysql:5.7 `
- `-v 호스트의공유디렉토리:컨테이너의공유디렉토리`

호스트의 공유 디렉토리가 없으면 도커가 자동 생성한다.

즉 호스트의 디렉토리를 컨테이너가 사용하는 개념으로 호스트의 디렉토리가 컨테이너의 디렉토리를 가리킨다.

추가로 컨테이너가 삭제되어도 호스트 디렉토리에 데이터는 보존된다.


## 도커 볼륨 사용하기
- `sudo docker volume create --name myvolume` : 가상 하드디스크(볼륨) myvolume을 생성
- `sudo docker run -i -t --name docker1 -v myvolume:/root/ ubuntu:14.04` : myvolume을 사용하는 docker1 컨테이너를 생성하고 접속

- `cd root`

- `echo Hello, volume!` : 일반 출력
- `echo Hello, volume! >> test.txt` : 출력 결과를 파일로 리디렉션

- `sudo docker run -i -t --name docker2 -v myvolume:/root/ ubuntu:14.04` : myvolume을 사용하는 docker2 컨테이너를 생성하고 접속

- `cd root`
- `ls` : 다른 컨테이너이지만 같은 Volume을 공유하였기에 test.txt 파일이 존재하는 것을 확인할 수 있다. 

## 도커 볼륨의 실제 위치 알아내기
- `$ sudo docker inspect --type volume myvolume` : 컨테이너, 이미지, 볼륨 등 도커의 모든 구성 단위의 정보를 확인할 때 `inspect --type [image|volume|container]` 명령을 사용한다.

## 도커 볼륨 자동생성
- `sudo docker run -i -t --name volume_auto -v /root/ ubuntu:14.04` : 도커를 생성할 때 볼륨을 지정하지 않으면 자동으로 생성한다.

- `sudo docker container inspect volume_auto` : 권장되는 inspect 방법

<!-- ## 사용하지 않는 볼륨 자동삭제
- `$ sudo docker volume prune` --> 제대로 실행되지 않음

# 도커 네트워크
- `$ ifconfig` : 실행 중인 컨테이너 개수 만큼 `vethxxxx`(virtual ethernet) 가상 이더넷 카드가 생성된 것을 확인 할 수 있다.

## 컨테이너의 네트워크
- `$ sudo docker network ls` : 도커 엔진의 네트워크 목록 조회

> bridge: 컨테이너를 생성할 때 자동으로 연결되는 docker0 브리지를 활용하도록 설정됨.  
>172.17.0.x IP 대역을 컨테이너에 순차적으로 할당한다.

- `$ sudo docker network inspect bridge` : 특정 네트워크의 상태 조사

# 브릿지 네트워크
## 브릿지 바인딩 조회
- `$ sudo apt-get install bridge-utils` : 브릿지 바인딩 정보 조회를 위한 도구 설치
- `$ brctl show docker0` : 브릿지 바인딩 정보 조회

## 브릿지 네트워크 생성
- `$ sudo docker network create --driver bridge mybridge` : 새 브릿지 네트워크 생성
- `$ sudo docker run -it --network="mybridge" --name network1 ubuntu:14.04` : 새 컨테이너에 내가 만든 브릿지 네트워크 연결
- `$ sudo docker network inspect mybridge` : 브릿지 네트워크 상세 정보 보기, 컨테이너가 실행되고 있을 때 container 정보를 확인할 수 있다.

브릿지 네트워크를 직접 생성하면 새 IP address를 부여할 수 있다. 예를 들면 브릿지를 생성할 때 새로 생기는 IP 서브넷에 컨테이너 IP가 묶인다.

## 컨테이너에 브릿지 네트워크를 붙이기/떼기
- `$ sudo docker network disconnect mybridge network1` : 브릿지 네트워크 제거 후 확인
- `$ sudo docker attach network1`
- `# ifconfig`

- `$ sudo docker network connect bridge network1` : 컨테이너에 브릿지 네트워크 붙이고 확인
- `$ sudo docker attach network1`
- `# ifconfig`

# 컨테이너 로깅
## 도커 이미지 검색
- `$ sudo docker search 키워드` : 도커 허브라는 중앙 이미지 저장소에서 도커 이미지 검색하기

## 도커 이미지 생성









# WISIWIC 자바스크립트 에디터

