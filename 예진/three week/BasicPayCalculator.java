package study7;

public class BasicPayCalculator {
    private double dayWorkHours; // 평일 근무시간
    private double dayHourlyRate; // 평일 시간당 임금

    // 생성자
    public BasicPayCalculator(double dayHourlyRate) {
        this.dayHourlyRate = dayHourlyRate;
        this.dayWorkHours = 0;
    }

    // 추가 시간을 평일 근무시간에 더하는 메서드
    public void addWeekdayWorkHours(double additionalHours) {
        dayWorkHours += additionalHours;
    }

    // 직원의 평일 근무시간과 평일 시간당 임금을 변경하는 setter 메서드
    public void setWeekdayWorkHours(double weekdayWorkHours) {
        this.dayWorkHours = weekdayWorkHours;
    }

    public void setWeekdayHourlyRate(double dayHourlyRate) {
        this.dayHourlyRate = dayHourlyRate;
    }

    // 주급을 계산하는 메서드
    public double calculateWeeklyPay() {
        double weeklyPay = 0;

        if (dayWorkHours <= 40) {
            weeklyPay = dayHourlyRate * dayWorkHours;
        } else {
            weeklyPay = 40 * dayHourlyRate + (dayWorkHours - 40) * dayHourlyRate * 1.5;
        }

        return weeklyPay;
    }
}
