# CommuProject
하나씩 해보려고 만든 연습장.

# Stack
SpringBoot2
mysql
JPA

Sprint 1# BoardCRUD + Login 구현

# 1. 초기환경세팅
* security 가 있으면 security 로그인 화면으로 redirect 되서 rest api 가 먹지 않음.
clear

# 2. swagger-ui setting
* spring boot stater 2.6 이상 버전은 ControllerHandler에 매칭시키기 위한 전략의 기본 값 spring.mvc.pathmatch.matching-strategy 기본 값이 ant_path_matcher 에서 path_pattern_parser 로 변경됨.
그래서 디폴트경로를 다시 잡아줘야 작동. ( -> ant_path_matcher)

참고 : https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.6-Release-Notes#pathpattern-based-path-matching-strategy-for-spring-mvc
![image](https://user-images.githubusercontent.com/60733417/166150709-09c5c2a7-b36d-4289-a7fe-36ba628afcb3.png)


# 3. Board api 구현 (CRUD)

# 4. User api 구현 (CRUD)

# 5. 인증/인가 구현(Filter로 할지 시큐리티 적용할지 firebase?)

