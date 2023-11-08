# Ubuntu Linux

## Testing stance

### VMware
- Player

- Pro (30일 제한, 이후 부가 기능만 사용 가능)
    - (스냅샷 기능, ens 설정)
### 1. Server (Ubuntu 20.04 DeskTop)
- [우분투 데스크탑 다운로드] (http://old-releases.ubuntu.com/releases/20.04.0/ubuntu-20.04-desktop-amd64.iso)
### 2. Server(B) (Ubuntu 20.04 Server)
- [우분투 서버 다운로드] (http://old-releases.ubuntu.com/releases/20.04.0/ubuntu-20.04-live-server-amd64.iso)
### 3. Client (Kubuntu 20.04)
- [쿠분투 다운로드 링크] (http://cdimage.ubuntu.com/kubuntu/releases/20.04/release/kubuntu-20.04.6-desktop-amd64.iso)
### 4. WinClient (Win 10 평가판)
- [평가판 다운로드 링크(한국어 32bit)] (https://www.microsoft.com/ko-kr/evalcenter/download-windows-10-enterprise)

## 네트워크 설정
Ubuntu
- VMWare의 IP를 수동으로 바꿔준 후, 게이트웨이 연결 (윈도우 Command 창에서)
    - `ipconfig`
- VMWare Network Adaptor VMnet8을 확인
    - `VMWare Pro`에서 설정을 바꿔야 함.
    - [Edit] > [Virtual Network Editor]
    - Change Setting
    - Subnet IP : 192.168.111.0 (사설 네트워크에서 자주 쓰임)
- Ubuntu에서 IP 주소 확인
    - `ip addr`  

## 패키지 설치 dpkg, apt
- 우분투 : 리눅스 데비안 계열
    - 확장자가 deb(debian package) 설치파일

```
dpkg -l [패키지 이름] : 설치된 패키지 확인 가능
dpkg --info [파일명.deb] : 파일정보 확인 가능
dpkg -L zip : 모든 패키지 파일 확인 가능
dpkg -i [파일명.deb] : 패키지 설치
dpkg -r [패키지 이름] : 패키지 삭제

단점 : 패키지 파일이 있어야 하고, 의존성 문제가 있을 시 설치되지 않음.

axel 패키지 : 파일 다운로드 패키지
galculator 패키지 : GTK 환경에서 사용되는 기초 과학 모드 계산기

apt : 인터넷을 통해 다운로드와 의존성 문제를 해결해주는 패키지 관리자
apt install [패키지 명] : 패키지 설치
apt update : apt 목록 업데이트
apt remove [패키지 명] : 패키지 삭제
apt purge [패키지 명] : 패키지 삭제 + 설정파일 까지 제거
apt autoremove : 자주 사용하지 않는 패키지 자동 제거
apt-cache show [패키지 명] : 설치하지 않은 패키지 확인
apt-cache depends [패키지 명] : 의존성 파일 확인
apt-cache rdepends [패키지 명] : 이 패키지를 의존하는 패키지 확인
```

### apt 작동 방식
/etc/apt/sources.list 파일 내부의 패키지 목록을 불러옴.  
- 저장소 종류
    - main : 공식 무료
    - universe : 비공식 무료
    - multiverse : 비공식 유료
    - restricted : 공식 유료
- 버전 코드
    - focal : 20.04 버전 지칭 (각 버전별 코드 있음)
    - focal-updates : 최신 버전의 패키지 설치
- 저장소 URL
    - ubuntu package mirror 사이트에서 URL을 가져옴.
- apt 동기화
    - $ apt update : sources.list 파일을 업데이트 함.
    - $ apt upgrade : 라이브러리에 있는 패키지 최신버전으로 업그레이드

## 압축 파일과 묶기
### 압축
- gz, xz, bz2(bzip2), zip 등을 사용
- xz
    - xz [파일명] : 파일 압축 (기존 파일 삭제)
    - xz -d [파일명.xz] : 압축 해제 (압축파일 삭제)
    - xz -k [파일명] : 파일 압축 (기존 파일 유지)
- bzip2
    - bzip2 [파일명] : 파일 압축 (기존 파일 삭제)
    - bzip2 -d [파일명.bz2] : 압축 해제 (압축파일 삭제)
    - bzip2 -k [파일명] : 파일 압축 (기존 파일 유지)
- gzip
    - gzip [파일명] : 파일 압축 (기존 파일 삭제)
    - gzip -d [파일명.gz] : 압축 해제 (압축파일 삭제)
    - gzip -k [파일명] : 파일 압축 (기존 파일 유지)
- zip
    - zip [생성될파일명.zip] [파일명] : 파일 압축 (기존 파일 유지)
    - unzip [파일명.zip] : 압축 해제 (압축파일 유지)
### 묶기
- tar : 파일 묶기 (리눅스에선 원칙적으로 '파일 묶기'와 '파일 압축'이 별개로 실행)  
    <strong>[동작]</strong>
    - c : 새로운 묶음
    - x : 묶음 해제  

    <strong>[옵션]</strong>
    - C : 새롭게 만들어준 폴더(지정한 디렉터리)에 압축묶음 풀기
    - f : 파일로 묶음 (default는 테이프)
    - v : 묶거나 푸는 과정을 보여줌
    - j : bzip2
    - J : xz
    - z : gzip

## 모듈과 커널
`커널 : 컴퓨터 운영 체제의 핵심이 되는 컴퓨터 프로그램으로 부팅시에 메모리에 로딩하는 코드`  
커널 위에 우분투나, CentOS나 RHCSA를 탑재  

`모듈 : 항상 사용되는 것이 아닌 가끔 사용되는 필수적인 라이브러리를 별도로 보관하는 것`  

- 커널 컴파일
    - 리눅스 배포판을 다운로드 받아 최신 버전 업그레이드 (최신 배포판의 경우 업그레이드를 통해 커널 업데이트가 원활히 이루어짐)
    - 다운로드 순서
        - 커널 소스 다운로드 : `kernel.org 사이트에서` tar형태로
        - 커널 소스 압축 풀기
        - `$ make mrproper` : 커널 설정 초기화
        - `$ make xconfig` : 커널 환경 설정 (Cpu, NTFS 설정 등)
        - make clean : 이전 컴파일 정보 삭제
        - 커널 컴파일 설치
            - `$ make`
            - `$ make module_install`
            - `$ make install`
- `$ unmame -r` : 현재 커널 버전 확인

## 하드디스크 추가하기

### 장치 타입
- IDE
- SCSI : 서버 및 기업용으로 주로 사용
    - SCSI 0:0~15(7번 제외) => 15개 * 슬롯 4개 : 총 60개
    - SCSI 하드디스크 장착시
        - 물리적 장치 ex) `/dev/sda`, `/dev/sdb` ...
        - 논리적 장치 ex) `/dev/sda1`, `/dev/sda2` ...
- SATA : PC용으로 주로 사용 
    - SATA 0:0~29 => 30개 * 슬롯 4개 : 120개
- NVMe

- 리눅스에서 하드디스크 추가 순서
    1. 물리적 디스크 장착 (/dev/sdb)
        - fdisk [물리적장치위치]
            - n (파티션 분할)
                - primary > 파티션 번호(1~4) > 시작섹터(enter) > 마지막섹터(enter) > p(설정 확인) > w
    2. 파티션 설정 (/dev/sdb1)
        - mkfs.ext4 [논리적장치위치]
    3. 파일 시스템 생성 (포맷)
        - mkdir [마운팅될디렉토리명]
        - mount [논리적장치위치] [마운팅될디렉토리명]
    4. /etc/fstab에 등록
        - 재부팅 후에도 마운팅 상태
        -    `(filesystem) (mount point) (type)  (option)    (dump)  (pass)`
        - ex) `/dev/sdb1 <>  /mydata  <>   ext4  <>  defaults <>    0   <>    0`

## RAID 방식 (Redundant Array of Inexpensive(Independent) Disks)
`서버 컴퓨터 저장장치는 대부분 RAID를 사용한다.`
- 하드웨어 RAID : 제조업체에서 하드디스크를 연결한 장비를 설치
    - 안정적이지만 / 고가
- 소프트웨어 RAID : 운영체제(OS)에서 지원하는 방식
    - 하드웨어 RAID 보다 덜 안정적이지만 저렴한 비용으로 안전하게 데이터 저장

- RAID Level
> 단순 볼륨

> Linear RAID : 2개 이상의 하드디스크를 연결만

> RAID 0 : Stripping 
>> - 여러 개의 디스크를 병렬로 배치하여 사용  
>> - 100%의 공간효율성, 빠른 속도  
>> - 결함 허용 안됨 : 데이터의 위험성이 증가, 하나가 고장나면 데이터 손상
>> - 빠른 성능이 필요하지만, 잃어버려도 문제가 없는 데이터

> RAID 1 : Mirroring
>> - 여러 개의 디스크에 데이터를 중복하여 기록  
>> - 하드 디스크의 용량을 절반만 사용 가능  
>> - 결함 허용 : 하나가 고장이 나더라도 데이터 손상 없음.  
>> - 데이터 저장에 2배의 용량이 필요, 50% 공간효율성  
>> - 중요한 데이터를 저장하기에 적합

> RAID 2, 3, 4는 실제 사용하지 않음.

> RAID 5 
>> - 패리티 비트를 사용해 데이터를 복구 (각 멤버 디스크에 순환 저장)
>> - 한 디스크가 고장나도 패리티 비트를 통해 저장상태를 유추 + 데이터 사용 가능
>> - 최소 3개 이상의 디스크가 필요
>> - 공간 효율성은 (N-1) 

### mdadm으로 Raid 구축 순서
1. 선처리 작업 (파티션 만들기)
    - fdisk를 통해 파티션 만들고
    - type을 Linux raid auto로 준다.
2. 볼륨 그룹 생성
    ```
    $ mdadm --create [생성할 논리 볼륨 (/dev/md9)] --level=[raid 타입 (linear)] --raid-device=[장치 연결 갯수] [논리 디스크 (/dev/sdb1)] [논리 디스크 (/dev/sdc1)] 
    ->
    $ mdadm --create /dev/md9 --level=linear --raid-device=2 /dev/sdb1 /dev/sdc1
    ```
3. 파일 시스템 포맷  
    `mkfs.ext4 [논리볼륨]`
4. 마운트
    - 연결할 디렉토리 생성
        - `mkdir /raidLinear` > 폴더 생성
        - `mount /dev/md9 /raidLinear` > 디바이스 마운트
5. /etc/fstab에 등록
    - [장치명] [마운트위치] [타입] [옵션] [dump] [pass]
    - /dev/md9 /raidLinear ext4 defaults 0 0
6. /etc/mdadm/mdadm.conf에 등록
    - mdadm --detail --brief /dev/md0 >> /etc/mdadm/mdadm.conf
    - mdadm --detail --brief /dev/md1 >> /etc/mdadm/mdadm.conf
    - mdadm --detail --brief /dev/md9 >> /etc/mdadm/mdadm.conf
    - mdadm --detail --brief /dev/md5 >> /etc/mdadm/mdadm.conf
    - update-initramfs -u 명령어로 커널 업그레이드
    - reboot or init 6
```
- 확인용 보조 명령
    - ls -l /dev/md* : 논리 볼륨 확인
    - mdadm --detail /dev/md9 : [논리볼륨] 레이드 자세히
    - df : 마운트 된 디스크 공간 확인
    - mdadm --detail --scan : Raid 확인

- 기타 명령
    - mdadm --stop /dev/md9 : [논리볼륨] 장치 중지
    - mdadm --run /dev/md9 : [논리볼륨] 장치 가동(중지가 되어 있을 때)

- 하드디스크 고장 확인 작업
    1. cp 명령 사용하여 아무 파일 복사
        - /raid0, /raid1, /raid5 /raidLinear
    2. 예시와 같이 하드디스크 제거 후 부팅
        - ls -l /dev/sd*
        - df 명령으로 확인
        - mdadm --detail --scan
    3. 결함 허용 되는 RAID 재가동
        - mdadm --run /dev/md1
        - mdadm --run /dev/md5
    4. 마운트
        - mount /dev/md1 /raid1
        - mount /dev/md5 /raid5
    5. 파일 확인
        - ls /raid1
        - ls /raid5
    6. 장치 상태 확인
        - mdadm --detail /dev/md1
        - mdadm --detail /dev/md5
- 원상 복구
    1. 물리적 하드 추가
    2. fdisk로 파티션 잡기
    - 결함 허용 RAID
        - mdadm /dev/md1 --add [새로 생성한 논리볼륨 (/dev/sdc1)]
    - 결합 허용하지 않는 RAID
        - mdadm --create로 재생성
```

## 명령어  

### 링크  
- 하드링크 : inode를 직접가리켜서 원본 파일이랑 동일한 inode를 갖게 됨.  
ln [옵션x] [원본파일] [새로생성할 파일 이름]  
원본파일과 같이 허가권, 소유권, 파일크기 같음.
- 심볼릭 링크 : 윈도우에서 바로가기 같은 것  
ln -s [원본파일] [새로생성할 파일 이름]  
파일크기가 경로명만큼 작음.
<img src="ImageFolder/link.png" alt="소프트링크, 하드링크 파일 생성">

원본파일을 부모폴더로 옮기기
<img src="ImageFolder/link-file-mv.png" alt="원본파일 부모폴더로 위치 변경">

다시 원본파일을 기존 폴더로 옮기기  
<img src="ImageFolder/link-file-mv2.png" alt="원본파일 기존폴더로 위치 변경">

### vi 에디터  
```
yy : 라인 복사
[숫자]yy : 원하는 라인 숫자 복사
p(소문자) : 아래에 붙여넣기
P(대문자) : 위에 붙여넣기
```

### 파일 위치 검색
- find
    - 옵션
        - -name (파일명 검색)
        - -user (소유자)
        - -perm (허가권)
        - -size (파일크기) +(이상), -(이하)
- which [패키지 명] : 경로에 설정된 디렉토리 검색
- whereis [패키지 명] : 실행파일, 메뉴얼 위치

### cron
- 주기적으로 반복되는 일을 자동으로 실행할 수 있도록 시스템 작업 예약
- /etc/crontab
- \* * * * * root(사용자이름) /root/myBackup.sh(스크립트)
    - 분 / 시 / 일 / 월 / 요일 / 사용자 / 실행명령
    - cf) \* * * * * run-parts 폴더 : 폴더내에 있는 파일 모두 실행
- shell Script 사용시 실행 퍼미션(허가권)을 줘야한다.
    - chmod 755 (파일명)
- crontab 파일 수정 후
    - systemctl restart cron (크론 데몬을 재시작)
- 시간 관련 명령어
    * timedatectl set-ntp 0 (시간을 수동으로 변경할 수 있게 해줌)
    * date 011503002030 (1월 15일 3시 2030년으로 시간 변경해줘)
    * rdate time.bora.net (타임서버에서 정확한 시간으로 변경)
        - apt install rdate

- at : 일회성 예약 명령어 : 한번 실행 후 소멸
```shell
at [시간]
$ at 3:00am tomorrow : 내일 새벽 3시
$ at 11:00pm January 30 : 1월 30일 오후 11시
$ at now +1 hours : 지금으로부터 한 시간 후

- 스크립트 명령어 입력하고 종료할 때 ctrl + d
$ at -l : 예약 확인 리스트 (작업번호 확인 가능)
$ atrm [작업번호] : 예약 취소
```  

### Pipe, Filter, Redirection
파이프 : 프로그램 2개를 연결하는 연결 통로 => `|`
- ex) `$ ls -l /etc | less`  

필터 : 걸러주는 명령어 => `grep` (주로 파이프와 같이 사용)  
- ex) `$ ps -ef | grep bash`

리디렉션 : 표준 입출력 방향을 변경 => `>` or `<` or `>>`

- ex) `$ ls -l > list.txt` (표준 출력내용을 파일에 쓰기, 덮어쓰기)
- ex) `$ ls -l >> list.txt` (표준 출력내용에서 이어쓰기)
- ex) `$ sort < list.txt` (list.txt 파일의 내용을 화면에 보여주기 (sort정렬한 후))  
- ex) `$ sort < list.txt > out.txt` (정렬한 내용을 out.txt에 쓰기)

### 프로세스, 데몬, 서비스
- Process : '하드디스크에 실행된 코드'(=프로그램)가 메모리에 로딩되어 활성화 상태에 있는 것
- PID : 활성화된 프로세스를 구분하기 위한 고유 번호
- 부모 프로세스, 자식 프로세스 : 프로세스를 실행하기 위해 필요한 종속관계(dependency)
    - 부모 프로세스를 종료시키면 자식 프로세스도 모두 종료

- `$ ps` : 현재 프로세스 상태 확인하는 명령어
    - ex) `$ps -ef | grep [찾고싶은 프로세스]`
- `$ kill`
    - ex ) `$ kill -9 [PID]` : 프로세스 강제 종료
- `$ fg` : 포어그라운드로 보내기 (가장 최근 실행한 프로세스)
- `$ bg` : 백그라운드로 보내기 (가장 최근 실행한 프로세스)
- `$ [명령어] $` : 백그라운드로 실행
- `$ jobs` : 현재 작업중인 목록보기
- `Ctrl + Z` : 일시정지(현재 실행중인 프로세스)

- Service : 
    - daemon : 백그라운드에서 가동되고 있는 서버 프로세스
    - `$ systemctl` : ex) `$ systemctl [start/stop/restart/status] [서비스 이름]`
    - 서비스 실행 스크립트 파일은 주로 /lib/systemd/system 폴더에 위치

### GRUB 부트 로더

`우분투 부팅시 처음 나오는 선택 화면`  

- 비밀번호 설정하거나 응급 복구에 사용할 수 있음
- 접속 후, e 키를 누르면, 실행 스크립트 편집 가능
    - 스크립트로 강제 부팅하여 비밀번호 변경 가능
    - GRUB 비밀번호 설정 가능  



## 네트워크 관련 설정과 명령어

### TCP/IP (Transmission Control Protocol/ Internet Protocol)

`TCP : 통신의 전송과 수신을 받는 프로토콜`  
`IP : 데이터 통신(패킷을 전달)을 다루는 프로토콜`  

- 프로토콜 : 컴퓨터끼리 네트워크 상으로 소통하는 약속  
- 호스트 네임, 도메인 네임
    - Host name : 각각의 네트워크 장치(컴퓨터, 서버, 라우터)를 식별하는 이름
    - Domain name : 인터넷에서 사용되는 계층적 주소 시스템
        - 최상위 도메인(Top-Level Domain, TLD) : ex) co.kr (co = company, kr = Korea)
        - 서브 도메인(SubDomain) : ex) blog.naver.com  

### IP 주소 (Internet Protocol Address)
`각 네트워크 장치(Lan Card, NIC : Network Interface Card)에 부여되는 중복되지 않는 유일한 주소`

- IPv4 : ex) 192.168.111.100(32bit)
- IPv6 : ex) FFFF:FFFF:FFFF:FFFF(128bit) => 주소 부족 문제를 해결하기 위해 사용
- Local host : 자기 자신을 가리키는 IP 주소 (ex)127.0.0.1

### 네트워크 주소

`같은 네트워크에 속해 있는 공통 주소`

- ex) 192.168.111.xxx/24 (앞의 24비트를 의미)  
    - 사설 네트워크(Private Network) : 외부와 분리된 별도의 네트워크

### 브로드캐스트 주소

`네트워크 내부의 모든 컴퓨터가 수신하는 주소`  

- ex) 192.168.111.xxx/24 (뒤의 xxx를 의미함)
    - C클래스의 경우 (192.168.111.255)

### 게이트웨이

`내부 네트워크가 외부로 연결되기 위한 장치`  

- 일반적인 게이트웨이 끝자리를 1,254 등을 많이 사용함.
- 네트워크 관리자가 임의로 결정할 수 있음.

> 역할
>> 프로토콜 변환  
>> 주소 변환(NAT : Network Address Translation)  
>> 보안, 방화벽, 라우팅

### 서브넷마스크(넷마스크)

`네트워크의 규모를 결정`

- A클래스 : 255.0.0.0/8
- B클래스 : 255.255.0.0/16
- C클래스 : 255.255.255.0/24
    - 256개의 IP 주소 중 네트워크 주소(192.168.111.0), 브로드캐스트 주소(192.168.111.255), 게이트웨이 주소(192.168.111.1)를 제외한 253대의 컴퓨터를 컴퓨터의 네트워크 내부에 연결

### DNS 서버 주소 (Domain Name Server)

`IP 주소를 URL(www.naver.com)로 변경해주는 서버 컴퓨터`

- 네임 서버가 잘못되어있으면 웹 사이트 접속 불가
- DHCP서버 (Dynamic Host Configuration Protocol)
    - IP 주소 및 기타 네트워크 설정을 자동으로 할당하고 관리  

### 네트워크 관련 명령어

- `$ nm-connection-editor`
    - 네트워크 매니저 (xwindow 그래픽 환경)
- `$ nmtui`
    - 네트워크 매니저 (Text User Interface Mode)
- `/etc/resolv.conf`
    - DNS 정보와 호스트 이름이 들어 있는 파일
- `$ nslookup`
    - DNS 서버 작동 테스트 하는 명령어
        - server
        - server [DNS서버 주소]
        - [도메인주소] : 인터넷 연결 확인
- 공인 DNS 서버
    - `8.8.8.8` : (구글에서 제공)
    - `168.126.63.1`, `168.126.63.2` : KT
    - `219.260.36.130` : SK
    - `164.126.101.2` : LG

