# 실습 방법

##

```
1. VSCode Extension 설치
    - Community Server Connectors (하나만 설치하면 됨)
2. Community Server Connectors Java Home 설정
    - 사용자 환경 설정에 JAVA_HOME(jdk 경로) 추가
3. 서버 추가
    - SERVERS 페이지의 오른쪽을 보면 + 버튼이 존재함
    - 클릭후, 기존Tomcat 서버가 있다면, No, use server on Disk를 선택하고, 없다면 새롭게 추가
    - 저는 기존에 존재하는 폴더가 있기에 그쪽으로 설정해줌

이제 테스트 하면 되긴 한데, server.xml 설정과 새로운 프로젝트를 파서 경로를 지정해주는 방식은 eclipse와 달라서 받아오기는 할 수 없을 것 같습니다.

아예 다른 방식으로 구동됨
```