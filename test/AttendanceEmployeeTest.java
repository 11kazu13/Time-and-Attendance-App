package exercise07.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercise07.AttendanceEmployee;
import exercise07.WorkStatus;

/**
 * AttendanceEmployeeクラスの単体テストクラス。
 * 勤怠処理（出勤・退勤）に関する動作を検証する。
 */
public class AttendanceEmployeeTest {

    private AttendanceEmployee emp;

    /**
     * 各テストの前に従業員オブジェクトを生成する。
     */
    @Before
    public void setUp() {
        emp = new AttendanceEmployee("佐藤", 101);
    }

    /**
     * 出勤処理が正しく動作するかのテスト。
     * 出勤時刻とステータスが正しく設定されるかを検証。
     */
    @Test
    public void testClockIn() {
        emp.clockIn("09:00");
        assertEquals("09:00", emp.getStartTime());
        assertEquals(WorkStatus.WORKING, emp.getStatus());
    }

    /**
     * 退勤処理が正しく動作するかのテスト。
     * 出勤後に退勤すると、退勤時刻とステータスが正しく更新されるかを検証。
     */
    @Test
    public void testClockOut() {
        emp.clockIn("09:00");
        emp.clockOut("18:00");
        assertEquals("18:00", emp.getEndTime());
        assertEquals(WorkStatus.LEFT, emp.getStatus());
    }

    /**
     * 出勤処理を2回行った場合に例外が発生するかを検証。
     * 同じ日に2回出勤できない仕様のテスト。
     */
    @Test(expected = IllegalStateException.class)
    public void testClockInTwice() {
        emp.clockIn("09:00");
        emp.clockIn("10:00"); // 2回目の出勤 → 例外発生を期待
    }

    /**
     * 出勤せずに退勤処理を行った場合に例外が発生するかを検証。
     * 不正な状態での退勤が防止されているか確認。
     */
    @Test(expected = IllegalStateException.class)
    public void testClockOutWithoutClockIn() {
        emp.clockOut("17:00"); // 出勤前の退勤 → 例外発生を期待
    }
}
