# ⭐ 미션 : 로또 

---

## 📢프로그램 소개
> 간단한 로또 발매기  
- 로또 번호의 숫자 범위는 1-45
- 1개의 로또 발행 마다 중복되지 않은 6개 숫자 뽑음 
- 당첨 분호 추첨 시, 중복되지 않은 6개 + 보너스 번호 1개 뽑기
- 1~5등 당첨 기준과 금액
  - 1등 : 6개 일치 / 2,000,000,000원
  - 2등 : 5개 + 보너스 / 30,000,000원
  - 3등 : 5개 / 1,500,000원
  - 4등 : 4개 / 50,000원
  - 5등 : 3개 / 5,000원
- 사용자에게 로또 금액 입력받아 금액에 해당하는 만큼 로또를 발행함
- 로또 1장 가격 : 1000원
- 구매한 로또 번호와 당첨 번호 비교하여 당첨 내역 및 수익률 출력 후 로또 게임 종료
- 잘못된 값을 입력할 경우, IllegalArgumentException 발생하고 다시 입력받기 

## ✅ 구현 기능 목록
### 사용자에게 입력받기
**- 구입 금액 입력받기** 
  - 1000원 이하의 금액이 입력되면, 예외 발생시키고 다시 입력받기 
  - 1000원으로 나누어 떨어지지 않는 금액이 입력되면, 예외 발생시키고 다시 입력받기

**- 당첨 번호 입력받기** 
  - 쉼표를 기준으로 구분하기 
  - 범위에 맞지 않는 숫자가 오면, 예외 발생시키고 다시 입력받기
  - 6개의 번호가 입력되지 않으면, 예외 발생시키고 다시 입력받기 
  - 숫자와 쉼표가 아닌 문자가 있으면, 예외 발생시키고 다시 입력받기 
  - 중복된 숫자가 있으면, 예외 발생시키고 다시 입력받기 

**- 보너스 번호 입력받기**
  - 범위에 맞지 않는 숫자가 오면, 예외 발생시키고 다시 입력받기
  - 당첨 번호와 중복이면, 예외 발생시키고 다시 입력받기 

### 입력값 검증하기
**- 구입 금액 검증하기**
  - 1000원 이상인지 확인하기
  - 1000원으로 나누어 떨어지는지 확인하기 

**- 당첨 번호 검증하기**
  - 쉼표를 기준으로 자르기 
  - 6개 인지 확인하기 
  - 자른 문자가 숫자로만 구성되어 있느지 확인하기
  - 숫자가 로또 범위 안의 숫자인지 확인하기 
  - 중복된 번호가 아닌지 확인하기

**- 보너스 번호 검증하기** 
  - 숫자가 로또 범위 안의 숫자인지 확인하기
  - 중복된 번호가 아닌지 확인하기 

**- 위의 조건에 하나라도 부합하지 않으면, 바로 에러 발생시키기** 

### 로또 
**- 로또 구매하기** 
  - 구입 금액으로 살 수 있는 로또 갯수 계산하기
  - 갯수만큼 로또 생성하기 

**- 로또 생성하기** 
  - 1-45 사이의 난수 발생하기 
  - 중복된 수가 안나올때까지 난수 발생하기 
  - 난수를 로또에 저장하기 
  - 로또 번호 6개만 추첨하기 

**- 로또 당첨 유무 확인하기**
    - 3개,4개 일치는 각각 5등, 4등으로 설정하기
    - 5개 일치한 경우, 보너스 번호의 일치 유무에 따라 2등,3등 설정하기
    - 6개 일치한 경우 1등으로 설정하기

**- 당첨 통계 계산하기**
    - 모든 로또에 대하여 당첨 유무 확인하기
    - 총 수익 계산하기 

**- 수익률 계산하기** 
    - 계산 식 : 총 수익 / 구입 금액 * 100 
    - 소수점 둘째 자리에서 반올림 

### 사용자에게 출력하기 
**- 입력 안내 메시지 출력하기**
  - 구입 금액 입력 안내 메시지 출력하기
  - 당첨 번호 입력 안내 메시지 출력하기
  - 보너스 번호 입력 안내 메시지 출력하기 

**- 구입된 로또 번호 목록 출력하기** 
  - 구입한 로또 갯수 출력하기
  - 구입한 전체 로또 출력하기 

**- 당첨 통계 출력하기**
  - 각 등수별 일치 갯수 출력하기 
  - 총 수익률 출력하기 

## ✔️ 프로그래밍 요구 사항
- **Java Style Guide 지키기**
- **작은 단위로 자주 Commit 하기**
- **들여쓰기는 3 넘지 않도록 하기**
- **3항 연산자 쓰지 않기**
- **함수는 1가지 일만 하도록 작게 만들고 10라인은 넘지 않도록 하기**
- **배열 대신 컬렉션 사용하기**
- **이름을 통해 의도 들어내고 축약은 최대한 하지 않기**
- **관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 하기**
- **단위테스트로 의도한대로 정확하게 작동하는지 확보하기**
- **else 예약어 쓰지 않기**
- **연관성 있는 상수는 static final이 아닌 Enum 클래스 사용하여 프로그램 구현하기**
- **Java에서 제공하는 API 적극 활용하기**
- **입출력 담당하는 클래스 별도 구현하기**
- **객체의 상태 접근 제한하기**
    - **인스턴스 변수 접근 제어자는 private으로 설정하여 외부 통제 받지 않도록 하기**
- **객체는 객체답게 사용하기**
    - **객체가 스스로 처리할 수 있도록 구조 변경하기**
- **상수는 final 키워드 사용하기**
    - **연관된 상수는 또 enum클래스로 묶기**
- **인스턴스 변수 수 줄이도록 노력하기**
- **예외 케이스도 테스트하기**
- **테스트 코드를 위한 코드는 구현 코드에서 분리하기**
- ** 최종 코테에서 추가적인 요구 사항 있으면 적기** 