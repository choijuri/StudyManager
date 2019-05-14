-- category
INSERT INTO category(category_id, category_name) VALUES(1,'IT');
INSERT INTO category(category_id, category_name) VALUES(2,'어학');
INSERT INTO category(category_id, category_name) VALUES(3,'취업');
INSERT INTO category(category_id, category_name) VALUES(4,'기타');

-- user
INSERT INTO user( email, passwd, phone, name) VALUES('urstory@gmail.com', '{bcrypt}$2a$10$NTBRmbStBAZ/ErbZFoWquOqeCKIKaRNRVvU./GOMQ.SnmxZs1dVuG' , '01022523645', '토토');
INSERT INTO user( email, passwd, phone, name) VALUES('mj123@gmail.com', '{bcrypt}$2a$10$NTBRmbStBAZ/ErbZFoWquOqeCKIKaRNRVvU./GOMQ.SnmxZs1dVuG' , '01022458562', '민준');
INSERT INTO user( email, passwd, phone, name) VALUES('sj123@gmail.com', '{bcrypt}$2a$10$NTBRmbStBAZ/ErbZFoWquOqeCKIKaRNRVvU./GOMQ.SnmxZs1dVuG' , '01036158562', '서준');
INSERT INTO user( email, passwd, phone, name) VALUES('jh123@gmail.com', '{bcrypt}$2a$10$NTBRmbStBAZ/ErbZFoWquOqeCKIKaRNRVvU./GOMQ.SnmxZs1dVuG' , '01022457562', '지훈');
INSERT INTO user( email, passwd, phone, name) VALUES('yw123@gmail.com', '{bcrypt}$2a$10$NTBRmbStBAZ/ErbZFoWquOqeCKIKaRNRVvU./GOMQ.SnmxZs1dVuG' , '01022457545', '연우');


-- study
INSERT INTO study(study_name, study_information, category_id)
VALUES('JAVA 스터디', 'JAVA 기본 개념에 대해 공부하는 스터디', 1);
INSERT INTO study(study_name, study_information, category_id)
VALUES('알고리즘 스터디', '알고리즘 문제를 풀고 공부하는 스터디', 1);
INSERT INTO study(study_name, study_information, category_id)
VALUES('토익 스터디', '토익 공부를 같이 하는 스터디', 2);
INSERT INTO study(study_name, study_information, category_id)
VALUES('면접 스터디', '면접을 대비하는 스터디', 3);
INSERT INTO study(study_name, study_information, category_id)
VALUES('1일 1시간 운동하기', '하루에 한 시간 씩 같이 운동하는 스터디', 4);

-- curriculum
INSERT INTO curriculum(study_id, curriculum_content) VALUES(4,'객체지향');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(4,'HTTP프로토콜');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(4,'멀티쓰레드');

INSERT INTO curriculum(study_id, curriculum_content) VALUES(2,'스택/큐');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(2,'해시');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(2,'정렬');

INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 01');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 02');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 03');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 04');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 05');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 06');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 07');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 08');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 09');
INSERT INTO curriculum(study_id, curriculum_content) VALUES(3,'Test 10');

-- curriculum_detail
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(1, '객체지향이란 무엇인가');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(2, 'HTTP프로토콜이란 무엇인가');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(3, '멀티쓰레드란 무엇인가');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(3, '멀티쓰레드의 장단점');

INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(4, '프로그래머스 쇠막대기');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(4, '프로그래머스 주식가격');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(5, '프로그래머스 완주하지 못한 선수');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(5, '프로그래머스 전화번호 목록');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(6, '가장 큰 수');

INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(7, '단어 day01-05');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(7, 'Listening test 01');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(7, 'Reading test 01');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(8, '단어 day06-10');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(8, 'Listening test 02');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(8, 'Reading test 02');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(9, '단어 day11-15');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(9, 'Listening test 03');
INSERT INTO curriculum_detail(curriculum_id, curriculum_detail_content) VALUES(9, 'Reading test 03');


-- study_content
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(1,2,'객체 지향 프로그래밍이란 컴퓨터 프로그래밍 패러다임중 하나로, 프로그래밍에서 필요한 데이터를 공통된 특징을 파악하여 정의한 설계에 따라 상태와 행위를 가진 객체를 만들고 그 객체들 간의 서로 밀접하게 관련이 있는 상호작용을 통해 로직을 구성하는 프로그래밍 방법이다.');
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(2,2,'HTTP는 Hyper Text Transfer Protocol의 줄임말로 브라우저가 웹 서버와 통신하기 위해 사용하는 주요 통신규약이다. TCP/IP 80번 포트를 사용한다. 브라우저가 요청 메시지를 보내면 서버가 요청의 결과인 응답 코드가 포함된 응답메시지를 회신해준다. 요청과 응답 처리 이후에 연결이 끊기기 때문에 상태는 기록해두지 않아 비상태 프로토콜 이라고도 부른다.');
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(3,4,'하나의 프로세스를 다수의 실행 단위로 구분하여 자원을 공유하고 자원의 생성과 관리의 중복성을 최소화하여 수행능력을 향상시키는 것으로 쓰레드간 스택영역을 비공유하고 데이터와 힙 영역을 공유하여 데이터 교환에 용이하다. 하지만 공유하는 자원에 대해 동시에 접근하는 부분은 동기화를 통해 작업 처리순서나 접근에 대헤 컨트롤 해야하며 과도한 락이 걸릴 경우 성능이 저하될 가능성이 크기 때문에 동기화를 해야 할 공유자원에 대한 많은 고민이 필요하다.');
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(4,1,'장점: 프로세스를 생성하는 것보다 쓰레드를 생성하는 것이 더 경제적이다, 응답성이 좋다, 자원 공유를 효율적으로 할 수 있다, 작업이 분리되어 코드가 간결해진다. 단점: 동기화에 주의해야한다(synchronization), 교착상태 (dead-lock)이 발생하지 않도록 해야한다, 각 쓰레드가 고르게 실행되도록 해야한다.');

INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(5, 2, 'import java.util.Stack;

class Solution {
       public int solution(String arrangement) {
        int answer = 0;
        Stack arr = new Stack();
        int stick = 0;

        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == ''('') {
                if (arrangement.charAt(i + 1) != '')'') {
                    arr.push(arrangement.charAt(i));
                    stick++;
                } else {
                    answer += arr.size();
                }
            } else if (arrangement.charAt(i) == '')'') {
                if(arrangement.charAt(i-1) =='')''){
                    if (arr.size() != 0) {
                        arr.pop();
                    }
                }
            }
        }
        answer += stick;
        return answer;
    }
}');
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(6, 3, 'class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length - 1; i++){
            answer[i] = 1;
            for(int j = i + 1; j < prices.length - 1; j++){
                if(prices[i] > prices[j]){
                   break;
                }else{
                   answer[i] += 1;
                }
            }
        }
        return answer;
}
}');
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(7, 2,'import java.util.*;
-- --
class Solution {
       public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++){
            if(!map.containsKey(participant[i])){
                map.put(participant[i],1);
            }else {
                map.replace(participant[i],map.get(participant[i]) + 1);
            }
        }

        for (int i = 0; i < completion.length; i++){
            if (map.get(completion[i]) == 1){
                map.remove(completion[i]);
            } else {
                map.replace(completion[i],map.get(completion[i]) - 1);
            }
        }
        for(String s : map.keySet()){
           answer = s;
        }
        return answer;
    }
}');
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(8, 2, 'import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].length() >= phone_book[i].length()){
                    if (phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])) {
                        answer = false;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}');
INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(9, 5, 'import java.util.*;

class Solution {
 public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (list.get(0).equals("0")){
            return "0";
        }
        for (int i = 0; i < list.size(); i++){
            answer += list.get(i);
        }
        return answer;
    }
}');

-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(10);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(11);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(12);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(13);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(14);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(15);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(16);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(17);
-- INSERT INTO study_content(curriculum_detail_id, writer, content) VALUES(18);


--comment
INSERT INTO comment(study_content_id, comment_content, writer) VALUES(1,'내용이 부족한것 같아 다음에 모일 때 추가 할 내용에 대해서 다같이 생각해보고 이야기 나누면 좋을 것 같아요! ',2);

-- INSERT INTO comment(study_content_id , comment_content, writer) VALUES(1, '잘 정리된 문서를 봐도 어렵네요…bb 역시 전 멀었어요…' , 'jh123@gmail.com' );
-- INSERT INTO comment(study_content_id , comment_content, writer) VALUES(1, '유익한 스터디 내용이었습니다. 감사합니다' , 'yw123@gmail.com' );
-- INSERT INTO comment(study_content_id , comment_content, writer) VALUES(2, '내용이 부족한것 같아 다음에 모일 때 추가 할 내용에 대해서 다같이 생각해보고 이야기 나누면 좋을 것 같아요! ' , 'mj123@gmail.com' );
-- INSERT INTO comment(study_content_id , comment_content, writer) VALUES(3, '잘 정리해 주셔서 감사합니다. ' , 'sj123@gmail.com' );
-- INSERT INTO comment(study_content_id , comment_content, writer) VALUES(4, ' 파이팅!!!' , 'mj123@gmail.com' );


--message
INSERT INTO message(message_id , receiver_id, sender_id , message_content)
VALUES(1, 4, 5 , '참가를 요청합니다.');
INSERT INTO message(message_id , receiver_id, sender_id , message_content)
VALUES(2, 4, 5 , '받아주세요!!');
INSERT INTO message(message_id , receiver_id, sender_id , message_content)
VALUES(3, 4, 5 , '답장 기다릴게요');
INSERT INTO message(message_id , receiver_id, sender_id , message_content)
VALUES(4, 3, 2 , '안녕하세요! 스터디 내용 문의 드리고 싶어서 연락드려요! 혹시 위치는 그쪽 지역밖에 안되는 건가요??');
INSERT INTO message(message_id , receiver_id, sender_id , message_content)
VALUES(5 , 2, 3 , '이미 모집된 인원이 있어 위치변경은 힘들 것 같은데…저 혼자 바꾸고 통보하기 민감한 내용이라 어려울 것 같습니다~~');
INSERT INTO message(message_id , receiver_id, sender_id , message_content)
VALUES(6, 3, 2 , '네 알겠습니다. ');


--recruitStudy
INSERT INTO recruit_study (recruit_id , recruit_name, location , recruit_number, recruit_content, user_id, category_id)
VALUES(1, 'java스터디 모집합니다. ' , '서울특별시 강남구' , 5 , 'java내용에 대해서 같이 공부하실 분 모집합니다 ', 4 , 1);
INSERT INTO recruit_study (recruit_id , recruit_name, location , recruit_number, recruit_content, user_id, category_id)
VALUES(2, '토익스터디 모집합니다. ' , '서울특별시 서초구' , 6 , '토익 점수 800점 목표로 공부하 실 분 모집합니다. ', 5 , 3);
INSERT INTO recruit_study (recruit_id , recruit_name, location , recruit_number, recruit_content, user_id, category_id)
VALUES(3, '개발자 면접 스터디 모집합니다. ' , '서울특별시 종로구' , 4 , '면접 준비로 힘들어서 함께 하실분들 모집해요!', 3 , 2);
INSERT INTO recruit_study (recruit_id , recruit_name, location , recruit_number, recruit_content, user_id, category_id)
VALUES(4, ' 운동량 인증 하실분들 모집합니다. ' , '서울특별시 노원구' , 10 , '매일 목표를 인증하면서 운동하실 분 모집합니다', 2 , 4);
INSERT INTO recruit_study (recruit_id , recruit_name, location , recruit_number, recruit_content, user_id, category_id)
VALUES(5, '주니어 개발자 위한 스터디' , '서울특별시 강남구' , 5 , '힘든 직장생활에 서로 도움을 줄 수 있도록 도와주세요!!', 4 , 1);


--studyUser
INSERT INTO study_user(user_id,study_id,user_role) VALUES(1,1,'admin');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(2,1,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(4,1,'user');

INSERT INTO study_user(user_id,study_id,user_role) VALUES(2,2,'admin');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(3,2,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(4,2,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(5,2,'user');

INSERT INTO study_user(user_id,study_id,user_role) VALUES(5,3,'admin');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(3,3,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(2,3,'user');

INSERT INTO study_user(user_id,study_id,user_role) VALUES(1,4,'admin');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(3,4,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(5,4,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(2,4,'user');

INSERT INTO study_user(user_id,study_id,user_role) VALUES(4,5,'admin');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(1,5,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(3,5,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(2,5,'user');
INSERT INTO study_user(user_id,study_id,user_role) VALUES(5,5,'user');
