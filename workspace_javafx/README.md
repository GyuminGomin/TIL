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

# Javafx Scene Builder 설치 및 실행

1. https://gluonhq.com/products/scene-builder/ 다음 사이트에서 Scene Builder 21.0.0 설치
```
Product : Scene Builder
Platform : Windows Installer
```

2. SceneBuilder-21.0.0.msi 실행
```
폴더 경로 : C:\Users\admin\AppData\Local 아래에 (default 설정)
```

3. vscode에서 SceneBuilder extension for Visual Studio Extention 설치

4. Ctrl+Shift+P 를 눌러 Configure Scene Builder path를 클릭해 `C:\Users\admin\AppData\Local\SceneBuilder` 경로 아래의 Scene Builder.exe 파일을 설정해주면 끝

5. 마지막으로 생성한 fxml 파일을 우클릭해서 open in Scene Builder를 클릭하면 완료

# 참고
```
javaFX project를 vscode의 Extention을 설치해서 사용하면
1. Container을 설정해서 생성할 수 없다. (불편함)

따라서 eclipse에서 설치하는 방법을 기록

1. javafx 플러그인 설치
Path > Eclipse MarketPlace > Search
Find : javafx
e(fx)clipse 버전 설치
설치가 끝나면 재시작

Windows > Preferences > JavaFX
> SceneBuilder executable
> JavaFX 11 + SDK
이 두개의 경로를 설치한 경로로 설정해주면 됨

2. JavaFx Project 생성
끝
```

# UserSnippet 설정 

## javaFX UserSnippets 설정
`File > Preferences > Configure User Snippets`
1. 검색 창에 java 검색 후, 엔터
2. java.json 파일 설정

``` json
{
	"javafx" : {
		"prefix": "!javafx",
		"body" : [
			"import java.io.IOException;",
			"",
			"import javafx.application.Application;",
			"import javafx.fxml.FXMLLoader;",
			"import javafx.scene.Parent;",
			"import javafx.scene.Scene;",
			"import javafx.stage.Stage;",
			"",
			"public class AppMain extends Application {",
			"\t@Override",
			"\tpublic void start(Stage primaryStage) {",
			"\t\ttry {",
			"\t\t\tParent root = FXMLLoader.load(",
			"\t\t\t\tgetClass().getResource(\"$1\")",
			"\t\t\t);",
			"\t\t\tprimaryStage.setScene(new Scene(root));",
			"\t\t\tprimaryStage.show();",
			"\t\t} catch (IOException e) {",
			"\t\t\te.printStackTrace();",
			"\t\t}",
			"\t}"
		],
		"description": "Appmain 자동생성"
	}
}
```

## xml UserSnippets 설정
``` xml
{
	"anchor_pane" : {
		"prefix": "!anchor_pane",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.AnchorPane?>",
			"",
			"<AnchorPane xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</AnchorPane>",
		],
		"description": "anchor_pane 자동생성"
	},
	"border_pane" : {
		"prefix": "!border_pane",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.BorderPane?>",
			"",
			"<BorderPane xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</BorderPane>",
		],
		"description": "border_pane 자동생성"
	},
	"flow_pane" : {
		"prefix": "!flow_pane",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.FlowPane?>",
			"",
			"<FlowPane xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</FlowPane>",
		],
		"description": "flow_pane 자동생성"
	},
	"tile_pane" : {
		"prefix": "!tile_pane",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.TilePane?>",
			"",
			"<TilePane xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</TilePane>",
		],
		"description": "tile_pane 자동생성"
	},
	"grid_pane" : {
		"prefix": "!grid_pane",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.GridPane?>",
			"",
			"<GridPane xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</GridPane>",
		],
		"description": "grid_pane 자동생성"
	},
	"stack_pane" : {
		"prefix": "!stack_pane",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.StackPane?>",
			"",
			"<StackPane xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</StackPane>",
		],
		"description": "stack_pane 자동생성"
	},
	"hbox" : {
		"prefix": "!hbox",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.HBox?>",
			"",
			"<HBox xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</HBox>",
		],
		"description": "HBox 자동생성"
	},
	"vbox" : {
		"prefix": "!vbox",
		"body" : [
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"",
			"<?import javafx.scene.layout.VBox?>",
			"",
			"<VBox xmlns:fx=\"http://javafx.com/fxml/1\">"
				"\t<!-- TODO Add Nodes -->",
				"\t$1",
			"</VBox>",
		],
		"description": "VBox 자동생성"
	}
}
```