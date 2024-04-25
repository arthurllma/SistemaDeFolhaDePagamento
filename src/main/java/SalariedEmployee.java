public class SalariedEmployee extends Employee {
  private double weeklySalary;

  // construtor
  public SalariedEmployee(String firstName, String lastName,
      String socialSecurityNumber, double weeklySalary) {
    super(firstName, lastName, socialSecurityNumber);

    if (weeklySalary < 0.0)
      throw new IllegalArgumentException(
          "Salário semanal deve ser >= 0.0");

    this.weeklySalary = weeklySalary;
  }

  // configura o salário
  public void setWeeklySalary(double weeklySalary) {
    if (weeklySalary < 0.0)
      throw new IllegalArgumentException(
          "Salário semanal deve ser >= 0.0");

    this.weeklySalary = weeklySalary;
  }

  // retorna o salário
  public double getWeeklySalary() {
    return weeklySalary;
  }

  // calcula os rendimentos; sobrescreve o método earnings em Employee
  @Override
  public double earnings() {
    return getWeeklySalary();
  }

  // retorna a representação String do objeto SalariedEmployee
  @Override
  public String toString() {
    return String.format("Funcionário(Employee) assalariado: %s%n%s: R$%,.2f",
        super.toString(), "Salário semanal", getWeeklySalary());
  }
}// fim da classe SalariedEmployee