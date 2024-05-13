# GPU server(AI 연산용)
Path Through
GPU를 고르면 그에 맞는 세팅이 자동 결정




# load balancer
서버가 장애가 생기면 처리하기 위해 또는 성능을 위해 서버를 늘릴 때 컴퓨터에게 작업을 나눠주는 장치, 즉 부하를 분산처리하는 장치

# Global DNS
## DNS 서비스
nslookup
dig

www.naver.com 을 찾아가고자 할 떄

1단계
- 1st DNS에 naver.com의 IP 주소를 물어본다
- 2nd DNS에 naver.com의 IP 주소를 물어본다
168.126.63.1 => KT
168.126.63.2 => KT

2단계
168.126.63.1의 1st DNS에 naver.com의 IP 주소를 물어본다.

3단계 
4단계 
- IANA => 최상위 도메인 관리 기관
naver.com의 주소는 125.209.248.6이라는 것을 확인 

5단계 
168.126.63.1이 125.209.248.6이라는 것을 확인
그러면 naver.com 네임 서버는 223.130.200.247이라고 응답한다. 이정보를 나에게 보내준다.

6단계 
223.130.200.247에 접속한다.

### 레코드 타입
A
IPv4의 IP를 지정

NS, delegation(위임)
```
낙수 전자 => www.elec.naksoo.com
mail.elec.naksoo.com
...
..
```

SOA
www.naksoo.com => 175.45.203.138

PTR
175.45.203.138 => www.naksoo.com

CNAME
아이피가 변경되었을 때 캐싱된 데이터를 가지고 옛 아이피로 접속하는 상황을 방지하기 위해 사용
www.naksoo.com => 175.45.203.138
www.naksoo.com => web001.naksoo.com
web001.naksoo.com => 175.45.203.138

# Global Traffic Manager(GTM)
GTM
- Geolocation
- Round-Robin
- Failover

GSLB
- RR, W, FO


# CDN(Content Delivery Network)
컨텐츠를 Cashing 하여 보다 빠르고 안정적으로 사용자에게 전송하는 서비스 

언제 필요한가?
- 대규모 파일 배포나 이미지/동영상 서비스 등 대규모 트래픽이 발생하는 경우

CDN이 터지는 경우는?
없다. 서버는 터지지만 네트워크는 눌린다.
만약 1GB짜리 파일이 있을 때 

* purge
cache의 Expiry 기한이 지나지 않아도 강제로 변경사항을 CDN에 적용하는 기술

# VPN
SSL VPN
- 외부에서 서버 접속시 보안 통신이 가능하도록 보안 소켓 계층 기반의 가상 사설망

IPSEC VPN
- 고객의 사내망과 플랫폼 간 사설 통신을 위한??????

*gateway: 네트워크에서 다른 네트워크로 이동하기 위해 거쳐야하는 지점

# Auto Scaling
서버 수를 자동으로 증가 또는 감소시켜 안정적인 서비스를 유지하고 비용을 절감하는 기술. 미리 등록한 설정 ex) cpu 사용률 50% 차면 100% 증가, 

## Event Rule
1단계: 모니터링할 상품 선택
2단계: 모니터링할 항목 선택
3단계: 임계치 설정
4단계: 임계치 돌파 시 취할 액션

## Cloud Fucntion
별도의 서버나 인프라를 프로비저닝 하거나 관리하지 않고 코드를 실행할 수 있는 서버리스 컴퓨팅. 
auto scaling, kubernetis를 사용하지 않고 코드를 올려 서버에 대한 코드를 실행한다.????


# File System
os에서 보조 기억 장치에 저장되는 파일을 관리하는 시스템의 통칭르로 파일을 저장할 클러스터를 관리하고 파일명에 대한 규칙, 데이터의 저장과 검색을 관장한다.
File System은 os에 종속적이라 os가 달라지면 저장방식도 달라진다.

## 로컬 파일 시스템 방식
**연속 할당 방식**  

**비연속 할당 방식**  
- 연결 할당 방식: 지금 안씀
- 색인 할당 방식: 최근 대부분이 이 방식 사용

## 로컬 파일 시스템의 단점
- 용량의 한계
- 장애 복구 한계
- 다양한 접근 경로를 제공하지 않음

## 네트워크 파일 시스템(NFS, CIFS)
네트웤을 통해 파일 시스템에 접근, 용량을 높이려면 고가의 인프라 비용이 발생한다.

- 분산 파일 시스템(HDFS, ADF, CODA): 파일을 개서 노드에 분산&복제하는 방식 

## 스토리지 타입
- block storage
- object storage

# Object Storage
인터넷상에 원하는 데이터를 저장하고 사용할 수 있도록 구축된 객체 기반의 무제한 파일 저장 스토리지

## storage 계층
- cold storage: 자주 사용되지 않는 정형 또는 비정형 데이터를 위한 스토리지
- warm storage: 적당히 자주 사용되는 구조화된 데이터를 위한 스토리지 
- hot storage: 자주 사용하는 구조화된 데이터를 위한 스토리지.

*data-lifecycle: hot storage에 있는 data가 시간이 지남에 따라 일정 조건(자주 사용x)에 맞으면 warm storage나 cold storage로 옮기는 것

# Archive Storage
데이터 아카이빙 및 장기 백업에 최적화된 스토리지 서비스
Object Storage보다 저렴하지만 데이터 처리 api는 비쌈

# NAS(Network-Attached Storage)
다수의 서버에서 공유하여 사용할 수 있는 스토리지, 파일로 데이터에 액세스.  
클라이언트 OS 관점에서 파일서버로 인식한다.

# Data Teleporter
대용량 데이터 이전을 위한 어플라이언스
매우 크고 빠른 USB라 보면 됨

# Backup
- Full Backup: 전체 백업
- 증분 Backup: 리스토어시 백업,  이전 백업을 기준으로 순차적으로 저장
- 차등 Backup: 리스토어는 Full 백업 원하는 시점, 풀 백업을 기준으로 저장

# Cloud DB for MySQL
RDBMS
이중화 지원
기본적인 백업 지원(1달)

```
디스크 시작용량: 10GB
디스크 증가용량: 10GB
디스크 최대용량: 6TB
백업기간: 30일
포트: 3306
슬레이브: 10대
private subnet: O
public subnet: O
```

데이터베이스의 이중화는 복잡. 로드 밸런서는 사용할 수 없다. 무결성이 깨져버리기 때문

*Fail-over?


# Cloud DB for Redis
자동 복구를 통해 안정적으로 운영되는 완전 관리형 클라우드 인메모리 캐시 서비스

```
디스크 시작용량: -
디스크 증가용량: -
디스크 최대용량: -
백업기간: 7일
포트: 6379
슬레이브: 4대
private subnet: O
public subnet: X
```


# Cloud DB for MS-SQL
Principal DB에서 로그를 가져와 Mirror DB에서 재구축, 따라서 실시간성은 없다.
```
디스크 시작용량: 100GB
디스크 증가용량: 10GB
디스크 최대용량: 2TB
백업기간: 30일
포트: 1433
슬레이브: 5대
private subnet: O
public subnet: O
```

# Cloud DB for MongoDB
NoSQL의 대표적인 MongoDB를 간편하게 사용할 수 있는 서비스

Document DB
데이터를 저장할 때 XML로 저장됨.
기존 정의된 변수를 사용하지 않기 때문에
사용자가 자유롭게 항목을 바꿀 수 있는 포맷의 데이터를 저장할 때 편함

```
디스크 시작용량: 10GB
디스크 증가용량: 10GB
디스크 최대용량: 2TB
백업기간: 30일
포트: 27000~
슬레이브: 7대
private subnet: - 둘다 필요 
public subnet: -
```

# Cloud DB for PostgreSQL
extension이라는 특이한 기능이 존재

```
디스크 시작용량: 10GB
디스크 증가용량: 10GB
디스크 최대용량: 6TB
백업기간: 30일
포트: 5432
슬레이브: 5대
private subnet: O
public subnet: O
```

# AI & Application

# Geo Location
사용자 IP를 통해 위치 정보를 제공하는 서비스
IP 주소에 따른 지역 정보 DB를 검색해 좌표 정보 전달

# SENS(Simple & Easy Notification Service)

# Outbound Mailer
대량 메일 발송을 위한 메일 발송 상품

# nShortURL
길고 복잡한 URL을 간단하고 짧게 변경하는 API