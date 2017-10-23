package d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by exitle on 22.10.17.
 */
public class Elevator {
    private int M;
    private int X;
    private int Y;
    private int maxX;
    private int maxY;
    private int peopleInQueue;
    private int queueInd;
    private int noOfRunStops;
    private int noOfStops;
    private List<Integer> floorsInQueue;


    public Elevator(){

    }

    public int solution(int[] A, int[] B, int M, int X, int Y){
        Elevator e = new Elevator(A, B, M, X, Y);
        return e.noOfStops;
    }

    public Elevator(int[] A, int[] B, int M, int X, int Y) {
        this.M = M;
        this.maxX = X;
        this.maxY = Y;
        this.X = 0;
        this.Y = 0;
        this.peopleInQueue = A.length;
        floorsInQueue = new ArrayList<>();
        this.queueInd = 0;
        this.noOfRunStops = 0;
        this.noOfStops = 1;

        while (this.peopleInQueue > 0) {
            int currPersonWeight = A[queueInd];
            int currPersonFloor = B[queueInd];

            if (hasCapacity(currPersonWeight)) {
                addPerson(currPersonWeight, currPersonFloor);
                peopleInQueue--;
                queueInd++;
                this.noOfRunStops = floorsInQueue.size();
            } else {
                this.noOfStops++;
                this.noOfStops += noOfRunStops;
                floorsInQueue.clear();
                this.X = 0;
                this.Y = 0;
            }
        }
        this.noOfStops += this.noOfRunStops;

    }

    private void addPerson(int A, int B) {
        this.X++;
        this.Y += A;
        if (this.floorsInQueue.indexOf(B) == -1) {
            this.floorsInQueue.add(B);
        }
    }

    private boolean hasCapacity(int A) {
        return this.Y + A <= this.maxY;
    }

}
