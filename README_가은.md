# PJT4-G-SSAFIT
팀장: 상현


팀원: 가은

## 1. 프로젝트 개요

SSAFIT은 사용자가 다양한 피트니스 영상을 시청하고 관리할 수 있는 웹 기반 서비스입니다. 사용자는 영상을 부위별로 검색하고, 상세 정보를 확인하며, 영상에 대한 리뷰를 작성하고 조회할 수 있습니다. Java Servlet/JSP를 기반으로 한 MVC 아키텍처를 구현하고, Tomcat 서버를 활용하여 클라이언트와 서버 간의 요청/응답 흐름을 제어했습니다. 각 기능마다 Controller, Service, DTO를 구분하여 유지보수 및 확장이 용이하게 하였습니다.


## 2. 주요 기능

### 👤 사용자 관리
-   **회원가입**: ID, 비밀번호, 이름, 이메일을 입력하여 새로운 계정을 생성합니다.
-   **로그인/로그아웃**: 세션 관리를 통해 로그인 상태를 유지하고, 로그아웃 기능을 제공합니다.
-   **회원 목록 조회**: 전체 등록된 사용자 목록을 확인할 수 있습니다.
-   **회원 정보 조회**: 특정 사용자의 상세 정보를 조회합니다.

### 🏋️ 영상 관리
-   **영상 목록 조회**: 전체 피트니스 영상 목록을 조회합니다.
-   **부위별 필터링**: '전신', '상체', '하체', '복부' 등 특정 운동 부위에 해당하는 영상만 필터링하여 조회할 수 있습니다.
-   **영상 상세 조회**: 특정 영상을 선택하면 상세 정보 페이지로 이동합니다.
-   **영상 등록, 수정, 삭제**: 새로운 영상 등록, 수정 사항 업데이트, 삭제할 수 있습니다.

### ✍️ 리뷰 관리
-   **리뷰 작성**: 영상 상세 페이지에서 해당 영상에 대한 리뷰를 작성하고 등록할 수 있습니다.
-   **리뷰 목록 조회**: 영상 상세 페이지에서 해당 영상에 달린 모든 리뷰를 확인할 수 있습니다.
-   **리뷰 삭제**: 자신이 작성한 리뷰를 삭제할 수 있습니다.


## 3. 프로젝트 구조

이 프로젝트는 기본적인 MVC(Model-View-Controller) 디자인 패턴을 따릅니다.

```
D:\SSAFY\PJT4-G-SSAFIT
└───src
    └───main
        ├───java
        │   └───ssafit
        │       ├───controller
        │       │   ├───SsafitReviewController.java
        │       │   ├───SsafitUserController.java
        │       │   └───SsafitVideoController.java
        │       └───model
        │           ├───dto
        │           │   ├───Review.java
        │           │   ├───User.java
        │           │   └───Video.java
        │           ├───repository
        │           │   ├───SsafitReviewRepository.java
        │           │   ├───SsafitReviewRepositoryImpl.java
        │           │   ├───SsafitUserRepository.java
        │           │   ├───SsafitUserRepositoryImpl.java
        │           │   ├───SsafitVideoRepository.java
        │           │   └───SsafitVideoRepositoryImpl.java
        │           └───service
        │               ├───SsafitReviewService.java
        │               ├───SsafitReviewServiceImpl.java
        │               ├───SsafitUserService.java
        │               ├───SsafitUserServiceImpl.java
        │               ├───SsafitVideoService.java
        │               └───SsafitVideoServiceImpl.java
        └───webapp
            ├───index.jsp
            └───WEB-INF
                ├───lib
                │   ├───jakarta.servlet.jsp.jstl-3.0.1.jar
                │   └───jakarta.servlet.jsp.jstl-api-3.0.0.jar
                └───ssafit
                    ├───header.jsp
                    ├───user_detail.jsp
                    ├───user_list.jsp
                    ├───user_login.jsp
                    ├───user_register.jsp
                    ├───video_detail.jsp
                    ├───video_list.jsp
                    └───video_register.jsp
```

-   **Controller**: `Ssafit*Controller.java` (Servlet)
    -   사용자의 HTTP 요청을 받아 비즈니스 로직을 호출하고, 결과를 JSP에 전달합니다.
-   **Service**: `Ssafit*Service.java`
    -   애플리케이션의 핵심 비즈니스 로직을 수행합니다.
-   **Repository**: `Ssafit*Repository.java`
    -   데이터베이스 역할을 하는 `*.json` 파일에서 데이터를 읽고 쓰는 역할을 담당합니다.
-   **DTO**: `User.java`, `Video.java`, `Review.java`
    -   계층 간 데이터 전송을 위한 객체입니다.
-   **View**: `*.jsp`
    -   Controller로부터 전달받은 모델 데이터를 사용하여 사용자에게 보여줄 UI를 렌더링합니다.


## 4. 개발 언어 및 사용 기술

-   **Backend**:
    -   Java
    -   Servlet, JSP
-   **Frontend**:
    -   JSP, JSTL (Jakarta Standard Tag Library)
    -   HTML, CSS, JavaScript
-   **Database**:
    -   JSON 파일을 데이터 저장소로 활용 (`video.json`, `review.json`)
-   **IDE**:
    -   Eclipse


## 5. 웹 애플리케이션 화면
<img width="2869" height="1415" alt="image" src="https://github.com/user-attachments/assets/86ed332a-6dcf-4e5a-aaaf-d6c2ea608028" />
<img width="2859" height="540" alt="image" src="https://github.com/user-attachments/assets/a250db8b-b1d3-4bfe-82ad-252134d0ba0f" />
<img width="483" height="106" alt="image" src="https://github.com/user-attachments/assets/ddf1de81-b58c-4d5f-b9c4-c906e322cbce" />
<img width="1538" height="859" alt="image" src="https://github.com/user-attachments/assets/24783dff-f61b-4e1b-bdc7-e5ef6b450e2a" />
<img width="502" height="997" alt="image" src="https://github.com/user-attachments/assets/b642cf55-f219-43f7-8dac-1a7a813b0562" />
<img width="826" height="828" alt="image" src="https://github.com/user-attachments/assets/9d02f232-781f-4e0a-a2e6-e8313ac01607" />

## 6. 소감

1. MVC 패턴 학습

   
 수업을 들을 때까지만 해도 MVC 패턴이 추상적으로 느껴지기만 했는데, 직접 JSP에서부터 Controller, Service, Repository 에 해당하는 기능을 설계하고 코드를 작성하니 이에 대해 제대로 이해할 수 있었다. 특히 처음 공부했을 때는 Service와 Repository Layer에서의 각 역할이 모호하다고 생각이 들었는데, Service는 데이터 무결성을 위해서 null값 또는 범위를 벗어나는 값 등을 체크해주고, Repository는 데이터 메모리와 직접 통신하면서 기본적인 CRUD를 진행하는 역할임을 새롭게 배우고 적용할 수 있었다. 이와 같이 Layer별로 역할을 분리하는 것이 개발자 입장에서 로직 오류를 찾아낼 때도 효율적이라는 것을 체감하였기 때문에, 앞으로 MVC 패턴의 중요성을 알고 잘 활용할 수 있을 것 같다.


2. 개발 환경 설정의 중요성

   
 프로젝트 개발을 진행하며 여러번의 오류를 겪었다. 가장 많았던 원인은 코드의 세세한 부분보다도, 서버/jakarta 등 기본 환경 설정에 관한 것이었다. Dynamic Web Project/maven 으로 프로젝트를 실행하는 것의 차이, jsp에서 JSTL을 사용하기 위한 taglib 의 중요성을 배울 수 있었다. 백앤드 개발에서 가장 기초적이면서도 중요한 환경 설정에 대해 더 배우고 연습해야겠다는 생각이 들었다.
