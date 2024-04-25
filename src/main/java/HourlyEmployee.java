// Classe HourlyEmployee estende Employee.

public class HourlyEmployee extends Employee {
  private double wage; // salário por hora
  private double hours; // horas trabalhadas durante a semana

  // construtor
  public HourlyEmployee(String firstName, String lastName,
      String socialSecurityNumber, double wage, double hours) {
    super(firstName, lastName, socialSecurityNumber);

    if (wage < 0.0) // valida remuneração
      throw new IllegalArgumentException(
          "Salário por hora deve ser >= 0.0");

    if ((hours < 0.0) || (hours > 168.0)) // valida horas
      throw new IllegalArgumentException(
          "Horas trabalhadas devem ser >= 0.0 and <= 168.0");

    this.wage = wage;
    this.hours = hours;
  }

  // configura a remuneração
  public void setWage(double wage) {
    if (wage < 0.0) // valida remuneração
      throw new IllegalArgumentException(
          "Salário por hora deve ser >= 0.0");
    this.wage = wage;
  }

  // retorna a remuneração
  public double getWage() {
    return wage;
  }

  // configura as horas trabalhadas
  public void setHours(double hours) {
    if ((hours < 0.0) || (hours > 168.0)) // valida horas
      throw new IllegalArgumentException(
          "Horas trabalhadas devem ser >= 0.0 e <= 168.0");

    this.hours = hours;
  }

  // retorna as horas trabalhadas
  public double getHours() {
    return hours;
  }

  // calcula os rendimentos; sobrescreve o método earnings em Employee
  @Override
  public double earnings() {
    if (getHours() <= 40) // nenhuma hora extra
      return getWage() * getHours();
    else
      return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
  }

  // retorna a representação de String do objeto HourlyEmployee
  @Override
  public String toString() {
    return String.format("Funcionário(Employee) horista: %s%n%s: R$%,.2f; %s: %,.2f",
        super.toString(), "Salário por hora", getWage(),
        "horas trabalhadas", getHours());
  }
} // fim da classe HourlyEmployee