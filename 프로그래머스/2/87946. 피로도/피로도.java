class Solution {
    int maxCount = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return maxCount;
    }

    private void dfs(int k, int[][] dungeons, int count) {
        // 탐험한 던전 수로 최대값 갱신
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];  // 최소 필요 피로도
            int cost = dungeons[i][1];  // 소모 피로도

            // 아직 방문 안했고, 탐험 가능한 경우
            if (!visited[i] && k >= need) {
                visited[i] = true;
                dfs(k - cost, dungeons, count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
