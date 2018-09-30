package microsoft;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {

	public static void main(String args[]) {

		Schedule s1 = new Schedule(10, 18);
		Schedule s2 = new Schedule(13, 16);
		Schedule s3 = new Schedule(17, 18);
		Schedule s4 = new Schedule(19, 20);

		Schedule[] meetings = { s4, s3, s2, s1 };

		System.out.println(countMinimumNumberOfRooms(meetings));

	}

	private static int countMinimumNumberOfRooms(Schedule[] meetings) {
		PriorityQueue<Schedule> pq = new PriorityQueue<>(new Comparator<Schedule>() {
			@Override
			public int compare(Schedule o1, Schedule o2) {
				// TODO Auto-generated method stub
				return o1.startTime - o2.startTime;
			}
		});

		for (Schedule s : meetings) {
			pq.add(s);
		}
		int count = 1;
		while (!pq.isEmpty()) {
			Schedule meeting1 = pq.poll();
			Schedule meeting2 = pq.peek();
			if (meeting2 != null && meeting2.startTime < meeting1.endTime) {
				count++;
			}
		}
		return count;
	}

}

class Schedule {
	int startTime;
	int endTime;

	public Schedule(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
