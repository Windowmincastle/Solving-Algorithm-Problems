import java.util.*;

class Solution {

    static class Action {
        String uid;
        String type; // "Enter" or "Leave"

        Action(String uid, String type) {
            this.uid = uid;
            this.type = type;
        }
    }

    public String[] solution(String[] record) {

        // uid -> nickname
        Map<String, String> nicknameMap = new HashMap<>();

        // Enter, Leave 기록 저장
        List<Action> actions = new ArrayList<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String uid = parts[1];

            if (command.equals("Enter")) {
                String nickname = parts[2];
                nicknameMap.put(uid, nickname);
                actions.add(new Action(uid, "Enter"));
            } 
            else if (command.equals("Leave")) {
                actions.add(new Action(uid, "Leave"));
            } 
            else if (command.equals("Change")) {
                String nickname = parts[2];
                nicknameMap.put(uid, nickname);
            }
        }

        String[] answer = new String[actions.size()];
        int idx = 0;

        for (Action action : actions) {
            String nickname = nicknameMap.get(action.uid);
            if (action.type.equals("Enter")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
