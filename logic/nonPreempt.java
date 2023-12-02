package labFinal;

import java.util.*;

class Process {
    int at, bt, pri, pno;

    Process(int pno, int at, int bt, int pri) {
        this.pno = pno;
        this.pri = pri;
        this.at = at;
        this.bt = bt;
    }
}

class GChart {
    int pno, stime, ctime, wtime, ttime;
}

class MyComparator implements Comparator<Process> {
    public int compare(Process p1, Process p2) {
        if (p1.pri < p2.pri) // Lower values indicate higher priority
            return -1;
        else if (p1.pri == p2.pri && p1.at < p2.at)
            return -1;
        else
            return 1;
    }
}

class FindGanttChart {
    void findGc(LinkedList<Process> queue) {
        int time = 0;
        TreeSet<Process> priQueue = new TreeSet<>(new MyComparator());
        LinkedList<GChart> result = new LinkedList<>();

        while (!queue.isEmpty() || !priQueue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().at <= time) {
                priQueue.add(queue.removeFirst());
            }

            if (!priQueue.isEmpty()) {
                Process obj = priQueue.pollFirst();

                GChart gc1 = new GChart();
                gc1.pno = obj.pno;
                gc1.stime = time;
                time += obj.bt;
                gc1.ctime = time;
                gc1.ttime = gc1.ctime - obj.at;
                gc1.wtime = gc1.ttime - obj.bt;

                result.add(gc1);
            } else {
                time++; // Idle time when no process is available
            }
        }

        new ResultOutput(result);
    }
}

class ResultOutput {
    ResultOutput(LinkedList<GChart> resultList) {
        System.out.println("Gantt Chart:");
        System.out.println("Process_no\tArrival_Time\tBurst_Time\tComplete_Time\tTurn_Around_Time\tWaiting_Time");

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        for (GChart gc : resultList) {
            System.out.println(gc.pno + "\t\t" + gc.stime + "\t\t" + (gc.ctime - gc.stime) + "\t\t" + gc.ctime + "\t\t"
                    + gc.ttime + "\t\t\t" + gc.wtime);

            totalWaitingTime += gc.wtime;
            totalTurnAroundTime += gc.ttime;
        }

        double avgWaitingTime = (double) totalWaitingTime / resultList.size();
        double avgTurnAroundTime = (double) totalTurnAroundTime / resultList.size();

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turn Around Time: " + avgTurnAroundTime);
    }
}

public class nonPreempt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Process> processQueue = new LinkedList<>();

        System.out.println("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();

        for (int i = 1; i <= numProcesses; i++) {
            System.out.println("Enter details for Process " + i + ":");
            System.out.println("Arrival Time: ");
            int at = scanner.nextInt();
            System.out.println("Burst Time: ");
            int bt = scanner.nextInt();
            System.out.println("Priority: ");
            int pri = scanner.nextInt();

            processQueue.add(new Process(i, at, bt, pri));
        }

        scanner.close();

        FindGanttChart findGanttChart = new FindGanttChart();
        findGanttChart.findGc(processQueue);
    }
}
