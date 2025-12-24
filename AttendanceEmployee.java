package exercise07;

/**
 * 出退勤情報を管理するクラス。Employeeクラスを継承。
 */
public class AttendanceEmployee extends Employee {
	private String startTime;
	private String endTime;
	private WorkStatus status;

	/**
	 * コンストラクタ：従業員名とIDを指定し、初期状態は「未出勤」
	 */
	public AttendanceEmployee(String name, int id) {
		super(name, id);
		this.status = WorkStatus.NOT_WORKING;
		this.endTime = "-";
		this.startTime = "-";
	}

	/**
	 * 出勤処理：すでに出勤済みまたは退勤済みの場合は例外をスロー。
	 * @param time 出勤時刻（"HH:mm"形式の文字列）
	 */
	public void clockIn(String time) {
		if (this.status == WorkStatus.WORKING || this.status == WorkStatus.LEFT) {
			throw new IllegalStateException("ステータスエラー");
		}

		if (!time.matches("\\d{2}:\\d{2}")) {
			throw new IllegalArgumentException("時刻の形式が違います");
		}
		this.startTime = time;

		this.status = WorkStatus.WORKING;
	}

	/**
	 * 退勤処理：未出勤の状態で退勤しようとすると例外をスロー。
	 * @param time 退勤時刻（"HH:mm"形式の文字列）
	 */
	public void clockOut(String time) {
		if (this.status == WorkStatus.NOT_WORKING) {
			throw new IllegalStateException("ステータスエラー");
		}
		if (!time.matches("\\d{2}:\\d{2}")) {
			throw new IllegalArgumentException("時刻の形式が違います");
		}

		if (time.compareTo(this.startTime) < 0) {
			throw new IllegalArgumentException("不正な退勤時刻です");
		}
		this.endTime = time;

		this.status = WorkStatus.LEFT;
	}

	/**
	 * 勤怠情報をコンソールに出力する
	 */
	public void showStatus() {
		System.out.printf("ID: %d, 名前: %s, 状態: %s, 出勤: %s, 退勤: %s\n",
				getEmployeeId(), getName(), getStatus(), getStartTime(), getEndTime());
	}

	// Getter（ステータス）
	public WorkStatus getStatus() {
		return this.status;
	}

	// Getter（出勤時刻）
	public String getStartTime() {
		return this.startTime;
	}

	// Getter（退勤時刻）
	public String getEndTime() {
		return this.endTime;
	}
}
