package RoboAdvisor;
public class RoboAdvisor {

    public String provideAdvice(UserProfile user) {
        double requiredMonthlySaving = user.getGoalAmount() / user.getPeriodInMonths();
        double percentOfSalary = (requiredMonthlySaving / user.getMonthlySalary()) * 100;
        double annualSavingGoal = requiredMonthlySaving * 12;
        double fiveTimesMonthlySalary = user.getMonthlySalary() * 5;

        StringBuilder advice = new StringBuilder();

        advice.append(String.format(
                "To reach your goal of £%.2f in %d months,%n",
                user.getGoalAmount(), user.getPeriodInMonths()));
        advice.append(String.format(
                "You need to save £%.2f each month, which is %.2f%% of your salary.%n",
                requiredMonthlySaving, percentOfSalary));

        if (percentOfSalary > 50) {
            advice.append("⚠️ Warning: You’re trying to save more than 50% of your monthly salary. This may be unrealistic.\n");
        }

        if (annualSavingGoal > fiveTimesMonthlySalary) {
            advice.append("⚠️ Warning: Your total annual savings goal is more than 5× your monthly salary. Consider adjusting your plan.\n");
        }

        if (percentOfSalary <= 50 && annualSavingGoal <= fiveTimesMonthlySalary) {
            advice.append("✅ Your plan looks reasonable. Stay disciplined and you can reach your goal!\n");
        }

        return advice.toString();
    }
}
