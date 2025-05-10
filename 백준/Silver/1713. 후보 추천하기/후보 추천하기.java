import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static class Frame {
        int id;
        int count;
        int time; // when it was added

        Frame(int id, int count, int time) {
            this.id = id;
            this.count = count;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        int totalRec = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Frame> frames = new ArrayList<>();
        Map<Integer, Frame> inFrame = new HashMap<>();
        int currentTime = 0;

        for (int i = 0; i < totalRec; i++) {
            int student = Integer.parseInt(st.nextToken());
            if (inFrame.containsKey(student)) {
                // already in frame: increment count
                Frame f = inFrame.get(student);
                f.count++;
            } else {
                if (frames.size() < N) {
                    // empty slot available
                    Frame f = new Frame(student, 1, currentTime++);
                    frames.add(f);
                    inFrame.put(student, f);
                } else {
                    // need to remove one
                    Frame toRemove = frames.stream()
                        .min(Comparator
                            .comparingInt((Frame f) -> f.count)
                            .thenComparingInt(f -> f.time))
                        .get();
                    // remove it
                    frames.remove(toRemove);
                    inFrame.remove(toRemove.id);

                    // add new student
                    Frame f = new Frame(student, 1, currentTime++);
                    frames.add(f);
                    inFrame.put(student, f);
                }
            }
        }

        // collect remaining student ids, sort, and output
        List<Integer> result = new ArrayList<>();
        for (Frame f : frames) {
            result.add(f.id);
        }
        Collections.sort(result);
        for (int id : result) {
            sb.append(id).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}
