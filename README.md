# JPA_BASIC
JPA STUDY

WEEK-1

WEEK-2
기본 키 전략
- identity 전략
 identity(AUTO_INCREMENT) 전략은 DB에서 증가하는 기본키 값이다.
JPA에서 identity 전략은 엔티티의 식별자 값을 알아야하기 때문에 insert시 쓰기 지연을 사용할 수 없다.
entityManager.persist(entity); 시점에 바로 insert sql를 db에 commit한 후 식별자를 조회해온다.


- sequence 전략
  sequence전략은 DB에서 다음 식별자값을 조회한 후 엔티티에 적용해 db에 insert sql을 commit한다.
  그렇다면 DB에서 다음 식별자값을 조회하면서 1번 insert sql commit에서 1번으로 총 1번의 통신이 필요하다.
  이런 문제를 해결하기 위해 allocationSize 옵션을 이용해 성능을 최적화할 수 있다.
  메모리에 미리 식별자값을 allocationSize값 만큼 올려놓은 후 엔티티 insert시 식별자값을 메모리에서 불러온다.
  엔티티의 식별자값이 db sequence 값과 같아지면 다음 allocationSize만큼 미리 db에 증가시키고 메모리에서 식별자값을 불러온다.
