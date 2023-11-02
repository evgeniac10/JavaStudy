package study7;

public class OverPayCalculator extends BasicPayCalculator {
    private double saturdayWorkHours; // 토요일 근무시간
    private double sundayWorkHours; // 일요일 근무시간

    // 생성자
    public OverPayCalculator(double dayHourlyRate) {
        super(dayHourlyRate);
        this.saturdayWorkHours = 0;
        this.sundayWorkHours = 0;
    }

    // 토요일 근무시간과 일요일 근무시간을 변경하는 setter 메서드
    public void setSaturdayWorkHours(double saturdayWorkHours) {
        this.saturdayWorkHours = saturdayWorkHours;
    }

    public void setSundayWorkHours(double sundayWorkHours) {
        this.sundayWorkHours = sundayWorkHours;
    }

    // 주급을 계산하는 메서드 (오버라이딩)
    @Override
    public double calculateWeeklyPay() {
        double weekdayPay = super.calculateWeeklyPay(); // 평일 근무에 대한 주급 계산

        double saturdayPay = saturdayWorkHours * dayHourlyRate() * 2; // 토요일 근무에 대한 주급 계산
        double sundayPay = sundayWorkHours * dayHourlyRate() * 3; // 일요일 근무에 대한 주급 계산

        double weeklyPay = weekdayPay + saturdayPay + sundayPay; // 평일, 토요일, 일요일 주급을 합산

        return weeklyPay;
    }
}

