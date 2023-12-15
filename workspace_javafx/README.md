# JAVA로 앱 만들기

1. https://gluonhq.com/products/javafx/ 다음 사이트에서 실행하고 있는 java 버전과 동일하게 (현재는 17버전) 설치
```
JavaFX Version : 17.0.9 [LTS]
Operating System : Windows
Architecture : x64
Type : SDK
```
2. C:/Program Files/Java 폴더 아래에 압축 해제
3. 현재 프로젝트의 JAVA PROJECT에서 Configure ClassPath에서 javafx-sdk-17.0.9/lib/아래에 있는 jar파일을 전부 다 설정
4. launch.json 파일 설정
``` json
{
    "configurations": [

        {
            "type": "java",
            "name": "JavaFX Testing",
            "request": "launch",
            "vmArgs": "--module-path 'C:\\Program Files\\Java\\javafx-sdk-17.0.9\\lib' --add-modules javafx.controls,javafx.fxml"
            
        }
    ] 
}

// vmArgs는 settings.json 파일에서 필요한 모듈만 사용할 수 있게 설정 할 수 있음
```

