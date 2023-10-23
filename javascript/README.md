<h1>자바 스크립트</h1>

<a href="#javascript" style="font-size: 20px; ">첫번째</a>  
<a href="#java" style="">두번째</a>  

[마크다운 시트](https://www.markdownguide.org/cheat-sheet/)


CPU(Central Processing Unit) : 연산 장치

RAM(Random Access Memory) : 주 기억 장치

SSD(Solid-State Device) : 보조 기억 장치

Compiler, Interpreter : 사람에 가까운 문서로 작성해놓은 언어를 기계어로 변경해주어 컴퓨터가 해석할 수 있게 해주는 것

ecma 인터내셔널 : 
cf. ecmaScript == javaScript


Browser Object Model 안에 Document Object Model이 들어가 있음 (BOM -> DOM)

<h2 id="javascript">javaScirpt Basic Form</h2>

<h3>표현식과 문장</h3>

<pre>&lt;javascript&gt;
<code>
var name = "" + "" + "";
</code>
</pre>

var : 변수를 사용할 거라고 알려주는 타입

name : 변수 (메모리에 저장되는 값을 저장)

= : 대입 연산자 (오른쪽에서 계산된 연산을 좌쪽에 대입시킨다.)

; : 세미콜론 (실행문을 끝내는 것)

<h3>식별자</h3>

특수문자 _, $만 사용 가능  
숫자로 시작하면 안됨  
공백은 입력하면 안됨   
키워드는 사용하지 않음   
1. 생성자 함수의 이름은 반드시 대문자로 시작
2. 변수, 인스턴스, 함수, 메소드의 이름은 항상 소문자로 시작
3. 여러 단어로 된 식별자는 각 단어의 첫 글자를 대문자로 함.

<h3>hoisting</h3>

함수나 변수가 Script문의 최상단으로 올라가는 js의 자율성  
var에서 발생할 수 있는 문제 때문에 let, const 선언부가 만들어짐 2016년 js6부터

<h3>이스케이프 문자</h3>

\t 수평 탭  
\' 작은 따옴표  
\n 행 바꿈  
\" 큰 따옴표  
\\\ 역 슬래시

<h2 id="">DOM</h2>
<h3>1개의 문서 객체 선택</h3>

document.getElementById()  
document.querySelector()

<h3>여러 개의 문서 객체 선택</h3>

document.getElementsByName(이름)
document.getElementsByTag(태그이름)
document.getElementsByClassName(클래스)
document.querySelectorAll(선택자)

<h3>글자 조작</h3>

textContent  
- 일반 글자 형식의 문서 객체 내부 글자
innerHTML  
- HTML 형식의 문서 객체 내부 글자  
innerText  
- 텍스트 컨텐츠만  

<h3>속성 조작</h3>

문자열 `data-`로 시작하는 사용자 지정 속성은 반드시 속성 조작 메소드를 사용
setAttribute(속성 이름, 속성 값)  
getAttribute(속성 이름)  
ex) document.body.setAttribute('data-custom', 'value');  

dataset (사용자 정의형 속성을 제어할 수 있게 제공 되는 속성)
ex)  
```HTML
    <image src="#" data-pom = "" data-anything = ""/>

    -> 사용

    image.dataset.dataPom = 불라불라
    image.dataset.dataAnything = 불라불라
```

<h3>시간 조작</h3>

Date  

date = new Date(); -> 현재 시간

<h3>이벤트 조작</h3>