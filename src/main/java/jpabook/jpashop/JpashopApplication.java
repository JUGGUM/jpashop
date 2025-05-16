package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

}
/***
 * └── com.example.project
 *     ├── user             ← 도메인 이름 (Bounded Context 단위)
 *     │   ├── domain       ← 도메인 계층
 *     │   │   ├── entity   ← 도메인 엔티티 (JPA @Entity 포함)
 *     │   │   ├── repository (Interface만)
 *     │   │   ├── model    ← VO, enum 등 도메인 모델
 *     │   │   └── service  ← 도메인 서비스 (Business Logic 중심)
 *     │   ├── application  ← 애플리케이션 계층
 *     │   │   └── service  ← 유스케이스 실행, 트랜잭션 제어
 *     │   ├── infrastructure ← JPA 구현체 등 외부 시스템 연동
 *     │   │   └── repository ← repository 구현체 (@Repository, JPA 사용)
 *     │   └── presentation ← Web, REST API 등 외부 인터페이스
 *     │       └── controller
 *
 *
 *user
 * ├── domain
 * │   ├── entity
 * │   │   └── User.java
 * │   ├── model
 * │   │   └── UserStatus.java (enum)
 * │   ├── repository
 * │   │   └── UserRepository.java (interface)
 * │   └── service
 * │       └── UserDomainService.java
 * ├── application
 * │   └── service
 * │       └── UserSignupService.java
 * ├── infrastructure
 * │   └── repository
 * │       └── JpaUserRepository.java
 ├── presentation
 │   ├── controller
 │   └── dto
 │       ├── UserSignupRequest.java
 │       └── UserResponse.java
 *
 */