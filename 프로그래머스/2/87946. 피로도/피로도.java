class Solution {
    // 전체 던전 탐험 중 최대 탐험 횟수를 저장하는 전역 변수
    private int maxExploredDungeons = 0;

    /**
     * @param initialFatigue 유저의 시작 피로도
     * @param dungeons       각 던전의 정보 배열, [최소 필요 피로도, 소모 피로도] 형태
     * @return               탐험 가능한 최대 던전 수
     */
    public int solution(int initialFatigue, int[][] dungeons) {
        // 던전 방문 여부를 기록하는 배열 (중복 방문 방지를 위해 사용)
        boolean[] isVisited = new boolean[dungeons.length];
        
        // DFS 백트래킹 시작: 현재 피로도, 던전 정보, 방문 배열, 현재까지 탐험한 던전 수는 0
        exploreDungeons(initialFatigue, dungeons, isVisited, 0);
        
        // 전체 탐색 후 최대 탐험 가능한 던전 수를 반환
        return maxExploredDungeons;
    }

    /**
     * DFS 백트래킹을 이용하여 가능한 모든 던전 순서를 탐색하는 메서드
     *
     * @param currentFatigue 현재 남은 피로도
     * @param dungeons       각 던전의 정보 배열, [최소 필요 피로도, 소모 피로도]
     * @param isVisited      던전별 방문 여부 (이미 탐험한 던전은 건너뛰기 위해 사용)
     * @param exploredCount  현재까지 탐험한 던전의 수
     */
    private void exploreDungeons(int currentFatigue, int[][] dungeons, boolean[] isVisited, int exploredCount) {
        // 현재까지 탐험한 던전 수와 기존 최대값 비교하여 갱신
        maxExploredDungeons = Math.max(maxExploredDungeons, exploredCount);

        // 모든 던전에 대해 시도: 각 던전을 다음 탐험 대상으로 고려함
        for (int dungeonIndex = 0; dungeonIndex < dungeons.length; dungeonIndex++) {
            // 던전의 최소 필요 피로도와 소모 피로도를 읽어옴
            int requiredFatigue = dungeons[dungeonIndex][0];
            int fatigueCost = dungeons[dungeonIndex][1];

            // 아직 탐험하지 않았고, 현재 피로도가 해당 던전을 탐험하기에 충분하면
            if (!isVisited[dungeonIndex] && currentFatigue >= requiredFatigue) {
                // 해당 던전 방문 처리
                isVisited[dungeonIndex] = true;
                
                // 현재 던전을 탐험한 후 남은 피로도는 (currentFatigue - fatigueCost)
                // 탐험 횟수도 1 증가시킨 후 재귀 호출로 다음 던전을 탐색함
                exploreDungeons(currentFatigue - fatigueCost, dungeons, isVisited, exploredCount + 1);
                
                // 재귀 호출이 종료되면 백트래킹: 던전 방문 기록을 초기화하여 다른 경로도 탐색할 수 있게 함
                isVisited[dungeonIndex] = false;
            }
        }
    }
}
