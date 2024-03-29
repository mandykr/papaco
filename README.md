## Papaco
프로젝트의 리뷰어를 매칭해 Github 리포지토리를 기반으로 리뷰를 진행하도록 돕는 MSA 기반 서비스

### Event storming
![eventstorming.png](eventstorming.png)

## Subtrees
- [papaco-member-service](https://github.com/mandykr/papaco-member-service)
- [papaco-project-service](https://github.com/mandykr/papaco-project-service)
- [papaco-mate-service](https://github.com/mandykr/papaco-mate-service)
- [papaco-review-service](https://github.com/mandykr/papaco-review-service)
- [papaco-project-query-service](https://github.com/mandykr/papaco-project-query-service)

## 요구사항
- 깃헙 계정으로 로그인할 수 있다.
- 내 정보를 변경할 수 있다.
  - 경력, 기술스택을 입력할 수 있다.
  - 리뷰어로 등록할 수 있다.
- 개발자는 프로젝트를 등록할 수 있다.
  - 깃헙 리포지토리, 프로젝트 설명, 기술스택을 입력할 수 있다.
    - 리포지토리는 깃헙에서 조회한 목록에서 선택한다.
    - 프로젝트 설명은 마크다운 형식으로 작성한다.
- 개발자는 리뷰어를 선택하고 매칭을 제안할 수 있다.
- 리뷰어가 개발자의 매칭 제안을 수락하면 매칭된다.
- 개발자는 PR을 선택하고 리뷰를 요청할 수 있다.
  - PR은 깃헙에서 조회한 목록에서 선택한다.
  - 리뷰 요청은 리뷰어에게 알림으로 제공된다.
    - PR 코멘트를 함께 전달한다.
- 리뷰어가 깃헙에 리뷰를 남기고 리뷰를 완료할 수 있다.
  - 리뷰 완료는 개발자에게 알림으로 제공된다.
    - 코멘트를 함께 전달한다.
- 개발자와 리뷰어 중 한명이 매칭을 종료할 수 있다.
- 개발자는 내 프로젝트 목록을 조회할 수 있다.
- 개발자는 매칭되었던 리뷰어 목록을 조회할 수 있다.
- 리뷰어는 리뷰어로 활동한 프로젝트 목록을 조회할 수 있다.
