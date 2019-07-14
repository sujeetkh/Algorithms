package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

class SortByFinishTime implements Comparator<Activity> {
	public int compare(Activity a, Activity b) {
		return a.finishTime - b.finishTime;
	}
}

public class ActivitySelection {
	Activity[] arr;

	ActivitySelection(Activity[] arr) {
		this.arr = arr;
	}

	void sort() {
		Arrays.sort(arr, new SortByFinishTime());
	}

	public int maximumNumberOfActivities() {
		if (arr.length == 0)
			return 0;
		int res = 1;
		int lastSelectedActivity = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i].startTime > arr[lastSelectedActivity].finishTime) {
				res++;
				lastSelectedActivity = i;
			}
		}
		return res;
	}

	void print() {
		for (Activity act : arr)
			System.out.println(act.startTime + " " + act.finishTime);
	}

	public static void main(String[] args) {
		Activity[] arr = new Activity[5];
		arr[0] = new Activity(8, 9);
		arr[1] = new Activity(3, 4);
		arr[2] = new Activity(0, 6);
		arr[3] = new Activity(5, 7);
		arr[4] = new Activity(1, 2);

		ActivitySelection acs = new ActivitySelection(arr);
		acs.sort();
		System.out.println("Activities after sorting by Finished Time: ");
		acs.print();
		System.out.println("Maximum Number of activities which can be scheduled: "+acs.maximumNumberOfActivities());

	}
}
