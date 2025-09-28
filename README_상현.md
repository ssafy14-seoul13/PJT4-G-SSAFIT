# PJT4-G-SSAFIT
팀장: 가은

팀원: 상현

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

1. Servlet, MVC 패턴, JSP, tomcat 등 웹 애플리케이션 개발에 필요한 기술과 tool을 활용하며 학습할 수 있었습니다. 이론으로 배웠던 내용을 직접 개발하며 체화할 수 있었습니다.
2. 스크립틀릿을 사용할 때 jar 파일 버전 등과 같은 개발 환경의 중요성을 체감했습니다. 낮은 버전을 사용했을 때 스크립틀릿이 작동하지 않았는데 3.0.1 버전의 파일을 적용했을 때 적동하는 것을 확인했습니다.
3. controller는 사용자 요청을 가장 먼저 받는 진입점, service는 실제 데이터 처리, 계산, 트랜잭션 관리 등 핵심적인 작업 수행, repository는 데이터베이스와 직접 상호작용하며 CRUD 기능 수행 등 Controller, Service, Repository의 역할에 대하여 명확히 알게 되었습니다.
