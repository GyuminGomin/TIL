# 자바(JAVA)

참고 : <a href="https://www.tiobe.com/tiobe-index/">티오베 인덱스 : 프로그램 언어 순위</a>

## 개발 편의성 측면에 따른 분류
1. 저급 언어(Low-Level Language)
2. 고급 언어(High-Level Language)

## 실행 및 구현 방식에 따른 분류
1. 명령형 언어 (Imperative Language) : C
2. 함수형 언어 (Functional Language) : Kotlin
3. 논리형 언어 (Logic language) : PROLOG
4. 객체지향 언어 (Object-Oriented Language) : JAVA

## 빌드 방식에 따른 분류
1. 컴파일 언어 (Compile Language) : C, C++ -> 기계어로 변경된 다음에 실행되므로 사용자의 문제가 아닌 이상 컴파일된 파일에 대한 실행을 보장
2. 바이트 코드 언어 (Byte Code Language) : 컴파일을 통해 가상머신이 번역할 수 있는 Byte Code로 변환되며, ...

## 특징
1. 함수적 스타일 코딩 지원
2. 메모리를 자동으로 관리
3. 다양한 애플리케이션 개발 가능
4. 멀티 스레드 쉽게 구현 가능
5. 동적 로딩 지원
6. 막강한 오픈 소스 라이브러리 풍부

## JAVA 설치 방법

<a href="https://www.oracle.com/java/technologies/java-se-support-roadmap.html
">자바 개발 환경 구축 (자바 언어 지원 기간)</a>  
참고 : `LTS : Long Term Service` -> 장 기간 서비스 지원  

1. 사이트 접속 : <a href="https://www.oracle.com/kr/java/technologies/downloads/#jdk17-windows">OpenJDK-17버전 window 패키지 설치</a>

2. 회원가입 (oracle 회원)

3. exe파일 설치 (x64 Installer 파일 설치 - `17버전`)

4. 시스템 속성 (고급) > (환경 변수) > JAVA_HOME (설치한 bin폴더로 path 설정)

5. cmd(명령커맨드창) 열어서 `$ javac -version` 명령어 실행 후 에러가 안뜨면 확인 끝

## Eclipse

### 모듈의 의미
`8버전 이후 부터 만들어진 개념으로, 필요한 라이브러리만 넣어서 쓸 수 있게 해줌`


## 문법

### 디자인 패턴 (GOF디자인 패턴)
> - Singleton (싱글톤)  
`하나의 객체만 공유해서 사용할 수 있도록 강제하는 것`
- 외부에서 new 연산자로 생성할 수 없도록 private 접근 제한자를 앞에 붙임
- 클래스 자신의 타입으로 정적 필드 선언
- 외부에서 호출할 수 있는 정적 메소드 getInstance() 선언

<a href="./c06_access_modifier/singleton">싱글톤 패턴 참고</a>


