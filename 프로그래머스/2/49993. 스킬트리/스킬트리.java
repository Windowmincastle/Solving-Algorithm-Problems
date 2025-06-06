class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for (String tree : skill_trees) {
            int idx = 0;
            boolean valid = true;

            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                int pos = skill.indexOf(c);

                // 해당 스킬이 선행 스킬 순서에 포함된 경우
                if (pos != -1) {
                    if (pos == idx) {
                        // 올바른 순서대로 배웠다면 다음 선행 스킬로 이동
                        idx++;
                    } else {
                        // 순서가 틀리면 유효하지 않음
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}
