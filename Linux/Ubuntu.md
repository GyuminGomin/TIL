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