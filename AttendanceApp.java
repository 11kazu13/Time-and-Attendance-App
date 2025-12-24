package exercise07;

import java.util.ArrayList;

/**
 * 勤怠管理アプリの実行クラス。
 */
public class AttendanceApp {

	public static void main(String[] args) {
		System.out.println("=== 勤怠管理アプリ ===\n");

		// 複数従業員をArrayListで管理
		ArrayList<AttendanceEmployee> employees = new ArrayList<>();

		// 従業員をインスタンス化
		AttendanceEmployee employee_1 = new AttendanceEmployee("井納", 1);
		AttendanceEmployee employee_2 = new AttendanceEmployee("田中", 2);

		// 出勤・退勤処理
		try {
			employee_1.clockIn("09:12");
			employee_2.clockIn("10:32");

			employee_1.clockOut("19:32");
			employee_2.clockOut("20:32");
		} catch (IllegalStateException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		// リストに追加
		employees.add(employee_1);
		employees.add(employee_2);

		// 勤怠状況の一覧を表示
		for (AttendanceEmployee employee : employees) {
			employee.showStatus();
		}
	}
}
