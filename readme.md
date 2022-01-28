Lee Cheol Ju

# 간단한 포트폴리오용 웹앱 소개

"웹 음성메모장"입니다. 자신의 메모를 써놓을 수 있으며, 그것을 다시 읽을 수 있는데, TTS를 통해 웹페이지에서 음성으로 읽어주는 기능이 있습니다.
지란지교데이터 개발부문인턴 채용 소식을 늦게나마 보고, '지원자격'에 있는 것을 증명하고자 사흘동안 만들어보았습니다.


# 확인해보기

제 서버에 만들어 가동해놓았습니다. 다음 주소로 들어가볼 수 있습니다.

http://ec2-13-125-82-118.ap-northeast-2.compute.amazonaws.com:8080/memo

# 지란지교데이터 자격요건과 현 포트폴리오

* 지원자격

    * JAVA Application 개발 경험
        
        대학 학부생시절부터 자바를 익혀왔으며, 여기 웹앱을 개발해낸 것 또한 그 연장이라 생각합니다.

    * JAVA Web Application 개발 경험
        
        자바 웹앱 개발에 널리 쓰이는 Spring Framework를 이용하여 만들어보았습니다. 이제 처음 다루게 되었지만 사흘동안 Examples들을 보며 배우며 간신히 개발해보았습니다.

* 우대사항

    * 직무 관련 전공

        저는 2020년 2월에 충남대학교 컴퓨터공학과를 졸업했습니다.

    * Python 프로그래밍 경험

        '텍스트 음성 듣기' 기능으로 파이썬을 사용합니다. 디렉토리 `python-tts`에 그 동작을 구현했습니다.

    * RDBMS 경험 (MySQL 등)

        메모를 읽어들이고 쓰고 지우기 위해 JDBC를 이용한 MySQL 접근을 합니다.

    * Linux 사용 경험
    
        웹앱 서버를 AWS EC2 리눅스 이미지 위에서 가동합니다.



# 빌드 방법

1. 필요 환경
    * Maven
    ```shell
    % mvn --version
    Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
    Maven home: /opt/maven
    Java version: 17.0.1, vendor: N/A, runtime: /usr/lib/jvm/java-17-openjdk
    Default locale: en_US, platform encoding: UTF-8
    OS name: "linux", version: "5.16.2-arch1-1", arch: "amd64", family: "unix"
    ```
    * Spring Framework
    ```shell
    % spring --version
    Spring CLI v2.6.2
    ```

    * Python 3
    ```shell
    % python --version
    Python 3.10.2
    ```

    * MySQL (혹은 MariaDB)
    ```shell
    % mysql --version
    mysql  Ver 15.1 Distrib 10.6.5-MariaDB, for Linux (x86_64) using readline 5.1
    ```

2. 데이터베이스 준비

    계정: ID=`cheoldb` / PW=`cheolcheol`
    데이터베이스 이름: `cheoldemo`
    테이블: `memo` 한 개 있음
    ```sql
    MariaDB [cheoldemo]> describe memo;
    +---------+--------------+------+-----+---------------------+----------------+
    | Field   | Type         | Null | Key | Default             | Extra          |
    +---------+--------------+------+-----+---------------------+----------------+
    | id      | int(11)      | NO   | PRI | NULL                | auto_increment |
    | writer  | varchar(63)  | NO   |     | NULL                |                |
    | content | varchar(255) | NO   |     | NULL                |                |
    | regtime | timestamp    | NO   |     | current_timestamp() |                |
    +---------+--------------+------+-----+---------------------+----------------+
    ```

3. 소스
`https://github.com/cjfwn2000/recruit_jiran`에 소스가 있습니다. 
    ```shell
    git clone https://github.com/cjfwn2000/recruit_jiran
    ```

4. 빌드
    ```shell
    % mvn install
    ```
    디렉토리 `target`에 .jar 파일이 만들어집니다.

5. 실행
    ```shell
    java -jar mydemo-0.0.1-SNAPSHOT.jar
    ```

