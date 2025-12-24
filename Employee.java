package exercise07;

/**
 * 従業員の基本情報を管理するクラス。
 */
public class Employee {
	private String name;
	private int employeeId;

	// デフォルトコンストラクタ
	public Employee() {
		this.name = "未設定";
		this.employeeId = 0;
	}

	// 引数付きコンストラクタ
	public Employee(String name, int employeeId) {
		this.name = name;
		this.employeeId = employeeId;
	}

	// Getter（従業員名）
	public String getName() {
		return this.name;
	}

	// Getter（従業員ID）
	public int getEmployeeId() {
		return this.employeeId;
	}

	// Setter（従業員名）
	public void setName(String name) {
		this.name = name;
	}

	// Setter（従業員ID）
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}
