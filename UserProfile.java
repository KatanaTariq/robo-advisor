package RoboAdvisor;
public class UserProfile {
    private double monthlySalary;
    private double goalAmount;
    private int periodInMonths;

    // Constructor
    public UserProfile(double monthlySalary, double goalAmount, int periodInMonths) {
        this.monthlySalary = monthlySalary;
        this.goalAmount = goalAmount;
        this.periodInMonths = periodInMonths;
    }

    // Getters
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public int getPeriodInMonths() {
        return periodInMonths;
    }
}
