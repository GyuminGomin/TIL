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



## Object 클래스
### toString
<a href="./c09_API_class/a_object/toString">toString 예제</a>

### 객체 해시코드
Object에서 반환하는 해시코드는 주소를 정수로 변환해서 반환
<a href="./c09_API_class/a_object/hashcode">해시코드 예제</a>

### 얕은복사와 깊은복사
<a href="./c09_API_class/a_object/clone">얕은복사와 깊은복사 예제</a>

### 소멸자 finalize
<a href="./c09_API_class/a_object/finalize">finalize 예제</a>

### Object final
클래스 설계정보를 저장하고 있는 클래스의 클래스 : getClass
- 멀티스레드 하면서 나중에 notify, wait 알아볼것


## API Class

### UTF - 8 (참고)
가변형 4바이트로 문자 표현
`한국어는 3바이트`지만
기본적으로 JVM은 UTF - 16 으로 해석 ( 16비트 - 2바이트) 변환
그래서 char인 2바이트로 한국어 표현 가능

### String Class
<a href="./c09_API_class/b_string">String Class</a>

### Wrapper Class
<a href="./c09_API_class/c_wrapper">Wrapper Class</a>

## 예외처리
<a href="./c10_exception/">Exception</a>

## 제네릭
<a href="./c11_generic/">Generic</a>

## 컬렉션 프레임워크
<a href="./c12_collection_framework/">Collection FrameWork</a>

### List
<a href="./c12_collection_framework/c1_list/">List</a>

### Set
<a href="./c12_collection_framework/c2_set/">Set</a>

### Map
<a href="./c12_collection_framework/c3_map/">Map</a>

### Tree
<a href="./c12_collection_framework/c4_tree/">Tree</a>

### Stack
<a href="./c12_collection_framework/c5_stack/">Stack</a>

### Queue
<a href="./c12_collection_framework/c6_queue/">Queue</a>

## IO Stream
<a href="./c13_IO_stream">IO Stream</a>

## 중첩 클래스
<a href="./c14_nested_class_lambda/">nested class</a>

## 멀티쓰레드
<a href="./c15_multi_thread/">Multi Thread</a>

## Network
<a href="./c16_network/">Network</a>

### 자바로 만든 채팅 앱 (내부 네트워크 망 사용)
<a href="./c16_network/n3_chat">채팅 앱(IP 변경 필수)</a>

## Chat App (TCP)
<a href="./c17_chat_program_TCP/">채팅 앱(IP 변경 필수) - 추가 귓속말 기능, ThreadPool을 이용한 뻑남 방지</a>

